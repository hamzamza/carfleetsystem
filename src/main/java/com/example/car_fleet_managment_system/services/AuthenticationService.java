package com.example.car_fleet_managment_system.services;
import com.example.car_fleet_managment_system.modules.Admin;
import com.example.car_fleet_managment_system.modules.Conducteur;
import com.example.car_fleet_managment_system.repositories.AdminRepository;
import com.example.car_fleet_managment_system.repositories.ConducteurRepository;
import com.example.car_fleet_managment_system.utils.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    AdminRepository adminRepository ;
    @Autowired
    ConducteurRepository conductorRepository ;
    @Autowired
    JwtUtils jwtUtils ;
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expirationMs}")
    private long expirationMs;

    public String login(String username, String password, boolean isAdmin) {

        if (isAdmin) {
            Admin admin = adminRepository.findByUsername(username);

            if (admin != null && admin.getPassword().equals(password)) {
                return jwtUtils.generateToken(admin.getId(),  admin.getUsername(),   true);
            }
        } else {
            Conducteur conductor = conductorRepository.findByNom(username);
            if (conductor != null && conductor.getPassword().equals(password)) {
                return jwtUtils.generateToken(conductor.getId(), conductor.getNom() , false);
            }
        }
        return null;
    }




}
