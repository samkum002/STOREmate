package com.store.mate.STOREmate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Beverages")
public class BeveragesEntity {
    @Id
    private Long id;
    private String product;
    private Double priceperbottle;
    @Column(name = "quantity")
    private Integer Quantity;
    @JsonIgnore
    private Integer threshold;

    public double getPrice() {
        return priceperbottle;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public String getProduct() {
        return product;
    }
}
