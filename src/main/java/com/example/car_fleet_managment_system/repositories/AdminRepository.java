package com.example.car_fleet_managment_system.repositories;


import com.example.car_fleet_managment_system.modules.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository  extends CrudRepository<Admin, Long> {
    Admin findByUsername(String username);
}
