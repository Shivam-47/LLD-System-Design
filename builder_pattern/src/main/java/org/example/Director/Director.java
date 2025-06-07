package org.example.Director;

import org.example.Builder.EngineeringStudentBuilder;
import org.example.Builder.MedicalStudentBuilder;
import org.example.Builder.StudentBuilder;


public class Director {


    public Director(){

    }

    public StudentBuilder getBuilder(String studentType){
        switch (studentType){
            case "engineer":
                return new EngineeringStudentBuilder();
            case "medical":
                return new MedicalStudentBuilder();
            default:
                return new EngineeringStudentBuilder();
        }
    }
}
