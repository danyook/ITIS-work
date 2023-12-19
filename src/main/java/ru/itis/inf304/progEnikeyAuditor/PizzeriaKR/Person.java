package ru.itis.inf304.progEnikeyAuditor.PizzeriaKR;

public abstract class Person {
    private String name;
    private String gender;
    private int age;
    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
}
