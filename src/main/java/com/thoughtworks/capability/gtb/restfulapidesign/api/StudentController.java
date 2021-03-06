package com.thoughtworks.capability.gtb.restfulapidesign.api;


import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/students")
public class StudentController {

    private final StudentService studentService;

    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudent(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @GetMapping(value = "", params = "gender")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudentsByGender(@RequestParam String gender) {
        return studentService.getStudentsByGender(gender);
    }

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student upDateStudent(@PathVariable Integer id, @RequestBody Student student) {
        return studentService.updateStudentById(id, student);
    }
}
