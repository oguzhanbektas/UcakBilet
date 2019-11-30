package com.oguzhan.demoticket.service;

import com.oguzhan.demoticket.model.Airport;
import com.oguzhan.demoticket.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public Optional<Airport> findById(long id){
        return airportRepository.findById(id);
    }
    public Iterable<Airport> findAll(){
        return airportRepository.findAll();
    }
    public Airport save(Airport airport){
        return airportRepository.save(airport);
    }
}
