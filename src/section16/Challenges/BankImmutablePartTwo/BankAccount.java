package section16.Challenges.BankImmutablePartTwo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class BankAccount {

    public enum AccountType {
        CHECKING,
        SAVINGS,
        BUSINESS
    }
    
    //  fields are private;
    //  fields are final, where possible;
    private final AccountType type;
    private static long idInitializer = 1_000_000_001l;
    private final long id;
    private double balance;
    private final Map<Long, TransactionDTO> transactions;

    BankAccount(AccountType type, double initialAmount) {
        //  defensive copies needed?
        this.type = type;
        this.id = idInitializer++;
        this.balance = initialAmount < 0 ? 0 : initialAmount;
        //  LinkedHashMap() is ordered by insertion order, which is good enough here;
        this.transactions = new LinkedHashMap<>();
    }

    //  copy constructor;
    public BankAccount(BankAccount original) {
        this.type = original.getType();
        this.id = original.getId();
        this.balance = original.getBalance();
        this.transactions = original.getTransactions();
    }

    //  no setters!

    //  defensive getters
    public AccountType getType() {
        //  do enums need defence?
        return type;
    }

    public long getId() {
        //  id is already declared final;
        return id;
    }

    public double getBalance() {
        // returns a copy of balance;
        double balancyCopy = Double.valueOf(balance);
        return balancyCopy;
    }

    public Map<Long, TransactionDTO> getTransactions() {
        //  SHALLOW copy:
        // return new LinkedHashMap<>(transactions);

        //  DEEP copy:
        Map<Long, TransactionDTO> transactionsCopy = new LinkedHashMap<>();

        for (TransactionDTO t : transactions.values()) {

            TransactionDTO tCopy = new TransactionDTO(t);

            transactionsCopy.put(tCopy.getTransactionId(), tCopy);
        }

        return transactionsCopy;

    }

    @Override
    public String toString() {
        String s = "[%d] %-12s Balance = %.2f$".formatted(id, type, this.getBalance());
        return s;
    }


    final boolean deposit(double amount) {

        if (amount < 0) {return false;}

        this.balance = balance + amount;
        return true;

    }

    final boolean withdraw(double amount) {

        double abs = Math.abs(amount);

        if (abs > this.getBalance()) {return false;}
        if (this.type != AccountType.CHECKING) {return false;}

        this.balance = balance - abs;
        return true;

    }

    //  negative amount is withdrawal;
    //  positive amount is deposit;
    //  don't let balance go < 0 !!!!
    final boolean commitTransaction(int routingNumber, long transactionID, String customerID, double amount) {
        
        boolean validTransaction = amount < 0 ? withdraw(amount) : deposit(amount);

        if (validTransaction) {
            TransactionDTO t = new TransactionDTO(routingNumber, Long.parseLong(customerID), transactionID, amount);
            transactions.put(transactionID, t);    
        }
        
        return validTransaction;
    }

    public void printTransactions() {

        //  because TransactionDTO has no date field;
        //  we will print transactions by insertion order (LinkedHashSet);
        //  reversed (most recent first)

        List<TransactionDTO> transactionList = new ArrayList<>(transactions.values());
        // Collections.reverse(transactionList);

        System.out.println("-".repeat(60));
        System.out.println(this.toString());
        transactionList.forEach((v) -> System.out.println(v));
        System.out.println("-".repeat(60));
    }


}
