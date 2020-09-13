package com.thoughtworks.capability.gtb.restfulapidesign.repo;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepo {
    public static List<Student> students = new ArrayList<Student>();
    static int generateId = 0;
    public void save(Student student) {
        generateId ++;
        students.add(student);
    }
}
