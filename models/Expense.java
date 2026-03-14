package model;

import java.util.List;

public class Expense {

    private String description;
    private double amount;
    private Member paidBy;
    private List<Member> participants;

    public Expense(String description, double amount, Member paidBy, List<Member> participants) {
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.participants = participants;
    }

    public double getAmount() {
        return amount;
    }

    public Member getPaidBy() {
        return paidBy;
    }

    public List<Member> getParticipants() {
        return participants;
    }
}
