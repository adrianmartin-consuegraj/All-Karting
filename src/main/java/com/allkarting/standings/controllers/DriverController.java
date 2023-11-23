package com.allkarting.standings.controllers;

import com.allkarting.standings.models.Driver;
import com.allkarting.standings.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping("/getAll")
    public String getAll(Model model){
        List<Driver> drivers = driverService.getAllDrivers();
        model.addAttribute("drivers", drivers);
        return "drivers";
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<Driver> getOne(Integer id){
        return driverService.getOne(id);
    }


    @PostMapping(value="/addNew")
    public String addDriver(Driver driver){
        driverService.addNew(driver);
        return "redirect:/drivers/getAll";
    }

    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Driver driver){
        driverService.update(driver);
        return "redirect:/drivers/getAll";
    }


}
