package com.oguzhan.demoticket.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Fly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double constPrice;
    @OneToOne
    private AirlineBusiness airlineBusiness;
    @OneToOne
    private Route route;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date flyDate;
}
