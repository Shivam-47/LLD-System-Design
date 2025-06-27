package org.example;

import org.example.Student.Student;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("John", 2);
        System.out.println(s.toString());

        Student n = (Student) s.clone();
        System.out.println(n.toString());

        Student s2 = new Student("Doe", 3);
        System.out.println(s2.toString());
    }
}