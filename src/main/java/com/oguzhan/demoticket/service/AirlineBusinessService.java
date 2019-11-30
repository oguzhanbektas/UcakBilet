package com.oguzhan.demoticket.service;

import com.oguzhan.demoticket.model.AirlineBusiness;
import com.oguzhan.demoticket.repository.AirlineBusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineBusinessService {

    @Autowired
    AirlineBusinessRepository airlineBusinessRepository;

    public List<AirlineBusiness> findAll() {
        return airlineBusinessRepository.findAll();
    }

    public Optional<AirlineBusiness> findById(long id) {
        return airlineBusinessRepository.findById(id);
    }

    public AirlineBusiness save(AirlineBusiness airlineBusiness){
        return airlineBusinessRepository.save(airlineBusiness);
    }
}
