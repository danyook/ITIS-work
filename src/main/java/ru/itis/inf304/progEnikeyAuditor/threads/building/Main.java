package ru.itis.inf304.progEnikeyAuditor.threads.building;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String[] names = new String[]{
            "Проект",
            "Изготовление окон",
            "Изготовление дверей",
            "Возведение фундамента",
            "Прокладка коммуникаций (канализация, вода, электричество)",
            "Возведение стен",
            "Возведение крыши",
            "Установка окон",
            "Установка дверей",
            "Установка отопительных приборов (батарей)",
            "Прокладка электропроводки",
            "Отделка стен и потолка",
            "Отделка пола",
            "Установка осветительных приборов",
            "Установка сантехники",
    };
    private static final int[] durations = new int[]{7, 7, 7, 14, 4, 14, 3, 1, 1, 3, 3, 7, 7, 1, 2};

    private static final List<int[]> dependencies = Arrays.asList(
            null,
            new int[]{1},
            new int[]{1},
            new int[]{1},
            new int[]{4},
            new int[]{4},
            new int[]{6},
            new int[]{2, 7},
            new int[]{3, 7},
            new int[]{5, 8, 9},
            new int[]{5, 7},
            new int[]{8, 9, 11},
            new int[]{12},
            new int[]{12},
            new int[]{5, 11, 12}
    );
    private static final List<int[]> idJob = Arrays.asList(
            new int[] {4, 6},
            new int[] {2, 3, 7, 8, 9},
            new int[] {5, 10, 15},
            new int[] {12, 13},
            new int[] {11, 14}
    );

    private static final int countBrigades = 5;

    private static final String[] namesBrigades = new String[] {
            "Каменщики",
            "Плотники",
            "Сантехники",
            "Штукатуры",
            "Электрики"
    };

    public static void main(String[] args) throws InterruptedException {
        final int COUNT_JOBS = names.length;
        Job[] jobs = new Job[COUNT_JOBS];
        Brigade[] brigades = new Brigade[countBrigades];

        for (int i = 0; i < countBrigades; i++) {
            brigades[i] = new Brigade(namesBrigades[i]);
        }

        for (int i = 0; i < COUNT_JOBS; i++) {
            List<Runnable> dependency = null;
            if (dependencies.get(i) != null) {
                dependency = new ArrayList<>();
                for (int index : dependencies.get(i)) {
                    dependency.add(jobs[index - 1]);
                }
            }

            for (int j = 0; j < countBrigades; j++) {
                for (int el : idJob.get(j)) {
                    if ((el - 1) == i) {
                        jobs[i] = new Job(names[i], durations[i], dependency, brigades[j]);
                        break;
                    }
                }
                if (jobs[i] == null) {
                    jobs[i] = new Job(names[i], durations[i], dependency, null);
                }
            }

        }

        long startTime = System.currentTimeMillis();
        System.out.println("Начало работ");
        for (Job job : jobs) {
            job.getThread().start();
        }

        for (Job job : jobs) {
            job.getThread().join();
        }
        System.out.println("Завершение строительства");
        System.out.println("-------------------");
        long endTime = System.currentTimeMillis();
        for (Brigade brigade : brigades) {
            System.out.println(brigade);
        }
        System.out.println("Общее время стройки: " + ((endTime - startTime) / 1000) + " д.");
    }
}
