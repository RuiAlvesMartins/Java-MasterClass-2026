package section16.Challenges.BankImmutablePartTwo;

import java.util.Map;

public final class BankAccount {

    enum AccountType {
        CHECKING,
        SAVINGS,
        BUSINESS
    }
    
    //  fields are private;
    //  fields are final, where possible;
    private final AccountType type;
    private static int idInitializer = 999_999_999;
    private final int id;
    private double balance;
    //todo
    private Map<Long, TransactionDTO> transactions;

    protected BankAccount(AccountType type, double initialAmount) {
        //  defensive copies needed?
        this.type = type;
        this.id = idInitializer++;
        this.balance = initialAmount < 50 ? 50 : initialAmount;
    }

    public BankAccount(AccountType type) {
        this(type, 50);
    }

    //  no setters!

    //  defensive getters
    public AccountType getType() {
        //  do enums need defence?
        return type;
    }

    public int getId() {
        //  id is already declared final;
        return id;
    }

    public double getBalance() {
        // returns a copy of balance;
        double balancyCopy = Double.valueOf(balance);
        return balancyCopy;
    }

    //todo should it be public? 
    public Map<Long, TransactionDTO> getTransactions() {
        //todo return a DEEP copy!
        return transactions;
    }

    @Override
    public String toString() {
        String s = "[%d] %s Balance = %.2f$".formatted(id, type, this.getBalance());
        return s;
    }


    public final boolean deposit(double amount) {

        if (amount < 0) {return false;}

        this.balance = balance + amount;
        return true;

    }

    public final boolean withdraw(double amount) {

        if (amount < 0) {return false;}
        if (amount > this.getBalance()) {return false;}
        if (this.type != AccountType.CHECKING) {return false;}

        this.balance = balance - amount;
        return true;

    }

    public boolean commitTransaction(int routingNumber, long transactionID, String customerID, double amount) {
        //todo
        return false;
    }


}
