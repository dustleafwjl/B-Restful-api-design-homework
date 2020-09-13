package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Student> getAllStudent() {
        return studentRepo.getAllStudent();
    }

    public List<Student> getStudentsByGender(String gender) {
        return studentRepo.getStudentsByGender(gender);
    }

    public Student getStudentById(Integer id) {
        return studentRepo.getStudentById(id);
    }

    public Student updateStudentById(Integer id, Student student) {
        Student saveStudent = studentRepo.getStudentById(id);
        saveStudent.setName(student.getName());
        saveStudent.setGender(student.getGender());
        saveStudent.setNote(student.getNote());
        return studentRepo.save(saveStudent);
    }
}
