package org.example.Builder;

import java.util.List;

import org.example.Student.Student;

public abstract class StudentBuilder {
    protected Student student;

    public StudentBuilder(){
        this.student = new Student();
    }

    public StudentBuilder withName(String name) {
        this.student.setName(name);
        return this;
    }

    public StudentBuilder withNationality(String nationality){
        this.student.setNationality(nationality);
        return this;
    }

    public StudentBuilder withAge(int age){
        this.student.setAge(age);
        return this;
    }

    public StudentBuilder withCourses(List<String> courses){
        this.student.setCourses(courses);
        return this;
    }

    public Student build(){
        return this.student;
    }
}
