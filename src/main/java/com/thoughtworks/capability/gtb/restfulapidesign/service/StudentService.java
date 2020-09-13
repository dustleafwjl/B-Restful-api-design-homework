package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repo.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepo studentRepo;
    StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void createStudent(Student student) {
        studentRepo.save(student);
    }

    public void deleteStudent(int id) {
        studentRepo.deleteById(id - 1);
    }
}
