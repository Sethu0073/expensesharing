package model;

public class Split {

    private Member member;
    private double amount;

    public Split(Member member, double amount) {
        this.member = member;
        this.amount = amount;
    }

    public Member getMember() {
        return member;
    }

    public double getAmount() {
        return amount;
    }
}
