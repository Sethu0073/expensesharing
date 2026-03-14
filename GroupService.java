package service;

import model.Group;

public class GroupService {

    public Group createGroup(String name) {

        Group group = new Group(name);

        System.out.println("Group created successfully.");

        return group;
    }
}
