package com.parking.model;

import com.parking.service.ParkingSpot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private final int floor;
    private long entryTime;
    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot, int floor) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = System.currentTimeMillis();
        this.floor = floor;
    }
    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicle Number=" + vehicle.getNumber() +
                ", vehicle Type=" + vehicle.getType() +
                ", parkingSpot Type=" + parkingSpot.getType() +
                ", floor=" + floor +
                ", entryTime=" + entryTime +
                '}';
    }
}
