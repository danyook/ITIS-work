package ru.itis.inf304.progEnikeyAuditor.threads.building;

import java.util.List;

public class Job implements Runnable {
    private final String name;
    private final int duration;
    private final List<Runnable> dependency;
    private final Thread thread;
    private final Brigade brigade;

    public Job(String name, int duration, List<Runnable> dependency, Brigade brigade) {
        this.name = name;
        this.duration = duration;
        this.dependency = dependency;
        this.thread = new Thread(this);
        this.brigade = brigade;
    }

    @Override
    public void run() {
        if (dependency != null) {
            for (Runnable runnable : dependency) {
                try {
                    ((Job) runnable).getThread().join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println("start " + name);
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(1000L * duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        if (brigade != null) {
            brigade.addTime(endTime - startTime);
        }
        System.out.println("end " + name);
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", dependency=" + dependency +
                ", thread=" + thread +
                ", brigade=" + brigade +
                '}';
    }
}
