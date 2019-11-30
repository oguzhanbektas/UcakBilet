package com.oguzhan.demoticket.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
public class Fly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Sabit ücret boş olamaz")
    private double constPrice;
    @NotEmpty(message = "Havayolu Şirketi boş olamaz")
    @OneToOne
    private AirlineBusiness airlineBusiness;
    @NotEmpty(message = "Rota boş olamaz")
    @OneToOne
    private Route route;
    @NotEmpty(message = "Uçuş Tarihi boş olamaz")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date flyDate;
}
