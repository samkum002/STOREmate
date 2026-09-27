package com.store.mate.STOREmate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private PlaceOrdersServiceImpl transferService;

    // Add item to cart
    @PostMapping("/add")
    public CartResponseMessage addToCart(@RequestBody List<CartDTO> cartDTOList) {
    // Return success or error messages based on the result of adding items
        StringBuilder successMessage = new StringBuilder();
        StringBuilder errorMessage = new StringBuilder();

        // Process each item in the cartDTOList
        for (CartDTO cartDTO : cartDTOList) {
            CartResponseMessage responseMessage = cartService.addToCart(cartDTO);
            if ("success".equals(responseMessage.getStatus())) {
                successMessage.append("Item ").append(cartDTO.getProductName()).append(" added to cart. ");
            } else {
                errorMessage.append("Error adding ").append(cartDTO.getProductName()).append(": ").append(responseMessage.getMessage()).append(" ");
            }
        }

        // Return a combined response for all items
        if (errorMessage.length() > 0) {
            return new CartResponseMessage(errorMessage.toString(), "error");
        }
        return new CartResponseMessage(successMessage.toString(), "success");
    }


    // View user's cart
    @GetMapping("/view")
    public List<CartEntity> viewCart(@RequestParam String userEmail) {
        return cartService.viewCart(userEmail);
    }

    // Remove specific item from cart
    @DeleteMapping("/remove/{id}")
    public CartResponseMessage removeFromCart(@PathVariable Long id, @RequestParam String userEmail) {
        return cartService.removeFromCart(id, userEmail);
    }

    // Place order (final checkout)
    @PostMapping("/place-order")
    public String placeAllOrders() {
        return transferService.transferCartToOrders();
    }

    // ✅ Admin: Update stock for any product
    @PutMapping("/update-stock")
    public CartResponseMessage updateStock(@RequestBody StockUpdateDTO stockUpdateDTO) {
        return cartService.updateStock(stockUpdateDTO);
    }
}
