package section10.Challenges.BankingSystem;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        //  true if branch added successfully
        Branch newBranch = new Branch(branchName);
        Branch branch = findBranch(branchName);
        if (branch != null) {
            //  branch already exists
            return false;
        }
        branches.add(newBranch);
        return true;
    }

    public boolean addCustomer(String branchName, String customerName, double transaction) {
        //  true if customer added successfully
        Branch branch = findBranch(branchName);
        if (branch == null) {
            //  branch not found
            return false;
        }
        return branch.newCustomer(customerName, transaction);
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        //  true if branch added successfully
        Branch branch = findBranch(branchName);
        if (branch == null) {
            //  branch not found
            return false;
        }
        return branch.addCustomerTransaction(customerName, transaction);
    }

    private Branch findBranch(String branchName) {
        //  null if branch not found
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        //  true if branch exists
        Branch branch = findBranch(branchName);
        if (branch == null) {
            //  branch not found
            return false;
        }
        System.out.println("Customer details for branch " + branch.getName());

        int customerIndex = 1;
        for (Customer customer : branch.getCustomers()) {
            System.out.println("Customer: " + customer.getName() + "[" + customerIndex + "]");
            customerIndex++;
            if (printTransactions) {
                System.out.println("Transactions");
                int transactionIndex = 1;
                for (Double transaction : customer.getTransactions()) {
                    System.out.println("[" + transactionIndex + "] Amount " + transaction);
                    transactionIndex++;
                }
            }
        }
        return true;
    }

}
