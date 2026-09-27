package com.store.mate.STOREmate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdersRepo extends JpaRepository<OrdersEntity, Long> {
    
    @Query("SELECT SUM(o.totalAmount) FROM OrdersEntity o")
    Double getTotalSalesAmount();
}
