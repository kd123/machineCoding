package com.elevator.service;

import com.elevator.model.Request;
import com.elevator.strategy.ElevatorSchedulingStrategy;
import com.elevator.strategy.NearestElevatorStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private static ElevatorController instance;
    List<Elevator> elevators = new ArrayList<>();
    ElevatorSchedulingStrategy schedulingStrategy = new NearestElevatorStrategy();
    private ElevatorController() {
    }
    public static ElevatorController getInstance() {
        if (instance == null) {
            instance = new ElevatorController();
        }
        return instance;
    }
    public void addElevator(Elevator elevator) {
        elevators.add(elevator);
    }
    public void submitRequest(Request request) {
        Elevator selectedElevator = schedulingStrategy.selectElevator(elevators, request);
        selectedElevator.addTargetFloor(request.getFloor());
    }
    public void step() {
        for (Elevator elevator : elevators) {
            elevator.move();
        }
    }
}
