package com.example.car_fleet_managment_system.services;
import com.example.car_fleet_managment_system.modules.Conducteur;
import com.example.car_fleet_managment_system.modules.Vehicule;
import com.example.car_fleet_managment_system.modules.Voyage;
import com.example.car_fleet_managment_system.repositories.ConducteurRepository;
import com.example.car_fleet_managment_system.repositories.VehicleRepository;
import com.example.car_fleet_managment_system.repositories.VoyageRepository;
import com.example.car_fleet_managment_system.utils.Mymap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
 @Service
public class Availability {
     @Autowired
     VoyageService voyageService;
     @Autowired
     ConducteurRepository conducteurRepository ;
     @Autowired
     VehicleRepository vehicleRepository ;
     @Autowired
     ConducteurServices conducteurServices ;
     public Mymap getConducteursAndVehiculesByVoyageDate(Date dateDebut, Date dateFin) {
         List<Voyage> voyages = (List<Voyage>) voyageService.getAllVoyages();

         List<Conducteur> conducteurs = new ArrayList<>();
         List<Vehicule> vehicules = new ArrayList<>();

         for (Voyage voyage : voyages) {
             if (voyage.getDatedebut().compareTo(dateFin) <= 0 && voyage.getDatefin().compareTo(dateDebut) >= 0) {
                 conducteurs.add(voyage.getConducteur());
                 vehicules.add(voyage.getVehicule());
             }
         }

         Mymap conducteursAndVehicules = new Mymap();
         conducteursAndVehicules.setConducteur(conducteurs);
         conducteursAndVehicules.setVehicules(vehicules);

         return conducteursAndVehicules;
     }

     public Mymap getNewConducteursAndVehicules(Date startDate, Date endDate) {
         // Get conducteurs and vehicules from the database
         List<Conducteur> conducteurs = (List<Conducteur>) conducteurRepository.findAll();
         List<Vehicule> vehicules = (List<Vehicule>) vehicleRepository.findAll();

         // Get conducteurs and vehicules from getConducteursAndVehiculesByVoyageDate function
         Mymap conducteursAndVehiculesByVoyageDate = getConducteursAndVehiculesByVoyageDate(startDate, endDate);
         List<Conducteur> conducteursToRemove = conducteursAndVehiculesByVoyageDate.getConducteur();
         List<Vehicule> vehiculesToRemove = conducteursAndVehiculesByVoyageDate.getVehicules();

         // Create new lists of conducteurs and vehicules that do not belong to the previous map
         List<Conducteur> newConducteurs = conducteurs.stream()
                 .filter(conducteur -> !conducteursToRemove.contains(conducteur))
                 .collect(Collectors.toList());
         List<Vehicule> newVehicules = vehicules.stream()
                 .filter(vehicule -> !vehiculesToRemove.contains(vehicule))
                 .collect(Collectors.toList());

         Mymap newConducteursAndVehicules = new Mymap();
         newConducteursAndVehicules.setConducteur(newConducteurs);
         newConducteursAndVehicules.setVehicules(newVehicules);

         return newConducteursAndVehicules;
     }


 }
