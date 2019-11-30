package com.oguzhan.demoticket.resource;


import com.oguzhan.demoticket.model.AirlineBusiness;
import com.oguzhan.demoticket.service.AirlineBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airline-business")
public class AirlineBusinessResource {
    @Autowired
    AirlineBusinessService airlineBusinessService;

    @RequestMapping(method = RequestMethod.GET)
    public List<AirlineBusiness> allAirlineBusiness() {
        return airlineBusinessService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<AirlineBusiness> getAirlineBusiness(@PathVariable long id) {
        return airlineBusinessService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AirlineBusiness save(AirlineBusiness airlineBusiness) {
        return airlineBusinessService.save(airlineBusiness);
    }
}
