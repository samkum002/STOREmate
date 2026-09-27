package com.store.mate.STOREmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/frozen")
public class FrozenFoodsController {
    
    @Autowired
    FrozenFoodsService frozenService;

    @GetMapping("/all")
    public List<FrozenFoodsEntity> getAllFrozen(){
        return frozenService.getAllFrozen();
    }
    
}
