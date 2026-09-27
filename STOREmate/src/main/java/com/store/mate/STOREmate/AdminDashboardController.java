package com.store.mate.STOREmate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/page")
public class AdminDashboardController {

    @Autowired
    private AdminDashboardService adminDashboardService;

    // Endpoint to fetch admin dashboard data
    @GetMapping("/admin/dashboard")
    public AdminDashboardResponse getDashboardData() {
        return adminDashboardService.getDashboardData();
    }
}
