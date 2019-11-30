package com.oguzhan.demoticket.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Müşteri boş olamaz")
    @OneToOne
    private Customer customer;
    @NotNull(message = "Uçuş Bilgileri boş olamaz")
    @OneToOne
    private Fly fly;
    private double price;
    private String pnr;
}
