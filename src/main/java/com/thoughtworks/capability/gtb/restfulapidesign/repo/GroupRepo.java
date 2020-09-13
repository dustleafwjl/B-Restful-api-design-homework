package com.thoughtworks.capability.gtb.restfulapidesign.repo;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GroupRepo {
    public static List<String> initGroup = Arrays.asList("Team 1", "Team 2", "Team 3", "Team 4", "Team 5", "Team 6");
    public static List<Group> groups = new ArrayList<>();
    public static int generateId = 0;

    public Group save(Group group) {
        group.setId(generateId);
        groups.add(group);
        generateId ++;
        return groups.get(generateId - 1);
    }

    public static void clear() {
        groups.clear();
    }
}
