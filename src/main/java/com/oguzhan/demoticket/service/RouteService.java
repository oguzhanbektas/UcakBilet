package com.oguzhan.demoticket.service;

import com.oguzhan.demoticket.model.Route;
import com.oguzhan.demoticket.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {
    @Autowired
    RouteRepository routeRepository;

    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    public Optional<Route> findById(long id) {
        return routeRepository.findById(id);
    }

    public Route save(Route route) {
        return routeRepository.save(route);
    }
}
