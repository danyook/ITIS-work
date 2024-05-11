package ru.itis.inf304.progEnikeyAuditor.threads.building;

public class Brigade {
    private final String specialty;
    private long time = 0; // Время простоя

    public Brigade(String specialty) {
        this.specialty = specialty;;
    }

    public void addTime(long time) {
        this.time += time;
    }

    @Override
    public String toString() {
        return specialty + " (простой: " + (time / 1000) + " д.)";
    }
}
