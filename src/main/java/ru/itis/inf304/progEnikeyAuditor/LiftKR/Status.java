package ru.itis.inf304.progEnikeyAuditor.LiftKR;
import java.util.Random;
public enum Status {
    Занят, Свободен;

    public static Status generateStatus() {
        Status[] Statuses = Status.values();
        int length = Statuses.length;
        int randIndex = new Random().nextInt(length);
        return Statuses[randIndex];
    }
}
