package com.elevator.service;

import com.elevator.model.ElevatorStatus;
import com.elevator.state.ElevatorState;
import com.elevator.state.IdleState;
import lombok.Data;

import java.util.PriorityQueue;

@Data
public class Elevator {

    private int id;
    private int currentFloor=0;
    private ElevatorState state = new IdleState();
    private PriorityQueue<Integer> targetFloors = new PriorityQueue<>();

    public Elevator(int id){
        this.id = id;
    }
    public void addTargetFloor(int floor){
        targetFloors.add(floor);
    }
    public void move(){
        state.move(this);
    }

}
