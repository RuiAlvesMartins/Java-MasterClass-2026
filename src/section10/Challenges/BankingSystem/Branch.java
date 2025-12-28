package section10.Challenges.BankingSystem;

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

        customer.addTransaction(transaction);
        return true;
    }

    private Customer findCustomer(String customerName) {
        //  null if customer not found
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

}
