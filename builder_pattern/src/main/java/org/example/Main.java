package org.example;

import org.example.Builder.StudentBuilder;
import org.example.Director.Director;
import org.example.Student.Student;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello welcome to builder pattern");

        List<String> commonCourses = new ArrayList<String>();
        commonCourses.add("English");

        Director director = new Director();
        StudentBuilder builderOne = director.getBuilder("engineer");
        Student engineerStudent = builderOne.withName("A").withAge(10).withNationality("Indian").withCourses(commonCourses).build();

        System.out.println(engineerStudent.toString());

        StudentBuilder builderTwo = director.getBuilder("medical");
        Student medicalStudent = builderTwo.withName("B").withAge(12).withNationality("American").withCourses(commonCourses).build();

        System.out.println(medicalStudent.toString());
    }
}