package com.oguzhan.demoticket.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Müşteri boş olamaz")
    @OneToOne
    private Customer customer;
    @NotEmpty(message = "Uçuş Bilgileri boş olamaz")
    @OneToOne
    private Fly fly;
    private double price;
}
