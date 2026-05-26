package section16.Challenges.DifferentPackage;

import section16.Challenges.BankImmutablePartTwo.BankCustomer;
import section16.Challenges.BankImmutablePartTwo.TransactionDTO;
import section16.Challenges.BankImmutablePartTwo.BankAccount;

import java.util.ArrayList;
import java.util.List;

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



        //  Now we try to break the code
        System.out.printf("%n%n%n%n");

        //  getters are returning defensive copies;
        //  each time you make a transaction, you have to atualize the references;
        //  or they will point to a previous state in time;
        zeChecking = cgd.getCustomer(zeNinguem.getId()).getAccount(AccountType.CHECKING);

        var zeTransactions = zeChecking.getTransactions().values();
        List<TransactionDTO> transList = new ArrayList<>(zeTransactions);
        
        //  can get to a TransactionDTO object
        System.out.println(transList.get(0));
        System.out.println(transList.size());
        transList.forEach(System.out::println);

        transList.get(0).getRoutingNumber();
        transList.get(0).getCustomerId();
        transList.get(0).getTransactionAmount();
        transList.get(0).getTransactionId();
        transList.get(0).toString();

        //  cannot access setters on TransactionDTO from outside the package!
        // transList.get(0).setTransactionAmount(1_000_000_000); 
   
        


        

    }

}
