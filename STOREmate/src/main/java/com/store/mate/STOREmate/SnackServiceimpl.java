package com.store.mate.STOREmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnackServiceimpl implements SnackService{

    @Autowired
    SnackRepo snackRepo;

    @Override
    public List<SnacksEntity> getAllSnacks(){
        return snackRepo.findAll();
    }
    
}
