package ru.itis.inf304.progEnikeyAuditor.LiftKR;

import static ru.itis.inf304.progEnikeyAuditor.LiftKR.Situation.generateSituation;
import static ru.itis.inf304.progEnikeyAuditor.LiftKR.Status.generateStatus;

import java.util.Random;
public abstract class Elevator implements Call {


    public abstract int getFloor();

    public  String callElevator() throws ElevatorException {
        int floor = getFloor();
        String situation = generateSituation().name();
        String status = generateStatus().name();
        System.out.println(floor + " " + situation + " " + status);
        if (floor % 2 != 0 && situation == "OddElevator" && status == "Свободен") {
            return ("Вызывается лифт на " + floor + " этаж");
        }
        else if (floor % 2 == 0 && situation == "EvenElevator" && status == "Свободен") {
            return("Вызывается лифт на " + floor + " этаж");
        }
        else if (situation == "EmployeesElevator" && status == "Свободен") {
            return("Вызывается лифт на " + floor + " этаж");
        }
        else {
            throw new ElevatorException("Все лифты заняты");
        }

    }

}
