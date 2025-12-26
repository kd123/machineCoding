package com.parking.factory;

import com.parking.enums.ParkingSpotType;
import com.parking.service.ParkingSpot;

public interface ParkingFactory {
    ParkingSpot createParkingSpot(int id, ParkingSpotType type);
}
