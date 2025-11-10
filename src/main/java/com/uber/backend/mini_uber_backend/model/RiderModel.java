package com.uber.backend.mini_uber_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiderModel {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int phoneNumber;
    private String currentLocation;
    private String email;
    private String currentTripId;
}
