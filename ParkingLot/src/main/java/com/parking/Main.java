package com.parking;

import com.parking.controller.ParkingLot;
import com.parking.enums.ParkingSpotType;
import com.parking.enums.VehicleType;
import com.parking.factory.DefaultParkingFactory;
import com.parking.factory.ParkingFactory;
import com.parking.model.Ticket;
import com.parking.model.Vehicle;
import com.parking.service.Floor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {


        ParkingLot parkingLot = ParkingLot.getInstance();
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        ParkingFactory parkingFactory = new DefaultParkingFactory();
        floor1.addParkingSpot(parkingFactory.createParkingSpot(1, ParkingSpotType.SMALL));
        floor1.addParkingSpot(parkingFactory.createParkingSpot(2, ParkingSpotType.MEDIUM));
        floor1.addParkingSpot(parkingFactory.createParkingSpot(3, ParkingSpotType.LARGE));
        floor2.addParkingSpot(parkingFactory.createParkingSpot(4, ParkingSpotType.SMALL));
        floor2.addParkingSpot(parkingFactory.createParkingSpot(5, ParkingSpotType.MEDIUM));
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);
        Vehicle bike = new Vehicle("KA-01-HH-1234", VehicleType.BIKE);
        Vehicle car = new Vehicle("KA-01-HH-9999", VehicleType.CAR);
        Vehicle truck = new Vehicle("KA-01-BB-0001", VehicleType.TRUCK);
        Vehicle car2 = new Vehicle("KA-01-HH-7777", VehicleType.CAR);
        Ticket ticket1 = parkingLot.parkVehicle(bike);
        System.out.println("Ticket issued: " + ticket1);
        Thread.sleep(2000); // Simulate parking duration
        Ticket ticket2 = parkingLot.parkVehicle(car);
        System.out.println("Ticket issued: " + ticket2);
        Thread.sleep(1000); // Simulate parking duration
        double fee = parkingLot.exitVehicle(ticket1);
        System.out.println("Parking fee for vehicle " + ticket1.getVehicle().getNumber() + ": " + fee);
        Ticket ticket3 = parkingLot.parkVehicle(truck);
        System.out.println("Ticket issued: " + ticket3);
        Thread.sleep(3000); // Simulate parking duration
        Ticket ticket4 = parkingLot.parkVehicle(car2);
        System.out.println("Ticket issued: " + ticket4);
        Thread.sleep(1000); // Simulate parking duration
        fee = parkingLot.exitVehicle(ticket2);
        System.out.println("Parking fee for vehicle " + ticket2.getVehicle().getNumber() + ": " + fee);
        fee = parkingLot.exitVehicle(ticket3);
        System.out.println("Parking fee for vehicle " + ticket3.getVehicle().getNumber() + ": " + fee);
        fee = parkingLot.exitVehicle(ticket4);
        System.out.println("Parking fee for vehicle " + ticket4.getVehicle().getNumber() + ": " + fee);
    }
}