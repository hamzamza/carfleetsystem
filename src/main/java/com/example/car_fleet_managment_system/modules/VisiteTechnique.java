package com.example.car_fleet_managment_system.modules;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table( name = "visites_techniques")
@Data
  class VisiteTechnique {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicule vehicle;

    @Column(name = "date_visite")
    private Date date_visite;

    @Column(name = "resultat_visite")
    private String resultat_visite;

}