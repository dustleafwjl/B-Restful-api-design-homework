package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    GroupController(GroupService groupService) {
        this.groupService = groupService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Group> createGroup() {
        return groupService.createCroup();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Group updateGroup(@PathVariable Integer id, @RequestBody Group group) {
        return groupService.updateGroup(id, group);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Group> getGroups() {
        return groupService.getGroups();
    }
}
