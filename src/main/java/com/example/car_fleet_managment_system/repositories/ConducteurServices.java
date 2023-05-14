package com.example.car_fleet_managment_system.repositories;

import com.example.car_fleet_managment_system.modules.Conducteur;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ConducteurServices {
    @Autowired
    private ConducteurRepository conducteurRepository;

    public Iterable<Conducteur> getAllConducteurs() {
        return conducteurRepository.findAll();
    }

    public Optional<Conducteur> getConducteurById(long id) {
        return conducteurRepository.findById(id);
    }

    public Conducteur addConducteur(Conducteur conducteur) {
        return conducteurRepository.save(conducteur);
    }
}
