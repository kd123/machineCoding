package com.parking.service;

import com.parking.enums.ParkingSpotType;
import com.parking.model.Vehicle;
import lombok.Data;

import java.util.*;

@Data
public class Floor {
    private final int floorNumber;
    private final Map<ParkingSpotType, List<ParkingSpot>> parkingSpots = new EnumMap<>(ParkingSpotType.class);

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        for (ParkingSpotType type : ParkingSpotType.values()) {
            parkingSpots.put(type, new ArrayList<>());
        }
    }
    public Optional<ParkingSpot> getAvailableSpot(Vehicle vehicle){
       return parkingSpots.values().stream()
               .flatMap(List::stream)
               .filter(spot -> !spot.isOccupied() && spot.canFitVehicle(vehicle))
               .findFirst();
    }
    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.get(spot.getType()).add(spot);
    }


}
