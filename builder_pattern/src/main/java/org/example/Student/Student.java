package org.example.Student;

import java.util.List;

public class Student {
    private String name;
    private String nationality;
    private int age;
    List<String> courses;

    public Student(){
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
