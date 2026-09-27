package com.store.mate.STOREmate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LowStockItem {
    private String product;         
    private int quantity;          
    private int threshold;
}
