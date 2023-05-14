package com.example.car_fleet_managment_system.repositories;

import com.example.car_fleet_managment_system.modules.Vehicule;
import com.example.car_fleet_managment_system.modules.Voyage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoyageRepository extends CrudRepository<Voyage ,Long> {

}
