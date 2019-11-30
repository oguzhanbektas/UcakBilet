package com.oguzhan.demoticket.resource;

import com.oguzhan.demoticket.model.Route;
import com.oguzhan.demoticket.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/route")
public class RouteResource {
    @Autowired
    RouteService routeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Route> allRoute() {
        return routeService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Route> getAirport(@PathVariable long id) {
        //System.out.println("İd -------------------" + id);
        return routeService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Route save(@RequestBody @Valid Route route) {
        return routeService.save(route);
    }
}