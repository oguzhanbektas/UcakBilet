package com.oguzhan.demoticket.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Airport from;
    @OneToOne
    private Airport to;
}
