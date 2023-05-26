package com.example.car_fleet_managment_system.services;

import com.example.car_fleet_managment_system.modules.Voyage;
import com.example.car_fleet_managment_system.repositories.VoyageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoyageService {
    @Autowired
    private VoyageRepository voyageRepository;

    public Iterable<Voyage> getAllVoyages() {
        return voyageRepository.findAll();
    }

    public Voyage getVoyageById(Long id) {
        return voyageRepository.findById(id).orElse(null);
    }

    public Voyage saveVoyage(Voyage voyage) {
        return voyageRepository.save(voyage);
    }

    public void deleteVoyageById(Long id) {
        voyageRepository.deleteById(id);
    }
}
