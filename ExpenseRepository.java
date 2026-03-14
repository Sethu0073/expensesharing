package repository;

import java.util.ArrayList;
import java.util.List;

import model.Expense;

public class ExpenseRepository {

    private List<Expense> expenses = new ArrayList<>();

    public void save(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> findAll() {
        return expenses;
    }
}
