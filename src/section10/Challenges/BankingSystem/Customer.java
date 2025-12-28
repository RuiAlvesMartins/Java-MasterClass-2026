package section10.Challenges.BankingSystem;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double transaction) {
        this.name = name;
        this.transactions = new ArrayList<>();
        //  TODO add initial transaction
        addTransaction(transaction);
    }

    public void addTransaction(double amount) {
        //  all transactions are DEPOSITS
        //  no withdraws or balances
        if (amount < 0) {
            //  invalid transaction
            return;
        }

        //  Autoboxing double into ArrayList of Doubles
        transactions.add(amount);

    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
    
}
