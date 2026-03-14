package model;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String groupName;

    private List<Member> members = new ArrayList<>();

    private List<Expense> expenses = new ArrayList<>();

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
}
