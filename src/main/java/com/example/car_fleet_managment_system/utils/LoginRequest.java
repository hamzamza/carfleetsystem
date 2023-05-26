package com.example.car_fleet_managment_system.utils;

public class LoginRequest {
    private String username;
    private String password;
private boolean isAdmin ;
    // Constructors, getters, and setters

    // Default constructor
    public LoginRequest() {
    }

    // Parameterized constructor
    public LoginRequest(String username, String password , boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin  = isAdmin ;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public  boolean getIsAdmin( ){
        return isAdmin ;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
