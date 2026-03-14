package service;

import model.Expense;
import model.Group;

public class ExpenseService {

    public void addExpense(Group group, Expense expense) {

        group.addExpense(expense);

        System.out.println("Expense recorded successfully.");
    }
}
