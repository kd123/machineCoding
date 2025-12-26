package com.parking.strategy;

import com.parking.model.Vehicle;
import com.parking.service.Floor;
import com.parking.service.ParkingSpot;

import java.util.List;

public interface SpotAllocationStrategy {
    ParkingSpot allocateSpot(Vehicle vehicle, List<Floor> floors);
}
