package com.store.mate.STOREmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vegetables")
public class VegetableController {
    
    @Autowired
    VegetableService vegetableservice;

    @GetMapping("/all")
    public List<VegetablesEntity> getAllVegetables(){
        return vegetableservice.getAllVegetables();
    }
}
