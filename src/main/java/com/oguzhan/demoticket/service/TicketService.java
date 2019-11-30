package com.oguzhan.demoticket.service;

import com.oguzhan.demoticket.model.Route;
import com.oguzhan.demoticket.model.Ticket;
import com.oguzhan.demoticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> findByPnr(String pnr) {
        return ticketRepository.findByPnr(pnr);
    }

    public Optional<Ticket> findById(long id) {
        return ticketRepository.findById(id);
    }

    public Ticket save(Ticket ticket) {
        int quota = ticket.getFly().getAirlineBusiness().getQuota();
        List<Ticket> myList = new ArrayList<>();
        myList = findAll();
        int purchased = 0;
        //Normalde if içinde bütün herşeyin And olması lazım ama date türünü eşleştirirken sıkıntı yaşadığım için Kontenjan çalışıyor mu diye
        //Sadece Fly > Fro ve To kontrolü yapılmıştır.
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getFly().getFlyDate().equals(ticket.getFly().getFlyDate()) || myList.get(i).getFly().getRoute().getFrom().equals(ticket.getFly().getRoute().getFrom()) && myList.get(i).getFly().getRoute().getTo().equals(ticket.getFly().getRoute().getTo())) {
                purchased = purchased + 1;
            }
        }
        //PNR Oluşturma
        //Kurallar --> Uçak Model + Rotanın Nereden Nereye Gideceği +Müşteri TC si
        ticket.setPnr(ticket.getFly().getAirlineBusiness().getModel() + ticket.getFly().getRoute().getFrom().getId() + ticket.getFly().getRoute().getTo().getId() + ticket.getCustomer().getTc());
        if (quota >= purchased) {
            if ((100 * purchased) / quota > 89) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.9);
            } else if ((100 * purchased) / quota < 90 && (100 * purchased) / quota > 79) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.8);
            } else if ((100 * purchased) / quota < 80 && (100 * purchased) / quota > 69) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.7);
            } else if ((100 * purchased) / quota < 70 && (100 * purchased) / quota > 59) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.6);
            } else if ((100 * purchased) / quota < 60 && (100 * purchased) / quota > 49) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.5);
            } else if ((100 * purchased) / quota < 50 && (100 * purchased) / quota > 39) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.4);
            } else if ((100 * purchased) / quota < 40 && (100 * purchased) / quota > 29) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.3);
            } else if ((100 * purchased) / quota < 30 && (100 * purchased) / quota > 19) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.2);
            } else if ((100 * purchased) / quota < 20 && (100 * purchased) / quota > 9) {
                ticket.setPrice(ticket.getFly().getConstPrice() * 1.1);
            } else {
                ticket.setPrice(ticket.getFly().getConstPrice());
            }
        }
        return ticketRepository.save(ticket);
    }
}
