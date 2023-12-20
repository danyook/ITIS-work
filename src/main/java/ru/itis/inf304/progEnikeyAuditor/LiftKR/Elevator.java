package ru.itis.inf304.progEnikeyAuditor.LiftKR;

import static ru.itis.inf304.progEnikeyAuditor.LiftKR.Situation.generateSituation;
import static ru.itis.inf304.progEnikeyAuditor.LiftKR.Status.generateStatus;

import java.util.Random;
public abstract class Elevator implements Call {


    public abstract int getFloor();

    public  String callElevator() throws ElevatorException {
        if (getFloor() % 2 != 0 && generateSituation().name() == "OddElevator" && generateStatus().name() == "Свободен") {
            return ("Вызывается лифт на " + getFloor() + " этаж");
        }
        if (getFloor() % 2 == 0 && generateSituation().name() == "EvenElevator" && generateStatus().name() == "Свободен") {
            return("Вызывается лифт на " + getFloor() + " этаж");
        }
        if (generateSituation().name() == "EmployeesElevator" && generateSituation().name() == "Свободен") {
            return("Вызывается лифт на " + getFloor() + " этаж");
        }
        throw new ElevatorException("Все лифты заняты");

    }

}
