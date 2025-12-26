package com.parking.service;

import com.parking.enums.ParkingSpotType;
import com.parking.model.Vehicle;

public abstract class ParkingSpot {
    protected final int id;
    protected boolean isOccupied;
    protected Vehicle vehicle;

    protected ParkingSpot(int id) {
        this.id = id;
        this.isOccupied = false;
        this.vehicle = null;
    }
    protected abstract boolean canFitVehicle(Vehicle vehicle);
    public abstract ParkingSpotType getType();

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }
    public void unpark() {
        this.vehicle = null;
        this.isOccupied = false;
    }
    protected boolean isOccupied() {
        return isOccupied;
    }
}
