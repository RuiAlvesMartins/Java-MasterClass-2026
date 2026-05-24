package section16.Challenges.BankImmutablePartTwo;

import java.util.List;

import section16.Challenges.BankImmutablePartTwo.BankAccount.AccountType;

//  Cannot extend BankAccount, because it is final!
// class FakeBankAccount extends BankAccount {

//     public FakeBankAccount(AccountType type, double initialAmount) {
//         super(type, 1_000_000);
//     }

// }

public class Main {
    
    public static void main(String[] args) {
        
        BankAccount account1 = new BankAccount(AccountType.CHECKING);
        System.out.println(account1);
        account1.deposit(100d);
        System.out.println(account1);
        account1.withdraw(30d);
        System.out.println(account1);

        System.out.println("-".repeat(90));
        BankAccount account2 = new BankAccount(AccountType.SAVINGS, 300);
        System.out.println(account2);
        account2.deposit(100d);
        System.out.println(account2);
        account2.withdraw(50d);
        System.out.println(account2);



        System.out.println("-".repeat(90));
        BankCustomer johnDoe = new BankCustomer("John Doe");
        johnDoe.addAccount(account1);
        johnDoe.addAccount(account2);
        System.out.println(johnDoe);



        //  Now we try to break the code

        System.out.println("-".repeat(90));
        System.out.println(johnDoe);
        //  cannot override method, because it is final;
        account1.deposit(-1_000);
        System.out.println(johnDoe);

        //  this constructor might work here, but cannot be called outside the package;
        BankAccount account3 = new BankAccount(AccountType.CHECKING, 1_000_000);
        
        System.out.println("-".repeat(90));
        List<BankAccount> johnsAccounts = johnDoe.getAccounts();
        //  defensive getter returns a List.copyOf() the original collection;
        //  which is immutable, hence the error:
        // johnsAccounts.add(account3);                             //  runtime error!      UnsupportedOperationException
        // johnsAccounts.clear();                                   //  runtime error!      UnsupportedOperationException
        // System.out.println(johnDoe);

        //  cannot do the collection reference trick;
        //  because constructor does not accept a collection arg;
        //  Acounts ara added one at a time through final .addAcount()  

    }

}
