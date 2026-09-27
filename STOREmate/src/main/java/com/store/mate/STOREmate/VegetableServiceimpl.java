package com.store.mate.STOREmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VegetableServiceimpl implements VegetableService{
    
    @Autowired
    VegetableRepo vegetablerepo;

    @Override
    public List<VegetablesEntity> getAllVegetables(){
        return vegetablerepo.findAll();
    }

    
}
