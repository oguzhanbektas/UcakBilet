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
        int quota = ticket.getFly().getAirlineBusiness().getQuota();
        List<Ticket> myList = new ArrayList<>();
        myList = findAll();
        int purchased = 0;
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getFly().getFlyDate() == ticket.getFly().getFlyDate() && myList.get(i).getFly().getRoute() == ticket.getFly().getRoute()) {
                purchased = purchased + 1;
            }
        }
       /* if (quota >= purchased) {
            if (quota / purchased == 1) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.1);
            } else if (quota / purchased == 2) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.2);
            } else if (quota / purchased == 3) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.3);
            } else if (quota / purchased == 4) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.4);
            } else if (quota / purchased == 5) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.5);
            } else if (quota / purchased == 6) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.6);
            } else if (quota / purchased == 7) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.7);
            } else if (quota / purchased == 8) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.8);
            } else if (quota / purchased == 9) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.9);
            } else {
                ticket.setPrice(ticket.getFly().getConstPrice());
            }
            System.out.println(ticket);
        }*/
        return ticketRepository.save(ticket);
    }
}
