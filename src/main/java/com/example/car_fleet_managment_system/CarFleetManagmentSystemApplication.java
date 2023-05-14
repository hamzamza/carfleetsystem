package com.example.car_fleet_managment_system;

import com.example.car_fleet_managment_system.modules.Conducteur;
import com.example.car_fleet_managment_system.modules.Vehicule;
import com.example.car_fleet_managment_system.modules.Voyage;
import com.example.car_fleet_managment_system.repositories.ConducteurRepository;
import com.example.car_fleet_managment_system.repositories.VehicleRepository;
import com.example.car_fleet_managment_system.repositories.VoyageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class CarFleetManagmentSystemApplication {
    static Availabilitie availabilitie = new Availabilitie();
    static ConducteurRepository conducteurRepository = null;
    static VehicleRepository vehicleRepository = null;
    static VoyageRepository voyageRepository = null;

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(CarFleetManagmentSystemApplication.class, args);
        Scanner scanner = new Scanner(System.in);
        System.out.println("hello in incar fleet managment system v1.0");
        System.out.print("Enter the start date (format: yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date start_date = format.parse(dateString);

        System.out.print("Enter the end date (format: yyyy-MM-dd): ");
        String end_dateString = scanner.nextLine();
        Date end_date = format.parse(end_dateString);
        Mymap newConducteursAndVehicules = availabilitie.getNewConducteursAndVehicules(start_date, end_date);

        ArrayList<Conducteur> conducteurs = newConducteursAndVehicules.getConducteur();
        ArrayList<Vehicule> vehicules = newConducteursAndVehicules.getVehicules();
        System.out.println("List of conducteurs  :");

        for (Conducteur cond : conducteurs) {

            System.out.println("Conducteur: " + cond.getCIN());
        }
        System.out.println("-------------------------------------------------");

        // Show the list of conducteurs and vehicules to the user
        System.out.println("List   vehicules:");

        for (Vehicule v : vehicules) {

            System.out.println("Vehicule: " + v.getId());
        }

        // Get user input for conducteur and vehicule
        scanner = new Scanner(System.in);
        System.out.print("Choose a conducteur (enter CIN): ");
        long cin = scanner.nextLong();
        Conducteur conducteur = conducteurRepository.findById(cin).orElse(null);
        if (conducteur == null) {
            System.out.println("Invalid CIN.");
            return;
        }
        System.out.print("Choose a vehicule (enter ID): ");
        long id = scanner.nextLong();
        Vehicule vehicule = vehicleRepository.findById(id).orElse(null);
        if (vehicule == null) {
            System.out.println("Invalid ID.");
            return;
        }

        // Get user input for date
        System.out.print("Enter the date (format: yyyy-MM-dd): ");
        // Create a new voyage and save it to the database
        Voyage voyage = new Voyage();
        voyage.setConducteur(conducteur);
        voyage.setVehicule(vehicule);
        Date date = new Date();
        voyage.setDatedebut(date);
        voyageRepository.save(voyage);

        System.out.println("New voyage created.");
    }

    public static class Availabilitie {
        public Mymap getConducteursAndVehiculesByVoyageDate(Date dateDebut, Date dateFin) {

            Mymap conducteursAndVehicules = new Mymap();


            List<Voyage> voyages = (List<Voyage>) voyageRepository.findAll();
            List<Voyage> filteredVoyages = voyages.stream()
                    .filter(voyage -> voyage.getDatedebut().compareTo(dateFin) <= 0 && voyage.getDatefin().compareTo(dateDebut) >= 0)
                    .collect(Collectors.toList());

            ArrayList<Conducteur> conducteurs = new ArrayList<>();
            ArrayList<Vehicule> vehicules = new ArrayList<>();

            for (Voyage voyage : filteredVoyages) {
                conducteurs.add(voyage.getConducteur());
                vehicules.add(voyage.getVehicule());
            }

            conducteursAndVehicules.setConducteur(conducteurs);
            conducteursAndVehicules.setVehicules(vehicules);

            return conducteursAndVehicules;
        }

        public Mymap getNewConducteursAndVehicules(Date startDate, Date endDate) {
            ConducteurRepository conducteurRepository = null;
            VehicleRepository vehicleRepository = null;
            // Get conducteurs and vehicules from the database
            ArrayList<Conducteur> conducteurs = (ArrayList<Conducteur>) conducteurRepository.findAll();
            ArrayList<Vehicule> vehicules = (ArrayList<Vehicule>) vehicleRepository.findAll();

            // Get conducteurs and vehicules from getConducteursAndVehiculesByVoyageDate function
            Mymap conducteursAndVehiculesByVoyageDate = getConducteursAndVehiculesByVoyageDate(startDate, endDate);
            ArrayList<Conducteur> conducteursToRemove = conducteursAndVehiculesByVoyageDate.getConducteur();
            ArrayList<Vehicule> vehiculesToRemove = conducteursAndVehiculesByVoyageDate.getVehicules();


            // Create new maps of conducteurs and vehicules that do not belong to the previous map
            ArrayList<Conducteur> newConducteurs = (ArrayList<Conducteur>) conducteurs.stream().filter(conducteur -> !conducteursToRemove.contains(conducteur)).collect(Collectors.toList());
            ArrayList<Vehicule> newVehicules = (ArrayList<Vehicule>) vehicules.stream().filter(vehicule -> !vehiculesToRemove.contains(vehicule)).collect(Collectors.toList());
            Mymap newConducteursAndVehicules = new Mymap();

            // Create a new map of conducteurs and vehicules

            newConducteursAndVehicules.setConducteur(newConducteurs);
            newConducteursAndVehicules.setVehicules(newVehicules);
            return newConducteursAndVehicules;
        }


    }
}

class Mymap {
    private ArrayList<Conducteur> conducteur;

    private ArrayList<Vehicule> vehicules;

    public void setConducteur(ArrayList<Conducteur> conducteur) {
        this.conducteur = conducteur;
    }

    public void setVehicules(ArrayList<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public ArrayList<Conducteur> getConducteur() {
        return conducteur;
    }

    public ArrayList<Vehicule> getVehicules() {
        return vehicules;
    }
}