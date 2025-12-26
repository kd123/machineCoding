package com.elevator.state;

import com.elevator.service.Elevator;

public class IdleState implements ElevatorState {
    @Override
    public void move(Elevator elevator) {
        if(!elevator.getTargetFloors().isEmpty()){
            Integer nextFloor = elevator.getTargetFloors().peek();
            elevator.setState(nextFloor > elevator.getCurrentFloor() ? new MovingUpState() : new MovingDownState());
        }
    }
}
