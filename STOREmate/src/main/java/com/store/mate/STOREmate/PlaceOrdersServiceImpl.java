package com.store.mate.STOREmate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceOrdersServiceImpl {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired private FruitsRepo fruitsRepo;
    @Autowired private VegetableRepo vegetablesRepo;
    @Autowired private FrozenFoodsRepo frozenFoodsRepo;
    @Autowired private GrainsandCerealsRepo grainsCerealsRepo;
    @Autowired private SnackRepo snacksRepo;
    @Autowired private PersonalCareRepo personalCareRepo;
    @Autowired private BeveragesRepo beveragesRepo;

    @Transactional
    public String transferCartToOrders() {
        List<CartEntity> cartItems = cartRepo.findAll();

        // Check if the cart is empty
        if (cartItems.isEmpty()) {
            return "Your cart is empty. Please add items to the cart before placing an order.";
        }

        double totalBill = 0.0;

        for (CartEntity item : cartItems) {
            // 1. Save to orders table
            OrdersEntity order = new OrdersEntity(item);
            ordersRepo.save(order);

            // 2. Update stock from matching repo
            String productName = item.getProductName();  // Use product name from cart item
            int quantityOrdered = item.getQuantity();
            boolean updated = false;

            updated |= updateStock(fruitsRepo.findByProduct(productName), quantityOrdered, fruitsRepo);
            updated |= updateStock(vegetablesRepo.findByProduct(productName), quantityOrdered, vegetablesRepo);
            updated |= updateStock(frozenFoodsRepo.findByProduct(productName), quantityOrdered, frozenFoodsRepo);
            updated |= updateStock(grainsCerealsRepo.findByProduct(productName), quantityOrdered, grainsCerealsRepo);
            updated |= updateStock(snacksRepo.findByProduct(productName), quantityOrdered, snacksRepo);
            updated |= updateStock(personalCareRepo.findByProduct(productName), quantityOrdered, personalCareRepo);
            updated |= updateStock(beveragesRepo.findByProduct(productName), quantityOrdered, beveragesRepo);

            if (!updated) {
                System.out.println("Stock not updated for: " + productName);
            }

            // 3. Add to total bill
            totalBill += item.getTotalAmount();
        }

        // 4. Clear cart
        cartRepo.deleteAll();

        return "Order placed! Your total bill is ₹" + totalBill + ". Be ready with cash.";
    }

    private <T> boolean updateStock(Optional<T> productOpt, int quantityToReduce, JpaRepository<T, Long> repo) {
        if (productOpt.isPresent()) {
            T product = productOpt.get();
            try {
                // Use reflection to invoke the getter and setter methods dynamically
                var getQty = product.getClass().getMethod("getQuantity");
                var setQty = product.getClass().getMethod("setQuantity", Integer.class);

                // Get current quantity
                Integer currentQty = (Integer) getQty.invoke(product);

                System.out.println("Current stock for " + product + ": " + currentQty);  // Debugging line

                if (currentQty < quantityToReduce) {
                    System.out.println("Not enough stock for " + product);
                    return false;
                }

                // Reduce stock by quantityToReduce
                setQty.invoke(product, currentQty - quantityToReduce);
                System.out.println("Updated stock for " + product + ": " + (currentQty - quantityToReduce));  // Debugging line

                // Save the updated product back to the database
                repo.save(product); // Ensure the correct entity is being saved

                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
