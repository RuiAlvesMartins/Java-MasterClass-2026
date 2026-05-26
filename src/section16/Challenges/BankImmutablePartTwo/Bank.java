package section16.Challenges.BankImmutablePartTwo;

import java.util.HashMap;
import java.util.Map;

import section16.Challenges.BankImmutablePartTwo.BankAccount.AccountType;

public class Bank {

    private final int routingNumber;
    //  this long is to be used to initialize id on transactions;
    private static long lastTransactionId = 100_000_000_000_001l;
    private final Map<String, BankCustomer> customers;

    public Bank(int routingNumber) {
        this.routingNumber = routingNumber;
        this.customers = new HashMap<>();
    }

    public int getRoutingNumber() {
        //  int is primitive, no defensive copy required;
        return routingNumber;
    }

    public Map<String, BankCustomer> getCustomers() {
        //todo this should return a DEEP copy;
        return customers;
    }

    public BankCustomer getCustomer(String id) {
        //todo this should return a copy;
        return customers.get(id);
    }

    public boolean addCustomer(String name, double checkingInitialDeposit, double savingsInitialDeposit) {
        //  logic could be implemented here for minimum checking and savings initial deposit;
        if (checkingInitialDeposit < 50 || savingsInitialDeposit < 0) {return false;}
        //  BankCustomer constructor should not be called!
        BankCustomer customer = BankCustomer.newCustomer(name, checkingInitialDeposit, savingsInitialDeposit);
        
        if (customer != null) {
            customers.put(customer.getId(), customer);
            return true;
        }
        return false;
    }

    //  negative amount is withdrawal;
    //  positive amount is deposit;
    //  don't let balance go < 0 !!!!
    public boolean doTransaction(String id, AccountType type, double amount) {

        BankCustomer customer = customers.get(id);
        if (customer == null) {return false;}

        BankAccount account = customer.getAccount(type);
        if (account == null) {return false;}

        return account.commitTransaction(this.getRoutingNumber(), lastTransactionId++, id, amount);

    }

    public final boolean addAccount(String customerId, AccountType type, double initialAmount) {

        BankCustomer customer = customers.get(customerId);
        if (customer == null) {return false;}

        for (BankAccount account : customer.getAccounts()) {
            if (account.getType() == type) {return false;}
        }

        boolean initialAmountValid = false;
        if (type == AccountType.CHECKING) {
            initialAmountValid = initialAmount >= 50 ? true : false;
        }
        if (type == AccountType.SAVINGS) {
            initialAmountValid = initialAmount >= 100 ? true : false;
        }

        if (initialAmountValid) {
            customer.addAccount(new BankAccount(type, initialAmount));
            return true;
        }

        return false;
    }

}
