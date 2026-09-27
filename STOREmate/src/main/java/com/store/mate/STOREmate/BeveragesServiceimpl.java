package com.store.mate.STOREmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeveragesServiceimpl implements BeveragesService{

    @Autowired
    BeveragesRepo beveragesRepo;

    @Override
    public List<BeveragesEntity> getAllBeverages(){
        return beveragesRepo.findAll();
    }
    
}
