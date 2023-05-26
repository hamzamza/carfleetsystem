package com.example.car_fleet_managment_system.services;

import com.example.car_fleet_managment_system.modules.Admin;
import com.example.car_fleet_managment_system.repositories.AdminRepository;
import com.example.car_fleet_managment_system.utils.JwtUtils;
import com.example.car_fleet_managment_system.utils.Pyload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {


      @Autowired
      private AdminRepository adminRepository;
      @Autowired
      private JwtUtils jwt ;
      @Autowired
      private  AuthenticationService authenticationService ;
                  public boolean isAdminUser(String token){
                        Pyload pyload =  jwt.parseToken(token);
                        return pyload.isAdmin();
                  }
                        public boolean createAdmin(Admin admin) {
                              try {
                                    adminRepository.save(admin);
                                    return true;
                              } catch (Exception e) {

                                    return false;
                              }
                        }
}
