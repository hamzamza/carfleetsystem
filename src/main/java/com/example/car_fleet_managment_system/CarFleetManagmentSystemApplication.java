package com.example.car_fleet_managment_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication
public class CarFleetManagmentSystemApplication {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(CarFleetManagmentSystemApplication.class, args);
     /*
         static Availabilitie availabilitie = new Availabilitie();
    static ConducteurRepository conducteurRepository = null;
    static VehicleRepository vehicleRepository = null;
    static VoyageRepository voyageRepository = null;

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

 */

    }


}

