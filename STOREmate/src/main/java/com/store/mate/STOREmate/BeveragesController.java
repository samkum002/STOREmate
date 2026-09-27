package com.store.mate.STOREmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/beverages")
public class BeveragesController {
    
    @Autowired
    BeveragesService beveragesService;

    @GetMapping("/all")
    public List<BeveragesEntity> getAllBeverages() {
        return beveragesService.getAllBeverages();
    }
    
}
