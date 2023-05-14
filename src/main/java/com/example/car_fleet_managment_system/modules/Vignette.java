package com.example.car_fleet_managment_system.modules;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "vignettes")
@Data
  class Vignette {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "numero_vignette")
    private String numeroVignette;

    @Column(name = "date_debut_validite")
    private Date dateDebutValidite;

    @Column(name = "date_fin_validite")
    private Date dateFinValidite;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicule vehicule;

}
