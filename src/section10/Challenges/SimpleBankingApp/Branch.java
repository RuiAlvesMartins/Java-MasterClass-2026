package section10.Challenges.SimpleBankingApp;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean newCustomer(String customerName, double transaction) {
        //  true if customer added successfully
        Customer newCustomer = new Customer(customerName, transaction);
        Customer customer = findCustomer(customerName);
        if (customer != null) {
            //  customer already exists
            return false;
        }
        customers.add(newCustomer);
        return true;
    }

    public boolean addCustomerTransaction(String customerName, double transaction) {
        //  true if transaction successfull
        Customer customer = findCustomer(customerName);

        if (customer == null) {
            //  customer not found
            return false;
        }

        // customer.addTransaction(transaction);
        return true;
    }

    public Customer findCustomer(String customerName) {
        //  null if customer not found
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }

    public void printClientBalance(String customerName) {
        Customer customer = findCustomer(customerName);
        if (customer == null) {
            //  customer not found
            return;
        }
        System.out.printf("%nClient %s's current balance: %.2f$%n", customer.getName(), customer.getBalance());
    }

    public void printClientTransactions(String customerName) {
        Customer customer = findCustomer(customerName);
        if (customer == null) {
            //  customer not found
            return;
        }
        System.out.printf("%nClient %s's Transactions:", customer.getName());
        int transactionIndex = 1;
        for (Double transaction : customer.getTransactions()) {
            System.out.printf("%n[%d] Amount %.2f$", transactionIndex, transaction);
            transactionIndex++;
        }
        System.out.printf("%nClient %s's current balance: %.2f$%n", customer.getName(), customer.getBalance());
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

}
