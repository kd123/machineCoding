package com.parking.strategy;

import com.parking.model.Vehicle;
import com.parking.service.Floor;
import com.parking.service.ParkingSpot;

import java.util.List;
import java.util.Optional;

public class FirstAllocationStrategy implements SpotAllocationStrategy {
    @Override
    public ParkingSpot allocateSpot(Vehicle vehicle, List<Floor> floors) {
        for (Floor floor : floors) {
            Optional<ParkingSpot> spotOpt = floor.getAvailableSpot(vehicle);
            if (spotOpt.isPresent()) {
                return spotOpt.get();
            }
        }
        return null; // No spot available in any floor
    }
}
