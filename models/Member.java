package model;

public class Member {

    private String name;
    private boolean paidCash;

    public Member(String name, boolean paidCash) {
        this.name = name;
        this.paidCash = paidCash;
    }

    public String getName() {
        return name;
    }

    public boolean isPaidCash() {
        return paidCash;
    }
}
