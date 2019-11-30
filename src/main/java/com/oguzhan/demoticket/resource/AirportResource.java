package com.oguzhan.demoticket.resource;

import com.oguzhan.demoticket.model.Airport;
import com.oguzhan.demoticket.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/airport")
@CrossOrigin
public class AirportResource {

    @Autowired
    AirportService airportService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Airport> allAirport() {
        return airportService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Airport> getAirport(@PathVariable long id) {
        //System.out.println("İd -------------------" + id);
        return airportService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Airport save(Airport airport) {
        return airportService.save(airport);
    }
}
