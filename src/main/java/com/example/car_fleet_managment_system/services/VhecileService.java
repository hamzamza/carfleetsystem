package com.example.car_fleet_managment_system.services;

import com.example.car_fleet_managment_system.modules.Vehicule;
import com.example.car_fleet_managment_system.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class VhecileService {

    @Autowired
    private VehicleRepository vehicleRepository;


}
