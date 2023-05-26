package com.example.car_fleet_managment_system.services;

import com.example.car_fleet_managment_system.modules.Admin;
import com.example.car_fleet_managment_system.modules.Conducteur;
import com.example.car_fleet_managment_system.repositories.ConducteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ConducteurServices {

    @Autowired
    private ConducteurRepository conducteurRepository;


    public boolean createConducteur(Conducteur cd) {
        System.out.println(cd.toString());

        try {
            conducteurRepository.save(cd);
            return true;
        } catch (Exception e) {

            return false;
        }
    }
 }
