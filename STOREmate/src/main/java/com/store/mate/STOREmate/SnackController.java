package com.store.mate.STOREmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/snacks")
public class SnackController {
    
    @Autowired
    SnackService snackService;

    @GetMapping("/all")
    public List<SnacksEntity> getAllSnacks(){
        return snackService.getAllSnacks();
    }
    
}
