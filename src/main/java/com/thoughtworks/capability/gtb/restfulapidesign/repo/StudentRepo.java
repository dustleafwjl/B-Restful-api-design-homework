package com.thoughtworks.capability.gtb.restfulapidesign.repo;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentRepo {
    public static HashMap<Integer, Student> students = new HashMap<Integer, Student>(){
        {
            put(1, Student.builder().id(1).name("沈乐琪").gender("male").note("").build());
            put(2, Student.builder().id(2).name("徐慧慧").gender("female").note("").build());
            put(3, Student.builder().id(3).name("陈思聪").gender("male").note("").build());
            put(4, Student.builder().id(4).name("王江林").gender("male").note("").build());
            put(5, Student.builder().id(5).name("王登宇").gender("male").note("").build());
            put(6, Student.builder().id(6).name("杨思雨").gender("female").note("").build());
            put(7, Student.builder().id(7).name("江雨舟").gender("male").note("").build());
            put(8, Student.builder().id(8).name("廖燊").gender("male").note("").build());
            put(9, Student.builder().id(9).name("胡晓").gender("female").note("").build());
            put(10, Student.builder().id(10).name("但杰").gender("male").note("").build());
            put(11, Student.builder().id(11).name("盖迈达").gender("male").note("").build());
            put(12, Student.builder().id(12).name("肖美琦").gender("female").note("").build());
            put(13, Student.builder().id(13).name("黄云洁").gender("female").note("").build());
            put(14, Student.builder().id(14).name("齐瑾浩").gender("male").note("").build());
            put(15, Student.builder().id(15).name("刘亮亮").gender("male").note("").build());
            put(16, Student.builder().id(16).name("肖逸凡").gender("male").note("").build());
            put(17, Student.builder().id(17).name("王作文").gender("male").note("").build());
            put(18, Student.builder().id(18).name("郭瑞凌").gender("male").note("").build());
            put(19, Student.builder().id(19).name("李明豪").gender("male").note("").build());
            put(20, Student.builder().id(20).name("党泽").gender("male").note("").build());
            put(21, Student.builder().id(21).name("肖伊佐").gender("male").note("").build());
            put(22, Student.builder().id(22).name("贠晨曦").gender("male").note("").build());
            put(23, Student.builder().id(23).name("李康宁").gender("male").note("").build());
            put(24, Student.builder().id(24).name("马庆").gender("male").note("").build());
            put(25, Student.builder().id(25).name("商婕").gender("female").note("").build());
            put(26, Student.builder().id(26).name("余榕").gender("female").note("").build());
            put(27, Student.builder().id(27).name("谌哲").gender("female").note("").build());
            put(28, Student.builder().id(28).name("董翔锐").gender("male").note("").build());
            put(29, Student.builder().id(29).name("陈泰宇").gender("male").note("").build());
            put(30, Student.builder().id(30).name("赵允齐").gender("male").note("").build());
            put(31, Student.builder().id(31).name("张柯").gender("male").note("").build());
            put(32, Student.builder().id(32).name("廖文强").gender("male").note("").build());
            put(33, Student.builder().id(33).name("刘轲").gender("male").note("").build());
            put(34, Student.builder().id(34).name("廖浚斌").gender("male").note("").build());
            put(35, Student.builder().id(35).name("凌凤仪").gender("female").note("").build());
        }
    };
    static int generateId = 35;
    public Student save(Student student) {
        if(students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        generateId ++;
        student.setId(generateId);
        students.put(generateId, student);
        return students.get(generateId);
    }

    public void deleteById(int id) {
        students.remove(id);
    }

    public List<Student> getAllStudent() {
        return new ArrayList<Student>(students.values());
    }

    public List<Student> getStudentsByGender(String gender) {
        return students.values().stream().filter(ele -> ele.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Student getStudentById(Integer id) {
        return students.get(id);
    }
}
