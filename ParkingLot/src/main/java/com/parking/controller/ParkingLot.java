package com.parking.controller;

import com.parking.factory.DefaultParkingFactory;
import com.parking.factory.ParkingFactory;
import com.parking.model.Ticket;
import com.parking.model.Vehicle;
import com.parking.service.Floor;
import com.parking.strategy.FirstAllocationStrategy;
import com.parking.strategy.HourlyPricingStrategy;
import com.parking.strategy.PricingStrategy;
import com.parking.strategy.SpotAllocationStrategy;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ParkingLot {
    private static ParkingLot instance;
    private ParkingLot() {}

    private final List<Floor> floors = new ArrayList<>();
    private final SpotAllocationStrategy spotAllocationStrategy =  new FirstAllocationStrategy();
    private final PricingStrategy pricingStrategy = new HourlyPricingStrategy();
    private final ParkingFactory parkingFactory = new DefaultParkingFactory();

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance= new ParkingLot();
        }
        return instance;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }
    public void addFloors(List<Floor> floorList) {
        floors.addAll(floorList);
    }
    public synchronized Ticket parkVehicle(Vehicle vehicle) {
        for(Floor floor:floors) {
            var spot = spotAllocationStrategy.allocateSpot(vehicle, floors);
            if (spot == null) {
                System.out.println("No available spot for vehicle: " + vehicle.getNumber());
                return null;
            }
            spot.park(vehicle);
            return new Ticket(vehicle, spot, floor.getFloorNumber());
        }
        return null;
    }

   public synchronized double exitVehicle(Ticket ticket) {
        var spot = ticket.getParkingSpot();
        spot.unpark();
        long duration  = System.currentTimeMillis()- ticket.getEntryTime();
        double fee = pricingStrategy.calculatePrice(duration, ticket.getVehicle().getType());
       System.out.println(ticket.getVehicle() +
               " exited from floor " + ticket.getFloor()+
               ". Fee: Rs. " + fee);
       return fee;
   }
}
