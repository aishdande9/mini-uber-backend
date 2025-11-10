package com.uber.backend.mini_uber_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverModel {
@Id
@GeneratedValue
private long id;
private String name;
private int phoneNumber;
    private String email;
    private String CurrentLocation;
    private Double rating;

    /*
     * Driver's vehicle details
     */

    private String vehicleMake;     // e.g., "Toyota"
    private String vehicleModel;    // e.g., "Prius"
    private String vehiclePlate;
    private String currentTripId;

}
