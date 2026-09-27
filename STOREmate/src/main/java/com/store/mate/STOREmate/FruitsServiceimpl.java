package com.store.mate.STOREmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitsServiceimpl implements FruitsService{
    
    @Autowired
    FruitsRepo fruitsrepo;

    @Override
    public List<FruitsEntity> getAllFruits(){
        return fruitsrepo.findAll();
    }
}
