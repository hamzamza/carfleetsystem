package com.example.car_fleet_managment_system.controller;

import com.example.car_fleet_managment_system.modules.Admin;
import com.example.car_fleet_managment_system.modules.Conducteur;
import com.example.car_fleet_managment_system.services.AdminService;
import com.example.car_fleet_managment_system.services.ConducteurServices;
import com.example.car_fleet_managment_system.utils.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// AdminController.java
@RestController
@RequestMapping("/users")
public class AdminController {

    @Autowired
    private AdminService adminService;
@Autowired
private ConducteurServices conducteurServices ;
    @PostMapping("/create")
    public ResponseEntity<String> createAdmin(@RequestHeader("Authorization") String token, @RequestBody UserRequest userRequest) {

        if (!adminService.isAdminUser(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Only admins can create admins.");
        }
        if (  userRequest.getIsAdmin().equals("true")) {
        Admin admin = new Admin();
        admin.setUsername(userRequest.getUsername());
        admin.setPassword(userRequest.getPassword());
        adminService.createAdmin(admin);
    }
    else {
            System.out.println(userRequest.getUsername());
        Conducteur conducteur = new Conducteur();
        conducteur.setNom(userRequest.getUsername());
        conducteur.setPassword(userRequest.getPassword());
        conducteurServices.createConducteur(conducteur);

    }


        return ResponseEntity.ok("created successfully.");
    }
}
