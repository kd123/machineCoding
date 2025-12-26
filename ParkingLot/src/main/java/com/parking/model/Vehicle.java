package com.parking.model;

import com.parking.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private String number;
    private VehicleType type;

}
