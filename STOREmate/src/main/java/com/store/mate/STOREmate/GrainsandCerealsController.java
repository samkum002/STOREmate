package com.store.mate.STOREmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GrainsAndCereals")
public class GrainsandCerealsController {
    
    @Autowired
    GrainsandCerealsService grainsService;

    @GetMapping("/all")
    public List<GrainsandCerealsEntity> getAllGrains(){
        return grainsService.getAllGrains();
    }
}