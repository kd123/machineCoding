package com.elevator.strategy;

import com.elevator.model.Request;
import com.elevator.service.Elevator;

import java.util.List;

public interface ElevatorSchedulingStrategy {
    Elevator selectElevator(List<Elevator> elevators, Request request);
}
