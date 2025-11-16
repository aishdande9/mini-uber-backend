package com.uber.backend.mini_uber_backend.controllers;

import com.uber.backend.mini_uber_backend.model.Rider;
import com.uber.backend.mini_uber_backend.model.Trip;
import com.uber.backend.mini_uber_backend.service.TripRequestProducer;
import com.uber.backend.mini_uber_backend.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trips")
public class TripController {

    private final TripRequestProducer tripRequestProducer;

    public TripController(TripRequestProducer tripRequestProducer) {
        this.tripRequestProducer = tripRequestProducer;
    }

    @PostMapping("/request")
    public String requestTrip(@RequestBody Rider rider) {
        tripRequestProducer.sendTripRequest(rider);
        return "Trip request sent for rider: " + rider.getName();
    }
}
