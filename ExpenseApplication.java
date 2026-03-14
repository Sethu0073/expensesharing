package main;

import java.util.List;
import java.util.Scanner;

import exception.InvalidInputException;
import model.*;
import service.*;

public class ExpenseApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GroupService groupService = new GroupService();
        MemberService memberService = new MemberService();
        ExpenseService expenseService = new ExpenseService();
        SplitService splitService = new SplitService();

        Group group = null;

        while(true) {

            try {

                System.out.println("\n1 Create Group");
                System.out.println("2 Add Member");
                System.out.println("3 Add Expense");
                System.out.println("4 Split Expense");
                System.out.println("5 View Members");
                System.out.println("6 Exit");

                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch(choice) {

                    case 1:

                        System.out.print("Enter Group Name: ");
                        String gname = scanner.nextLine();

                        if(!gname.matches("[a-zA-Z ]+"))
                            throw new InvalidInputException("Group name should contain only letters.");

                        group = groupService.createGroup(gname);
                        break;

                    case 2:

                        if(group == null)
                            throw new InvalidInputException("Create a group first.");

                        System.out.print("Enter Member Name: ");
                        String mname = scanner.nextLine();

                        if(!mname.matches("[a-zA-Z ]+"))
                            throw new InvalidInputException("Member name should contain only letters.");

                        System.out.print("Has the member already paid cash? (true/false): ");
                        boolean paidCash = scanner.nextBoolean();
                        scanner.nextLine();

                        Member member = new Member(mname, paidCash);

                        memberService.addMember(group, member);
                        break;

                    case 3:

                        if(group == null)
                            throw new InvalidInputException("Create a group first.");

                        System.out.print("Enter Expense Description: ");
                        String desc = scanner.nextLine();

                        System.out.print("Enter Amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        if(amount <= 0)
                            throw new InvalidInputException("Expense must be greater than zero.");

                        Member payer = group.getMembers().get(0);

                        Expense expense = new Expense(desc, amount, payer, group.getMembers());

                        expenseService.addExpense(group, expense);
                        break;

                    case 4:

                        if(group == null)
                            throw new InvalidInputException("Create a group first.");

                        if(group.getExpenses().isEmpty())
                            throw new InvalidInputException("No expenses recorded.");

                        Expense exp = group.getExpenses().get(0);

                        List<Split> splits = splitService.calculateSplit(
                                exp.getAmount(),
                                exp.getParticipants());

                        System.out.println("\nSplit Result:");

                        for(Split s : splits) {
                            System.out.println(
                                    s.getMember().getName() +
                                    " owes " +
                                    s.getAmount());
                        }

                        break;

                    case 5:

                        if(group == null)
                            throw new InvalidInputException("Create a group first.");

                        System.out.println("\nMembers:");

                        for(Member m : group.getMembers()) {
                            System.out.println(m.getName());
                        }

                        break;

                    case 6:

                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice.");

                }

            } catch (InvalidInputException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {

                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        }
    }
}
