package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repo.GroupRepo;
import com.thoughtworks.capability.gtb.restfulapidesign.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GroupService {

    public List<Group> createCroup() {
        GroupRepo.clear();
        List<String> initGroup = GroupRepo.initGroup;
        initGroup.forEach(name -> GroupRepo.groups.add(Group.builder()
                .name(name).note("").students(new ArrayList<>()).build()));
        Random random = new Random();
        int index = 0;
        List<Student> studentsCopy = new ArrayList<>(StudentRepo.students.values());
        int size = studentsCopy.size();
        for (int i = 0; i < size; i ++) {
            int randNum = random.nextInt(studentsCopy.size());
            GroupRepo.groups.get(index).addStudent(studentsCopy.remove(randNum));
            index = ++ index % GroupRepo.groups.size();
        }
        return GroupRepo.groups;
    }

    public List<Group> getGroups() {
        return GroupRepo.groups;
    }

    public Group updateGroup(int id, Group group) {
        if(!group.getName().equals("")) {
            GroupRepo.groups.get(id).setName(group.getName());
        }
        return GroupRepo.groups.get(id);
    }
}
