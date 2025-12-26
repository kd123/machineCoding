package com.parking.factory;

import com.parking.enums.ParkingSpotType;
import com.parking.service.LargeSpot;
import com.parking.service.MediumSpot;
import com.parking.service.ParkingSpot;
import com.parking.service.SmallSpot;


public class DefaultParkingFactory implements ParkingFactory {
    @Override
    public ParkingSpot createParkingSpot(int id, ParkingSpotType type) {
        return switch (type) {
            case SMALL -> new SmallSpot(id);
            case MEDIUM -> new MediumSpot(id);
            case LARGE -> new LargeSpot(id);
        };
    }
}
