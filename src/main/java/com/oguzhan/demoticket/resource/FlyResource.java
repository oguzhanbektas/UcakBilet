package com.oguzhan.demoticket.resource;

import com.oguzhan.demoticket.model.Airport;
import com.oguzhan.demoticket.model.Fly;
import com.oguzhan.demoticket.service.FlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/fly")
public class FlyResource {

    @Autowired
    FlyService flyService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Fly> allAirport() {
        return flyService.findAll();
    }

  /*  @RequestMapping(method = RequestMethod.GET)
    public String a(){
        return "aaa";
    }*/

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Fly> getAirport(@PathVariable long id) {
        System.out.println("İd -------------------" + id);
        return flyService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Fly save(@RequestBody @Valid Fly fly) {
        System.out.println(fly);
        return flyService.save(fly);
    }
}
