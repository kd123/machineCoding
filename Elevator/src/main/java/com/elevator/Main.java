package com.elevator;

import com.elevator.service.Elevator;
import com.elevator.service.ElevatorController;
import com.elevator.model.Request;
import com.elevator.model.Direction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ElevatorController controller = ElevatorController.getInstance();

        // Initialize elevators, add them to the controller, and simulate requests here

        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(2);

        System.out.printf("Elevator system initialized!");

        controller.addElevator(elevator1);
        controller.addElevator(elevator2);

        // Simulate some requests
        controller.submitRequest(new Request(5, Direction.UP));
        controller.submitRequest(new Request(2, Direction.DOWN));

        // Simulate elevator movements
        for (int i = 0; i < 10; i++) {
            controller.step();
        }
    }
}