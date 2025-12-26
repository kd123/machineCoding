package com.elevator.state;

import com.elevator.service.Elevator;

public class MovingUpState implements ElevatorState {
    @Override
    public void move(Elevator elevator) {
        elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
        System.out.println("Elevator "+elevator.getId()+ " moving up to floor: " + elevator.getCurrentFloor());
        if(elevator.getTargetFloors().contains(elevator.getCurrentFloor())){
            elevator.getTargetFloors().remove(elevator.getCurrentFloor());
            elevator.setState(new IdleState());
            //System.out.println("Elevator "+elevator.getId()+ " stopped at floor: " + elevator.getCurrentFloor());
        }
    }
}
