package com.oguzhan.demoticket.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "İsim boş olamaz")
    private String name;
    @NotNull(message = "Soyad boş olamaz")
    private String surname;
    @NotNull(message = "TC boş olamaz")
    @Column(unique = true, length = 11)
    private String tc;
}