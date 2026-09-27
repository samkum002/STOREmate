package com.store.mate.STOREmate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private FruitsRepo fruitsRepo;
    @Autowired
    private VegetableRepo vegetablesRepo;
    @Autowired
    private BeveragesRepo beveragesRepo;
    @Autowired
    private FrozenFoodsRepo frozenFoodsRepo;
    @Autowired
    private GrainsandCerealsRepo grainsAndCerealsRepo;
    @Autowired
    private SnackRepo snacksRepo;
    @Autowired
    private PersonalCareRepo personalCareRepo;

    // Add item to cart
    @Override
    public CartResponseMessage addToCart(CartDTO cartDTO) {
        int availableStock = 0; // <-- move availableStock here
    
        Optional<CartEntity> existingItem = cartRepository.findByUserEmail(cartDTO.getUserEmail())
                .stream()
                .filter(item -> item.getProductName().equals(cartDTO.getProductName()))
                .findFirst();
    
        Optional<?> productEntity = findProductEntityByName(cartDTO.getProductName());
    
        if (productEntity.isPresent()) {
            if (productEntity.get() instanceof FruitsEntity) {
                availableStock = ((FruitsEntity) productEntity.get()).getQuantity();
            } else if (productEntity.get() instanceof VegetablesEntity) {
                availableStock = ((VegetablesEntity) productEntity.get()).getQuantity();
            } else if (productEntity.get() instanceof BeveragesEntity) {
                availableStock = ((BeveragesEntity) productEntity.get()).getQuantity();
            } else if (productEntity.get() instanceof FrozenFoodsEntity) {
                availableStock = ((FrozenFoodsEntity) productEntity.get()).getQuantity();
            } else if (productEntity.get() instanceof GrainsandCerealsEntity) {
                availableStock = ((GrainsandCerealsEntity) productEntity.get()).getQuantity();
            } else if (productEntity.get() instanceof SnacksEntity) {
                availableStock = ((SnacksEntity) productEntity.get()).getQuantity();
            } else if (productEntity.get() instanceof PersonalCareEntity) {
                availableStock = ((PersonalCareEntity) productEntity.get()).getQuantity();
            }
    
            if (availableStock == 0) {
                return new CartResponseMessage("Out of stock!", "error");
            }
        } else {
            return new CartResponseMessage("Product not found.", "error");
        }
    
        if (existingItem.isPresent()) {
            CartEntity item = existingItem.get();
            int updatedQuantity = item.getQuantity() + cartDTO.getQuantity();
    
            if (updatedQuantity > availableStock) {
                return new CartResponseMessage("Requested quantity exceeds available stock.", "error");
            }
    
            item.setQuantity(updatedQuantity);
            item.setTotalAmount(item.getQuantity() * item.getPrice());
            cartRepository.save(item);
            return new CartResponseMessage("Item updated in cart.", "success");
        } else {
            if (cartDTO.getQuantity() > availableStock) {
                return new CartResponseMessage("Requested quantity exceeds available stock.", "error");
            }
    
            CartEntity newItem = new CartEntity();
            newItem.setProductName(cartDTO.getProductName());
            newItem.setQuantity(cartDTO.getQuantity());
            newItem.setPrice(getProductPrice(cartDTO.getProductName()));
            newItem.setTotalAmount(newItem.getQuantity() * newItem.getPrice());
            newItem.setOrderDate(LocalDate.now());
            newItem.setUserEmail(cartDTO.getUserEmail());
            cartRepository.save(newItem);
            return new CartResponseMessage("Item added to cart.", "success");
        }
    }
    

    @Override
    public List<CartEntity> viewCart(String userEmail) {
        return cartRepository.findByUserEmail(userEmail);
    }

    @Override
    public CartResponseMessage removeFromCart(Long id, String userEmail) {
        Optional<CartEntity> cartItem = cartRepository.findById(id);
        if (cartItem.isPresent() && cartItem.get().getUserEmail().equals(userEmail)) {
            cartRepository.delete(cartItem.get());
            return new CartResponseMessage("Item removed from cart.", "success");
        } else {
            return new CartResponseMessage("Item not found or mismatch with user email.", "error");
        }
    }

    @Override
    public List<CartEntity> getAllOrders() {
        return cartRepository.findAll();
    }

    private double getProductPrice(String productName) {
        Optional<?> productEntity = findProductEntityByName(productName);

        if (productEntity.isPresent()) {
            if (productEntity.get() instanceof FruitsEntity) {
                return ((FruitsEntity) productEntity.get()).getPrice();
            } else if (productEntity.get() instanceof VegetablesEntity) {
                return ((VegetablesEntity) productEntity.get()).getPrice();
            } else if (productEntity.get() instanceof BeveragesEntity) {
                return ((BeveragesEntity) productEntity.get()).getPrice();
            } else if (productEntity.get() instanceof FrozenFoodsEntity) {
                return ((FrozenFoodsEntity) productEntity.get()).getPrice();
            } else if (productEntity.get() instanceof GrainsandCerealsEntity) {
                return ((GrainsandCerealsEntity) productEntity.get()).getPrice();
            } else if (productEntity.get() instanceof SnacksEntity) {
                return ((SnacksEntity) productEntity.get()).getPrice();
            } else if (productEntity.get() instanceof PersonalCareEntity) {
                return ((PersonalCareEntity) productEntity.get()).getPrice();
            }
        }
        return 0.0;
    }

    private Optional<?> findProductEntityByName(String product) {
        Optional<?> productEntity = fruitsRepo.findByProduct(product);
        if (productEntity.isPresent()) return productEntity;

        productEntity = vegetablesRepo.findByProduct(product);
        if (productEntity.isPresent()) return productEntity;

        productEntity = beveragesRepo.findByProduct(product);
        if (productEntity.isPresent()) return productEntity;

        productEntity = frozenFoodsRepo.findByProduct(product);
        if (productEntity.isPresent()) return productEntity;

        productEntity = grainsAndCerealsRepo.findByProduct(product);
        if (productEntity.isPresent()) return productEntity;

        productEntity = snacksRepo.findByProduct(product);
        if (productEntity.isPresent()) return productEntity;

        return personalCareRepo.findByProduct(product);
    }

    // private void updateStock(CartEntity cartItem) {
    //     String productName = cartItem.getProduct();
    //     int quantity = cartItem.getQuantity();

    //     Optional<?> productEntity = findProductEntityByName(productName);
    //     if (productEntity.isPresent()) {
    //         if (productEntity.get() instanceof FruitsEntity) {
    //             FruitsEntity product = (FruitsEntity) productEntity.get();
    //             product.setQuantity(product.getQuantity() - quantity);
    //             fruitsRepo.save(product);
    //         } else if (productEntity.get() instanceof VegetablesEntity) {
    //             VegetablesEntity product = (VegetablesEntity) productEntity.get();
    //             product.setQuantity(product.getQuantity() - quantity);
    //             vegetablesRepo.save(product);
    //         } else if (productEntity.get() instanceof BeveragesEntity) {
    //             BeveragesEntity product = (BeveragesEntity) productEntity.get();
    //             product.setQuantity(product.getQuantity() - quantity);
    //             beveragesRepo.save(product);
    //         } else if (productEntity.get() instanceof FrozenFoodsEntity) {
    //             FrozenFoodsEntity product = (FrozenFoodsEntity) productEntity.get();
    //             product.setQuantity(product.getQuantity() - quantity);
    //             frozenFoodsRepo.save(product);
    //         } else if (productEntity.get() instanceof GrainsandCerealsEntity) {
    //             GrainsandCerealsEntity product = (GrainsandCerealsEntity) productEntity.get();
    //             product.setQuantity(product.getQuantity() - quantity);
    //             grainsAndCerealsRepo.save(product);
    //         } else if (productEntity.get() instanceof SnacksEntity) {
    //             SnacksEntity product = (SnacksEntity) productEntity.get();
    //             product.setQuantity(product.getQuantity() - quantity);
    //             snacksRepo.save(product);
    //         } else if (productEntity.get() instanceof PersonalCareEntity) {
    //             PersonalCareEntity product = (PersonalCareEntity) productEntity.get();
    //             product.setQuantity(product.getQuantity() - quantity);
    //             personalCareRepo.save(product);
    //         }
    //     }
    // }

    // Admin: Update stock of a product
    @Override
    public CartResponseMessage updateStock(StockUpdateDTO dto) {
        Optional<?> productEntity = findProductEntityByName(dto.getProductName());
        if (productEntity.isEmpty()) {
            return new CartResponseMessage("Product not found.", "error");
        }

        Object product = productEntity.get();

        if (product instanceof FruitsEntity) {
            FruitsEntity p = (FruitsEntity) product;
            p.setQuantity(p.getQuantity() + dto.getQuantityToAdd());
            fruitsRepo.save(p);
        } else if (product instanceof VegetablesEntity) {
            VegetablesEntity p = (VegetablesEntity) product;
            p.setQuantity(p.getQuantity() + dto.getQuantityToAdd());
            vegetablesRepo.save(p);
        } else if (product instanceof BeveragesEntity) {
            BeveragesEntity p = (BeveragesEntity) product;
            p.setQuantity(p.getQuantity() + dto.getQuantityToAdd());
            beveragesRepo.save(p);
        } else if (product instanceof FrozenFoodsEntity) {
            FrozenFoodsEntity p = (FrozenFoodsEntity) product;
            p.setQuantity(p.getQuantity() + dto.getQuantityToAdd());
            frozenFoodsRepo.save(p);
        } else if (product instanceof GrainsandCerealsEntity) {
            GrainsandCerealsEntity p = (GrainsandCerealsEntity) product;
            p.setQuantity(p.getQuantity() + dto.getQuantityToAdd());
            grainsAndCerealsRepo.save(p);
        } else if (product instanceof SnacksEntity) {
            SnacksEntity p = (SnacksEntity) product;
            p.setQuantity(p.getQuantity() + dto.getQuantityToAdd());
            snacksRepo.save(p);
        } else if (product instanceof PersonalCareEntity) {
            PersonalCareEntity p = (PersonalCareEntity) product;
            p.setQuantity(p.getQuantity() + dto.getQuantityToAdd());
            personalCareRepo.save(p);
        }

        return new CartResponseMessage("Stock updated successfully.", "success");
    }
}
