package com.elevator.state;

public class MovingDownState implements ElevatorState {
    @Override
    public void move(com.elevator.service.Elevator elevator) {
        elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
        System.out.println("Elevator " + elevator.getId()+ " moving down to floor: " + elevator.getCurrentFloor());
        if (elevator.getTargetFloors().contains(elevator.getCurrentFloor())) {
            elevator.getTargetFloors().remove(elevator.getCurrentFloor());
            elevator.setState(new IdleState());
            //System.out.println("Elevator stopped at floor: " + elevator.getCurrentFloor());
        }
    }
}
