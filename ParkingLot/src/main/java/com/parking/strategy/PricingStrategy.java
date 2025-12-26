package com.parking.strategy;

import com.parking.enums.VehicleType;

public interface PricingStrategy {
    double calculatePrice(long durationInHours, VehicleType vehicleType);
}
