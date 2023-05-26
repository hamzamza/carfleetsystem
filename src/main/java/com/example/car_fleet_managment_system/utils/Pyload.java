package com.example.car_fleet_managment_system.utils;

import lombok.Data;

@Data
public class Pyload {
    private Long id;
    private String username;
    private boolean isAdmin;

    public Pyload( long  id , String username, boolean isAdmin) {
        this.id = id ;
        this.username = username;
        this.isAdmin = isAdmin;
    }}