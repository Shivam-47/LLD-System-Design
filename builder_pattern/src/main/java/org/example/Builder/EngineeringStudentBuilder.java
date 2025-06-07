package org.example.Builder;

import java.util.ArrayList;
import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder{

    public EngineeringStudentBuilder(){
        super();
    }

    @Override
    public StudentBuilder withCourses(List<String> courses) {
        List<String> tempCourse = new ArrayList<String>(courses);
        tempCourse.add("Computer Programming");
        return super.withCourses(tempCourse);
    }
}
