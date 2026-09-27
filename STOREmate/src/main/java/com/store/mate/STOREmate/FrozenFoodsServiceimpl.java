package com.store.mate.STOREmate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrozenFoodsServiceimpl implements FrozenFoodsService{
    
    @Autowired
    FrozenFoodsRepo frozenFood;

    @Override
    public List<FrozenFoodsEntity> getAllFrozen(){
        return frozenFood.findAll();
    }
}
