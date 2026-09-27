package com.store.mate.STOREmate;

import java.util.List;

public interface CartService {

    CartResponseMessage addToCart(CartDTO cartDTO);

    List<CartEntity> viewCart(String userEmail);

    CartResponseMessage removeFromCart(Long id, String userEmail);
    List<CartEntity> getAllOrders();

    CartResponseMessage updateStock(StockUpdateDTO stockUpdateDTO);

}
