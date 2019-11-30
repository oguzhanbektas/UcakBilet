package com.oguzhan.demoticket.controller;

import com.oguzhan.demoticket.model.Ticket;
import com.oguzhan.demoticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Ticket> allTicket() {
        return ticketService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Ticket> getTicket(@PathVariable long id) {
        return ticketService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Ticket save(@RequestBody @Valid Ticket ticket) {
        return ticketService.save(ticket);
    }
}
