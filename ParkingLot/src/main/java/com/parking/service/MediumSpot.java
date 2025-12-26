package com.parking.service;

import com.parking.enums.ParkingSpotType;

public class MediumSpot extends ParkingSpot {
    public MediumSpot(int id) {
        super(id);
    }

    @Override
    protected boolean canFitVehicle(com.parking.model.Vehicle vehicle) {
        return vehicle.getType() == com.parking.enums.VehicleType.CAR ||
               vehicle.getType() == com.parking.enums.VehicleType.BIKE;
    }

    @Override
    public ParkingSpotType getType() {
        return ParkingSpotType.MEDIUM;
    }

}
