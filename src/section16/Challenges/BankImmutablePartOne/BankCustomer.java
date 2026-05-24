package section16.Challenges.BankImmutablePartOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {
    
    //  name;
    //  id;
    //  collection<BankAccount>;
    private final String name;
    private static int idInitializer = 999_999_999;
    private final int id;
    //  should this be final?
    //  it CAN be final, because we will modify elements, the instance itself will remain the same;
    private final List<BankAccount> accounts;

    public BankCustomer(String name) {
        this.name = name;
        this.id = idInitializer++;
        //  acounts don't need a defensive copy;
        //  because they are initilized locally, not through an external arg;
        this.accounts = new ArrayList<>();
        //  but if accounts, or other collection field, were to be assigned a value from an arg;
        //  you should definitly make a defensive copy:
        // this.accounts = new ArrayList<>(collectionArg);
    }

    public String getName() {
        //  string is already immutable;
        return name;
    }

    public int getId() {
        //  id is already final;
        return id;
    }

    public List<BankAccount> getAccounts() {
        List<BankAccount> accountsCopy = List.copyOf(accounts);
        return accountsCopy;
    }

    @Override
    public String toString() {
        String[] accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings, i -> accounts.get(i).toString());

        String s = "Customer: %-20s (id:%015d)%n\t%s".formatted(name, id, String.join("\n\t", accountStrings));
        return s;
    }
    
    public final boolean addAccount(BankAccount account) {
        if (account == null) {return false;}

        this.accounts.add(account);
        return true;
    }

}
