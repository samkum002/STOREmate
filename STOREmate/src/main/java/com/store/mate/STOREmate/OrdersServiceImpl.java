package com.store.mate.STOREmate;

import org.springframework.beans.factory.annotation.Autowired;

public class OrdersServiceImpl implements OrdersService{

    @Autowired
    OrdersRepo ordersRepo;

    @Override
    public Double getTotalSales() {
        Double total = ordersRepo.getTotalSalesAmount();
        return total != null ? total : 0.0;
    }
    
}
