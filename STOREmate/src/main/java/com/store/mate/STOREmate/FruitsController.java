package com.store.mate.STOREmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fruits")
public class FruitsController {
    
    @Autowired
    private FruitsService fruitsService;

    @GetMapping("/all")
    public List<FruitsEntity> getAllFruits() {
        return fruitsService.getAllFruits();
    }
}
