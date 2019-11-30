package com.oguzhan.demoticket.controller;

import com.oguzhan.demoticket.model.Fly;
import com.oguzhan.demoticket.service.FlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/fly")
public class FlyController {

    @Autowired
    FlyService flyService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Fly> allFly() {
        return flyService.findAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Fly> getFly(@PathVariable long id) {
        System.out.println("İd -------------------" + id);
        return flyService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Fly save(@RequestBody @Valid Fly fly) {
        System.out.println(fly);
        return flyService.save(fly);
    }
}
