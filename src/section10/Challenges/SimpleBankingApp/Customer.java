package section10.Challenges.SimpleBankingApp;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;
    private Double balance;

    public Customer(String name, double transaction) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.balance = 0D;
        transactions.add(0D);
        addTransaction(transaction, false);
    }

    public boolean deposit(double amount) {
        return addTransaction(amount, false);
    }

    public boolean withdraw(double amount) {
        return addTransaction(amount, true);
    }

    private boolean addTransaction(double amount, boolean withdraw) {
        if (amount < 0) {
            //  invalid amount
            return false;
        }
        if (withdraw) {
            if (amount <= balance) {
                balance-=amount;
                transactions.add(-amount);
                return true;
            }
            //  not enough money
            return false;
        }

        balance+=amount;
        transactions.add(amount);
        return true;

    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public Double getBalance() {
        return balance;
    }
    
}
