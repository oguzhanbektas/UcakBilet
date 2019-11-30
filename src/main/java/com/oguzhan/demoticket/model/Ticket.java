package com.oguzhan.demoticket.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Customer customer;
    @OneToOne
    private Fly fly;
    private double price;
}
