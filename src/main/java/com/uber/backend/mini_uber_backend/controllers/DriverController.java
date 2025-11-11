package com.uber.backend.mini_uber_backend.controllers;

import com.uber.backend.mini_uber_backend.model.Driver;
import com.uber.backend.mini_uber_backend.model.Rider;
import com.uber.backend.mini_uber_backend.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
public class DriverController {
    @Autowired
    private TripService tripService;
    @PostMapping("/add")
    public Driver addDriver(@RequestBody Driver driver){
        return tripService.addDriver(driver);
    }
    @GetMapping
    public List<Driver> getAllDrivers(){
        return tripService.getAllDrivers();
    }
}

