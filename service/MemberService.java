package service;

import model.Group;
import model.Member;

public class MemberService {

    public void addMember(Group group, Member member) {

        group.addMember(member);

        System.out.println("Member added successfully.");
    }
}
