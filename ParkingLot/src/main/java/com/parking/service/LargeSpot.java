package com.parking.service;

import com.parking.enums.ParkingSpotType;

public class LargeSpot extends ParkingSpot {
    public LargeSpot(int id) {
        super(id);
    }

    @Override
    protected boolean canFitVehicle(com.parking.model.Vehicle vehicle) {
        return vehicle.getType() == com.parking.enums.VehicleType.TRUCK;
    }
    @Override
    public ParkingSpotType getType() {
        return ParkingSpotType.LARGE;
    }
}
