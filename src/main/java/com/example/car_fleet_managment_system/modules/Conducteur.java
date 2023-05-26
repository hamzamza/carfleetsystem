package com.example.car_fleet_managment_system.modules;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Entity
@Table(name = "conducteurs")
@Data
public
class Conducteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column
    private String CIN;

    @Column(name = "nom")
    private String nom;
    @Column(name = "password")
    private String password ;
    @Column(name = "matricule")
    private String matricule;

    @Column(name = "date_naissance")
    private Date date_naissance;

}