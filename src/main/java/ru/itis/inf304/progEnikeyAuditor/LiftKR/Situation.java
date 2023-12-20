package ru.itis.inf304.progEnikeyAuditor.LiftKR;
import java.util.Random;
public enum Situation {
    EvenElevator, OddElevator, EmployeesElevator;
    public static Situation generateSituation() {
        Situation[] situations = Situation.values();
        int length = situations.length;
        int randIndex = new Random().nextInt(length);
        return situations[randIndex];
    }
}
