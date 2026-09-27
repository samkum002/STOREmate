package com.store.mate.STOREmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrainsandCerealsServiceimpl implements GrainsandCerealsService{
    
    @Autowired
    GrainsandCerealsRepo grainsrepo;

    @Override
    public List<GrainsandCerealsEntity> getAllGrains(){
        return grainsrepo.findAll();
    }
}
