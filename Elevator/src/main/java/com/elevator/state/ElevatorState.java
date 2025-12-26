package com.elevator.state;

import com.elevator.service.Elevator;

public interface ElevatorState {
    void move(Elevator elevator);
}
