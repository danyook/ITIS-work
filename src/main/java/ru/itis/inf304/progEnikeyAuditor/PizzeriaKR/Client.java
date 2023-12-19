package ru.itis.inf304.progEnikeyAuditor.PizzeriaKR;

public class Client extends Person {
    public int discountСategory;

    public Client(String name, String gender, int age) {
        super(name, gender, age);
        this.discountСategory = 0;
        if (age > 50) {
            discountСategory += 30;
        }
        if (gender == "woman") {
            discountСategory += 10;
        }
    }
}