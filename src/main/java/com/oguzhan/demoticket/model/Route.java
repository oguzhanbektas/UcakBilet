package com.oguzhan.demoticket.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Uçuş Kalkış Yeri boş olamaz")
    @OneToOne
    private Airport from;
    @NotEmpty(message = "Uçuş İniş Yeri boş olamaz")
    @OneToOne
    private Airport to;
}
