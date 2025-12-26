package com.parking.service;

import com.parking.enums.ParkingSpotType;

public class SmallSpot extends ParkingSpot {
    public SmallSpot(int id) {
        super(id);
    }

    @Override
    protected boolean canFitVehicle(com.parking.model.Vehicle vehicle) {
        return vehicle.getType() == com.parking.enums.VehicleType.BIKE;
    }
    @Override
    public ParkingSpotType getType() {
        return ParkingSpotType.SMALL;
    }
}
