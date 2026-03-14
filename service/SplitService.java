package service;

import java.util.ArrayList;
import java.util.List;

import model.Member;
import model.Split;

public class SplitService {

    public List<Split> calculateSplit(double amount, List<Member> members) {

        List<Member> eligible = new ArrayList<>();

        for(Member m : members) {
            if(!m.isPaidCash()) {
                eligible.add(m);
            }
        }

        int count = eligible.size();

        double splitAmount = amount / count;

        List<Split> splits = new ArrayList<>();

        for(Member m : eligible) {
            splits.add(new Split(m, splitAmount));
        }

        return splits;
    }
}
