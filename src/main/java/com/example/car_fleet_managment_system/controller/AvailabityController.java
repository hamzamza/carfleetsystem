package com.example.car_fleet_managment_system.controller;
import com.example.car_fleet_managment_system.services.Availability;
import com.example.car_fleet_managment_system.utils.Mymap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
@RestController
@RequestMapping("/api/availability")
public class AvailabityController {
    @Autowired
    private Availability availability;
    @GetMapping("/all")
    public ResponseEntity<Mymap> getAvailability(@RequestParam("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
                                                 @RequestParam("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        Mymap conducteursAndVehicules = availability.getNewConducteursAndVehicules(dateDebut, dateFin);
        return ResponseEntity.ok(conducteursAndVehicules);
    }

}
