package com.store.mate.STOREmate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
               
    private String productName;     
    private int quantity;           
    private double price;           
    private String userEmail;       
}
