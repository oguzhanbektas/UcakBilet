package com.oguzhan.demoticket.controller;

import com.oguzhan.demoticket.model.Airport;
import com.oguzhan.demoticket.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/airport")
@CrossOrigin
public class AirportController {

    @Autowired
    AirportService airportService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Airport> allAirport() {
        return airportService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Airport> getAirport(@PathVariable long id) {
        return airportService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Airport save(@RequestBody @Valid Airport airport) {
        return airportService.save(airport);
    }
}
