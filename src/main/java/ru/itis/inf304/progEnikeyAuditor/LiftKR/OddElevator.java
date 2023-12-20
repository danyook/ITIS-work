package ru.itis.inf304.progEnikeyAuditor.LiftKR;

public class OddElevator extends Elevator {
    public int getFloor() {
        return (int)(Math.random() * 16) + 1;
    }
}
