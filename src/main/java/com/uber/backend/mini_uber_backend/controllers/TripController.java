package com.uber.backend.mini_uber_backend.controllers;

import com.uber.backend.mini_uber_backend.model.Trip;
import com.uber.backend.mini_uber_backend.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/trip")
public class TripController {
    @Autowired
    private TripService tripService;
@PostMapping("/request")
    public Trip tripRequest(@RequestBody Trip trip){
        return tripService.requestTrip(trip);
    }
}
