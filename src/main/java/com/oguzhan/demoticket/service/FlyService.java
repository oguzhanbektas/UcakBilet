package com.oguzhan.demoticket.service;

import com.oguzhan.demoticket.model.Fly;
import com.oguzhan.demoticket.repository.FlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlyService {
    @Autowired
    FlyRepository flyRepository;

    public Optional<Fly> findById(long id){
        return flyRepository.findById(id);
    }
    public Iterable<Fly> findAll(){
        return flyRepository.findAll();
    }
    public Fly save(Fly fly){
        System.out.println("Service --> " + fly);
        return flyRepository.save(fly);
    }
}
