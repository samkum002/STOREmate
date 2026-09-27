package com.store.mate.STOREmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal")
public class PersonalCareController {
    
    @Autowired
    private PersonalCareService personalCareService;

    @GetMapping("/all")
    public List<PersonalCareEntity> getAllPersonal() {
        return personalCareService.getAllPersonal();
    }
}
