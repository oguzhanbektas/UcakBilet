package com.oguzhan.demoticket.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "İsim boş olamaz")
    private String name;
    @NotEmpty(message = "Soyad boş olamaz")
    private String surname;
    @NotEmpty(message = "Soyad boş olamaz")
    @Column(unique = true, length = 11)
    private String tc;
}