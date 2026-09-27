package com.store.mate.STOREmate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDashboardServiceImpl implements AdminDashboardService {
    
    @Autowired
    private OrdersRepo ordersRepo;

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

    @Override
    public AdminDashboardResponse getDashboardData() {
        // Get the total sales
        Double totalSales = ordersRepo.getTotalSalesAmount();
        if (totalSales == null) totalSales = 0.0;

        // Get all the orders...
        List<OrdersEntity> allOrders = ordersRepo.findAll();

        // List for low stock items
        List<LowStockItem> lowStockItems = new ArrayList<>();
        List<String> stockMessages = new ArrayList<>();

        // Check Fruits stock
        fruitsRepo.findAll().forEach(item -> {
            if (item.getQuantity() < item.getThreshold()) {
                LowStockItem lowItem = new LowStockItem(item.getProduct(), item.getQuantity(), item.getThreshold());
                lowStockItems.add(lowItem);

                String msg = "The item '" + item.getProduct() + "' from Fruits category is low in stock. Please update.";
                stockMessages.add(msg);
            }
        });

        // Check Vegetables stock
        vegetablesRepo.findAll().forEach(item -> {
            if (item.getQuantity() < item.getThreshold()) {
                LowStockItem lowItem = new LowStockItem(item.getProduct(), item.getQuantity(), item.getThreshold());
                lowStockItems.add(lowItem);

                String msg = "The item '" + item.getProduct() + "' from Vegetables category is low in stock. Please update.";
                stockMessages.add(msg);
            }
        });

        // Check Beverages stock
        beveragesRepo.findAll().forEach(item -> {
            if (item.getQuantity() < item.getThreshold()) {
                LowStockItem lowItem = new LowStockItem(item.getProduct(), item.getQuantity(), item.getThreshold());
                lowStockItems.add(lowItem);

                String msg = "The item '" + item.getProduct() + "' from Beverages category is low in stock. Please update.";
                stockMessages.add(msg);
            }
        });

        // Check Frozen Foods stock
        frozenFoodsRepo.findAll().forEach(item -> {
            if (item.getQuantity() < item.getThreshold()) {
                LowStockItem lowItem = new LowStockItem(item.getProduct(), item.getQuantity(), item.getThreshold());
                lowStockItems.add(lowItem);

                String msg = "The item '" + item.getProduct() + "' from Frozen Foods category is low in stock. Please update.";
                stockMessages.add(msg);
            }
        });

        // Check Grains and Cereals stock
        grainsAndCerealsRepo.findAll().forEach(item -> {
            if (item.getQuantity() < item.getThreshold()) {
                LowStockItem lowItem = new LowStockItem(item.getProduct(), item.getQuantity(), item.getThreshold());
                lowStockItems.add(lowItem);

                String msg = "The item '" + item.getProduct() + "' from Grains and Cereals category is low in stock. Please update.";
                stockMessages.add(msg);
            }
        });

        // Check Snacks stock
        snacksRepo.findAll().forEach(item -> {
            if (item.getQuantity() < item.getThreshold()) {
                LowStockItem lowItem = new LowStockItem(item.getProduct(), item.getQuantity(), item.getThreshold());
                lowStockItems.add(lowItem);

                String msg = "The item '" + item.getProduct() + "' from Snacks category is low in stock. Please update.";
                stockMessages.add(msg);
            }
        });

        // Check Personal Care stock
        personalCareRepo.findAll().forEach(item -> {
            if (item.getQuantity() < item.getThreshold()) {
                LowStockItem lowItem = new LowStockItem(item.getProduct(), item.getQuantity(), item.getThreshold());
                lowStockItems.add(lowItem);

                String msg = "The item '" + item.getProduct() + "' from Personal Care category is low in stock. Please update.";
                stockMessages.add(msg);
            }
        });

        // If no items are low in stock
        if (stockMessages.isEmpty()) {
            stockMessages.add("All items are sufficiently stocked.");
        }

        return new AdminDashboardResponse(totalSales, allOrders, lowStockItems, stockMessages);
    }
}
