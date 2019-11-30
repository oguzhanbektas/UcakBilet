package com.oguzhan.demoticket.resource;

import com.oguzhan.demoticket.model.Route;
import com.oguzhan.demoticket.model.Ticket;
import com.oguzhan.demoticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketResource {
    @Autowired
    TicketService ticketService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Ticket> allRoute() {
        return ticketService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Ticket> getAirport(@PathVariable long id) {
        //System.out.println("İd -------------------" + id);
        return ticketService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Ticket save(@RequestBody @Valid Ticket ticket) {
        return ticketService.save(ticket);
    }
}
