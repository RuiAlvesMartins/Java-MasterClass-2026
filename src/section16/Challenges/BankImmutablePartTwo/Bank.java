package section16.Challenges.BankImmutablePartTwo;

import java.util.Map;

import section16.Challenges.BankImmutablePartTwo.BankAccount.AccountType;

public class Bank {

    //todo handle modifiers
    int routingNumber;
    //  this long is to be used to initialize id on transactions;
    long lastTransactionId;
    Map<String, BankCustomer> customers;


    //todo
    public BankCustomer getCustomer(String id) {
        return null;
    }

    //todo
    public boolean addCustomer(String name, double checkingInitialDeposit, double savingsInitialDeposit) {
        return false;
    }

    //todo
    //  negative amount is withdrawal;
    //  positive amount is deposit;
    //  don't let balance go < 0 !!!!
    public boolean doTransaction(String id, AccountType type, double amount) {
        return false;
    }

}
