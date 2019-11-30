package com.oguzhan.demoticket.service;

import com.oguzhan.demoticket.model.Route;
import com.oguzhan.demoticket.model.Ticket;
import com.oguzhan.demoticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> findById(long id) {
        return ticketRepository.findById(id);
    }

    public Ticket save(Ticket ticket) {
        Ticket newTicket = new Ticket();
        newTicket.setId(ticket.getId());
        newTicket.setCustomer(ticket.getCustomer());
        newTicket.setFly(ticket.getFly());
        int quota = ticket.getFly().getAirlineBusiness().getQuota();
        //ArrayList<Ticket> purchasedTickets = new ArrayList<Ticket>();
        // purchasedTickets.add((Ticket) findAll());
        //System.out.println(purchasedTickets);
        List<Ticket> myList = new ArrayList<>();
        myList = findAll();
        int purchased = 0;
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getFly().getFlyDate() == ticket.getFly().getFlyDate() && myList.get(i).getFly().getRoute() == ticket.getFly().getRoute())
                purchased++;
        }
        //ticket.setFly();
        if (quota >= purchased) {
            if (quota / purchased == 1)
                newTicket.setPrice(ticket.getPrice() * 1.1);
            else if (quota / purchased == 2)
                newTicket.setPrice(ticket.getPrice() * 1.2);
            else if (quota / purchased == 3)
                newTicket.setPrice(ticket.getPrice() * 1.2);
            else if (quota / purchased == 4)
                newTicket.setPrice(ticket.getPrice() * 1.2);
            else if (quota / purchased == 5)
                newTicket.setPrice(ticket.getPrice() * 1.2);
            else if (quota / purchased == 6)
                newTicket.setPrice(ticket.getPrice() * 1.2);
            else if (quota / purchased == 7)
                newTicket.setPrice(ticket.getPrice() * 1.2);
            else if (quota / purchased == 8)
                newTicket.setPrice(ticket.getPrice() * 1.2);
            else if (quota / purchased == 9)
                newTicket.setPrice(ticket.getPrice() * 1.2);
            else
                newTicket.setPrice(ticket.getPrice());
            return ticketRepository.save(newTicket);
        } else return null;
    }
}
