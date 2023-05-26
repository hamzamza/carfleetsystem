package com.example.car_fleet_managment_system.utils;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private String isAdmin ;
}
