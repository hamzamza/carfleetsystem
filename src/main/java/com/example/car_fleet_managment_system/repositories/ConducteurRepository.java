package com.example.car_fleet_managment_system.repositories;

import com.example.car_fleet_managment_system.modules.Conducteur;
import com.example.car_fleet_managment_system.modules.Vehicule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConducteurRepository  extends CrudRepository<Conducteur, Long> {
    Conducteur findByNom(String username) ;
}
