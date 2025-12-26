package com.parking.strategy;

import com.parking.enums.VehicleType;



public class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(long durationInHours, VehicleType vehicleType) {
        double hours = Math.max(1,durationInHours/3600000); // Convert milliseconds to hours, minimum 1 hour
        return switch (vehicleType) {
            case CAR -> hours*10.0;
            case BIKE -> hours * 20.0;
            case TRUCK ->  hours * 30.0;
        };
    }
}
