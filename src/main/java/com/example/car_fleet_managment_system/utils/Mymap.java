package com.example.car_fleet_managment_system.utils;

import com.example.car_fleet_managment_system.modules.Conducteur;
import com.example.car_fleet_managment_system.modules.Vehicule;

import java.util.ArrayList;
import java.util.List;

public   class Mymap {
    private List<Conducteur> conducteur;

    private List<Vehicule> vehicules;

    public void setConducteur( List<Conducteur> conducteur) {
        this.conducteur = conducteur;
    }

    public void setVehicules( List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public List<Conducteur> getConducteur() {
        return conducteur;
    }

    public  List<Vehicule> getVehicules() {
        return vehicules;
    }
}
