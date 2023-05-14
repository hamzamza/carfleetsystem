package com.example.car_fleet_managment_system.repositories;

import com.example.car_fleet_managment_system.modules.Voyage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
