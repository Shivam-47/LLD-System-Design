package org.example.Student;

import org.example.Prototype.Prototype;

public class Student implements Prototype {

    private static int rollNumberSequencer=0;
    private int rollNumber;

    private String name;

    private int age;

    public Student(String name, int age) {
        this.rollNumber = rollNumberSequencer++;
        this.name = name;
        this.age = age;
    }

    public Prototype clone() {
        Student object = new Student(name, age);
        object.rollNumber = rollNumber;
        return object;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
