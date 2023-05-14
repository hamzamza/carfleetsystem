package com.example.car_fleet_managment_system.modules;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "voyages")
@Data
public class Voyage {

    @Id
    private String id_voyage;

    @Column(name = "distance")
    private float distance;

    @Column(name = "datedebut")
    private Date datedebut;

    @Column(name = "datefin")
    private Date datefin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicule vehicule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conducteur_id", nullable = false)
    private Conducteur conducteur;

}