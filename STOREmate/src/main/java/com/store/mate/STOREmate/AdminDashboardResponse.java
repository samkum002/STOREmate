package com.store.mate.STOREmate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDashboardResponse {
    private Double totalSales;
    private List<OrdersEntity> allOrders;
    private List<LowStockItem> lowStockItems;
    private List<String> stockStatusMessages;
}
