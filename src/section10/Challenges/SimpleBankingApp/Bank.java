package section10.Challenges.SimpleBankingApp;

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

    public Branch findBranch(String branchName) {
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
                    System.out.println("[" + transactionIndex + "] Amount " + transaction + "$");
                    transactionIndex++;
                }
            }
        }
        return true;
    }

    public boolean interBankTransfer(String senderName, String senderBranchName, String recipientName, String recipientBranchName, Bank recipientBank, double amount) {
        if (recipientBank == null) {return false;}
        
        Branch senderBranch = findBranch(senderBranchName);
        Branch recipientBranch = recipientBank.findBranch(recipientBranchName);
        if (senderBranch == null || recipientBranch == null) {return false;}

        Customer sender = senderBranch.findCustomer(senderName);
        Customer recipient = recipientBranch.findCustomer(recipientName);
        if (sender == null || recipient == null) {return false;}

        if (amount > sender.getBalance()) {
            //  sender doesn't have enough funds
            return false;
        }

        sender.withdraw(amount);
        recipient.deposit(amount);
        return true;

    }

    public boolean intraBankTransfer(String senderName, String senderBranchName, String recipientName, String recipientBranchName, double amount) {
        return interBankTransfer(senderName, senderBranchName, recipientName, recipientBranchName, this, amount);
    }

    public boolean intraBranchTransfer(String senderName, String recipientName, String branchName, double amount) {
        return interBankTransfer(senderName, branchName, recipientName, branchName, this, amount);
    }

    // public boolean intraBankTransfer2(String senderName, String senderBranchName, String recipientName, String recipientBranchName, double amount) {
    //     Branch senderBranch = findBranch(senderBranchName);
    //     Branch recipientBranch = findBranch(recipientBranchName);
    //     if (senderBranch == null || recipientBranch == null) {return false;}

    //     Customer sender = senderBranch.findCustomer(senderName);
    //     Customer recipient = recipientBranch.findCustomer(recipientName);
    //     if (sender == null || recipient == null) {return false;}

    //     if (amount > sender.getBalance()) {
    //         //  sender doesn't have enough funds
    //         return false;
    //     }

    //     sender.withdraw(amount);
    //     recipient.deposit(amount);
    //     return true;

    // }

}
