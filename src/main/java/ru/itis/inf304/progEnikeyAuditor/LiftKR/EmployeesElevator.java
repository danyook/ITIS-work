package ru.itis.inf304.progEnikeyAuditor.LiftKR;

public class EmployeesElevator extends Elevator {
    public int getFloor() {
        return (int)(Math.random() * 16) + 1;
    }
}
