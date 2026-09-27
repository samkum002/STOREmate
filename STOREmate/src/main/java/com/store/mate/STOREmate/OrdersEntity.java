package com.store.mate.STOREmate;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int quantity;
    private double price;
    private double totalAmount;
    private LocalDate orderDate;
    private String userEmail;

    public OrdersEntity(CartEntity cart) {
        this.productName = cart.getProductName();
        this.quantity = cart.getQuantity();
        this.price = cart.getPrice();
        this.totalAmount = cart.getTotalAmount();
        this.orderDate = cart.getOrderDate();
        this.userEmail = cart.getUserEmail();
    }
    
}
