package com.example.car_fleet_managment_system.repositories;

import com.example.car_fleet_managment_system.modules.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class VhecileService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Iterable<Vehicule> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicule> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Vehicule saveVehicle(Vehicule vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
