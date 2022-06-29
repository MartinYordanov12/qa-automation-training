package com.seleniumeasy.demo;

public class Person {
    String name;
    String jobPosition;
    String office;

    public Person(String name, String jobPosition, String office) {
        this.name = name;
        this.jobPosition = jobPosition;
        this.office = office;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", office='" + office + '\'' +
                '}';
    }
}



