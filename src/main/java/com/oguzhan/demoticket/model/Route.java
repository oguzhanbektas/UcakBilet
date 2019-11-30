package com.oguzhan.demoticket.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Uçuş Kalkış Yeri boş olamaz")
    @OneToOne
    private Airport from;
    @NotNull(message = "Uçuş İniş Yeri boş olamaz")
    @OneToOne
    private Airport to;
}
