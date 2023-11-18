package com.allkarting.standings.services;

import com.allkarting.standings.models.Driver;
import com.allkarting.standings.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }

    public Optional<Driver> getOne(Integer id){
        return driverRepository.findById(id);
    }

    public void addNew(Driver driver){
        driverRepository.save(driver);
    }

}
