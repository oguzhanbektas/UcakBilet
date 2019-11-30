package com.oguzhan.demoticket.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class AirlineBusiness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "İsim boş olamaz")
    private String name;
    @NotNull(message = "Model boş olamaz")
    private String model;
    @NotNull(message = "Kontenjan boş olamaz")
    private int quota;


}
