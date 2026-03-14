package repository;

import java.util.ArrayList;
import java.util.List;

import model.Group;

public class GroupRepository {

    private List<Group> groups = new ArrayList<>();

    public void save(Group group) {
        groups.add(group);
    }

    public List<Group> findAll() {
        return groups;
    }

    public Group findByName(String name) {

        for(Group g : groups) {
            if(g.getGroupName().equalsIgnoreCase(name)) {
                return g;
            }
        }

        return null;
    }
}
