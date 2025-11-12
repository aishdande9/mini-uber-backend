package com.uber.backend.mini_uber_backend.controllers;

import com.uber.backend.mini_uber_backend.model.Driver;
import com.uber.backend.mini_uber_backend.model.Rider;
import com.uber.backend.mini_uber_backend.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rider")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RiderController {
    private final TripService tripService;
    @PostMapping("/add")
    public Rider addRider(@RequestBody Rider rider){
return tripService.addRider(rider);
    }
    @GetMapping
    public List<Rider> getAllRiders(){
        return tripService.getAllRiders();
    }
}
