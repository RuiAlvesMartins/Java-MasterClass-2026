package section16.Challenges.BankImmutablePartTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import section16.Challenges.BankImmutablePartTwo.BankAccount.AccountType;

public final class BankCustomer {
    
    //  name;
    //  id;
    //  collection<BankAccount>;
    private final String name;
    //  customerId should be a 15 digit string
    private static long idInitializer = 100_000_000_000_001l;
    private final String id;
    //  should this be final?
    //  it CAN be final, because we will modify elements, the instance itself will remain the same;
    private final List<BankAccount> accounts;

    private BankCustomer(String name) {
        this.name = name;
        this.id = "" + idInitializer++;
        //  acounts don't need a defensive copy;
        //  because they are initilized locally, not through an external arg;
        this.accounts = new ArrayList<>();
        //  but if accounts, or other collection field, were to be assigned a value from an arg;
        //  you should definitly make a defensive copy:
        // this.accounts = new ArrayList<>(collectionArg);
    }

    //  copy constructor
    public BankCustomer(BankCustomer original) {
        this.name = original.getName();
        this.id = original.getId();
        this.accounts = original.getAccounts();
    }

    //  code in other classes cannot instantiate BankCostumer!
    //  customer factory method;
    //  will instantiate a new customer if, and only if, he opens a cheking or savings account;
    static final BankCustomer newCustomer(String name, double checkingInitialDeposit, double savingsInitialDeposit) {
        if (checkingInitialDeposit < 0 || savingsInitialDeposit < 0) {return null;}

        BankAccount checking = null;
        BankAccount savings = null;

        if (checkingInitialDeposit > 0) {
            checking = new BankAccount(AccountType.CHECKING, checkingInitialDeposit);
        }

        if (savingsInitialDeposit > 0) {
            savings = new BankAccount(AccountType.SAVINGS, savingsInitialDeposit);
        }

        if (checking != null || savings != null) {
            BankCustomer customer = new BankCustomer(name);
            if (checking != null) {
                customer.addAccount(checking);
            }
            if (savings != null) {
                customer.addAccount(savings);
            }
            return customer;
        }

        return null;
    }

    public String getName() {
        //  string is already immutable;
        return name;
    }

    public String getId() {
        //  id is already final;
        return id;
    }

    public List<BankAccount> getAccounts() {
        //  SHALLOW copy:
        // return List.copyOf(accounts);

        //  DEEP copy:
        List<BankAccount> accountsCopy = new ArrayList<>();
        for (BankAccount account : accounts) {
            BankAccount accountCopy = new BankAccount(account);
            accountsCopy.add(accountCopy);
        }

        return accountsCopy;
    }

    @Override
    public String toString() {
        String[] accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings, i -> accounts.get(i).toString());

        String s = "Customer: %-20s (id:%s)%n\t%s".formatted(name, id, String.join("\n\t", accountStrings));
        return s;
    }
    
    final boolean addAccount(BankAccount account) {
        if (account == null) {return false;}

        this.accounts.add(account);
        return true;
    }

    //todo
    //assume customers have only 1 account per accountType (e.g. 1 checking, 1 savings, 1 business)
    //  this has to return an original instance, instead of a copy, for use in Bank.java;
    //  it CANNOT return a COPY!
    public final BankAccount getAccount(AccountType type) {
        for (BankAccount account : accounts) {
            if (account.getType() == type) {
                // return new BankAccount(account);
                return account;
            }
        }
        return null;
    }

}
