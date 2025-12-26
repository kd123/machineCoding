package com.elevator.strategy;

import com.elevator.model.Request;
import com.elevator.service.Elevator;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorSchedulingStrategy {
    @Override
    public Elevator selectElevator(List<Elevator> elevators, Request request) {
        Elevator nearestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - request.getFloor());
            if (distance < minDistance) {
                minDistance = distance;
                nearestElevator = elevator;
            }
        }
        return nearestElevator;
    }
}
