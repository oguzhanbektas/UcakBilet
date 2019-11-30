package com.oguzhan.demoticket.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Airport {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String name;
}
