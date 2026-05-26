package section16.Challenges.DifferentPackage;

import section16.Challenges.BankImmutablePartTwo.BankCustomer;
import section16.Challenges.BankImmutablePartTwo.BankAccount;
import section16.Challenges.BankImmutablePartTwo.Bank;
import section16.Challenges.BankImmutablePartTwo.BankAccount.AccountType;

public class BankPartTwoMain {
    
    public static void main(String[] args) {
        
        //  create bank instance
        //  add customer
        //  let client obtain BankCustomer instance through string ID;
        //  let client review transactions from single selected account;
        //  transacrions should not be modifiable or susceptible to side effects;
        //  withdrawal/deposit funds only through Bank instance (string customerID, acountType, amount);
        //  Main.java should not access .commitTransaction() on BankAccount.java; 

        Bank cgd = new Bank(001);
        cgd.addCustomer("Zé Ninguém", 50, 0);
        cgd.getCustomers().forEach((k, v) -> System.out.println(v));
        System.out.println(cgd.getCustomer("100000000000001"));

        BankCustomer zeNinguem = cgd.getCustomer("100000000000001");
        BankAccount zeChecking = zeNinguem.getAccount(AccountType.CHECKING);

        //  .commitTransaction() is not accessible!
        // zeChecking.commitTransaction(10, 10l, "s", 12.0);

        zeChecking.printTransactions();
        System.out.println(cgd.doTransaction(zeNinguem.getId(), AccountType.CHECKING, -100));
        System.out.println(cgd.doTransaction(zeNinguem.getId(), AccountType.CHECKING, 100));
        System.out.println(cgd.doTransaction(zeNinguem.getId(), AccountType.CHECKING, -50));
        System.out.println(cgd.doTransaction(zeNinguem.getId(), AccountType.CHECKING, -500));
        zeChecking.printTransactions();

        //  add savings account and work it
        System.out.println();
        System.out.println(cgd.addAccount(zeNinguem.getId(), AccountType.CHECKING, 200));
        System.out.println(cgd.addAccount(zeNinguem.getId(), AccountType.SAVINGS, 50));
        System.out.println(cgd.addAccount(zeNinguem.getId(), AccountType.SAVINGS, 100));

        System.out.println();
        System.out.println(zeNinguem);


    }

}
