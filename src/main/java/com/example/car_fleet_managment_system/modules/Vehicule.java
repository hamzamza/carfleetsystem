package com.example.car_fleet_managment_system.modules;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 ;

@Entity
@Table(name = "vehicles")
@Data
public
class Vehicule {

    @Id
    private String id;

    @Column(name = "marke")
    private String marque;

    @Column(name = "model")
    private String modèle;

    @Column(name = "year")
    private int année;

    @Column(name = "average_consumption")
    private float consommation_moyenne;

    @Column(name = "total_mileage")
    private float kilométrage_total;

}