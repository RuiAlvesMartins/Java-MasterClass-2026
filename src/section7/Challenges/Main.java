package section7.Challenges;

public class Main {

        public static void main(String[] args) {
            
            BankAccount account = new BankAccount();
            account.setNumber(666666666666L);
            account.setCustomerName("Mike Hunt");
            account.seteMail("mike.hunt@yahoo.com");
            account.setPhoneNumber(555444666);

            account.getBalance();
            account.deposit(100);
            account.getBalance();
            account.withdraw(10);
            account.getBalance();
            account.withdraw(120);
            account.getBalance();



            Customer customer1 = new Customer("John Doe", 50, "john_doe@yahoo.com");
            Customer customer2 = new Customer("Jane Fonda", "jane_fonda@yahoo.com");
            Customer customer3 = new Customer();
            customer1.describeCustomer();
            customer2.describeCustomer();
            customer3.describeCustomer();

        }

}
