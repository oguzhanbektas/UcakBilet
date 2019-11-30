package com.oguzhan.demoticket.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class AirlineBusiness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "İsim boş olamaz")
    private String name;
    @NotEmpty(message = "Model boş olamaz")
    private String model;
    @NotEmpty(message = "Kontenjan boş olamaz")
    private int quota;


}
