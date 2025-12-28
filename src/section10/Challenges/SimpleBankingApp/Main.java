package section10.Challenges.SimpleBankingApp;

public class Main {
    
    public static void main(String[] args) {

        Bank bank = new Bank("National Australia Bank");
 
        bank.addBranch("Adelaide");
 
        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers("Adelaide", true);
        bank.listCustomers("Adelaide", false);

        System.out.println(bank.listCustomers("Adelaide", false));
        System.out.println(bank.listCustomers("Ajuda", false));

        System.out.println();
        System.out.println();
        System.out.println();

        //  test deposit
        bank.findBranch("Adelaide").printClientTransactions("Tim");
        bank.findBranch("Adelaide").findCustomer("Tim").deposit(100);
        bank.findBranch("Adelaide").findCustomer("Tim").deposit(-100);
        //  test withdraw
        bank.findBranch("Adelaide").findCustomer("Tim").withdraw(50);
        bank.findBranch("Adelaide").findCustomer("Tim").withdraw(150);
        //  test print balance and transactions
        bank.findBranch("Adelaide").printClientBalance("Tim");
        bank.findBranch("Adelaide").printClientTransactions("Tim");
        //  test intra branch transfer
        bank.intraBranchTransfer("Mike", "Tim", "Adelaide", 25D);
        bank.findBranch("Adelaide").printClientTransactions("Mike");
        bank.findBranch("Adelaide").printClientTransactions("Tim");
        //  test intra bank transfer
        bank.addBranch("Brisbane");
        bank.addCustomer("Brisbane", "George", 75D);
        bank.intraBankTransfer("Mike", "Adelaide", "George", "Brisbane", 50D);
        bank.findBranch("Adelaide").printClientTransactions("Mike");
        bank.findBranch("Brisbane").printClientTransactions("George");
        //  test inter bank transfer
        Bank newBank = new Bank("People's Bank of China");
        newBank.addBranch("Beijing");
        newBank.addCustomer("Beijing", "Uncle Xi", 100D);
        bank.interBankTransfer("Percy", "Adelaide", "Uncle Xi", "Beijing", newBank, 100D);
        bank.findBranch("Adelaide").printClientTransactions("Percy");
        newBank.findBranch("Beijing").printClientTransactions("Uncle Xi");



        //  transfers between branches?
        //  transfers between banks?
    }

}
