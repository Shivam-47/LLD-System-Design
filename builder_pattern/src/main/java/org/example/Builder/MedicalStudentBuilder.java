package org.example.Builder;

import java.util.ArrayList;
import java.util.List;

public class MedicalStudentBuilder extends StudentBuilder{
    public MedicalStudentBuilder(){
        super();
    }

    @Override
    public StudentBuilder withCourses(List<String> courses) {
        List<String> tempCourse = new ArrayList<String>(courses);
        tempCourse.add("Biology");
        return super.withCourses(tempCourse);
    }
}
