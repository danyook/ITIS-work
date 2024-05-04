package ru.itis.inf304.progEnikeyAuditor.threads.integral;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        double SP = Math.sqrt(Math.PI);

        int countOIfThreads = Runtime.getRuntime().availableProcessors();

        double h = SP / countOIfThreads;

        List<SumPart> thList = new ArrayList<>();
        for (int i = 0; i < countOIfThreads; i++) {
            thList.add(new SumPart(i * h, (i + 1) * h));
        }
        long startTime = System.nanoTime();
        thList.forEach(t -> {
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        long endTime = System.nanoTime();

        System.out.println("sum : " + SumPart.sum + ", time = " + (endTime - startTime));
    }
}