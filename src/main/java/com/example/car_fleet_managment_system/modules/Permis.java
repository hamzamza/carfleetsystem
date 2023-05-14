package com.example.car_fleet_managment_system.modules;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "permis")
@Data
public class Permis {

    @Id
    @Column(name = "id_permis")
    private String idPermis;

    @Column(name = "type")
    private String type;

    @Column(name = "date_obtention")
    private Date dateObtention;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conducteur")
    private Conducteur conducteur;

}