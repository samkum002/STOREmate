package com.store.mate.STOREmate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalCareServiceimpl implements PersonalCareService{
    
    @Autowired
    PersonalCareRepo personalCare;

    @Override
    public List<PersonalCareEntity> getAllPersonal(){
        return personalCare.findAll();
    }
}
