package ru.itis.inf304.progEnikeyAuditor.PizzeriaKR;

import java.util.Random;

public enum Pizza {
    Пепперони,
    Маргарита,
    Диабло;

    public static Pizza generateRandomPizza() {
        Pizza[] pizzas = Pizza.values();
        int length = pizzas.length;
        int randIndex = new Random().nextInt(length);
        return pizzas[randIndex];
    }
}
