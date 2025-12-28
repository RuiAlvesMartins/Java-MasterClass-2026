package section7.Challenges;

public class Customer {

    private String name;
    private double creditLimit;
    private String emailAddress;
    

    public void describeCustomer() {
        System.out.println(name + " at " + emailAddress);
        System.out.println("Credit limit = " + creditLimit);
    }

    
    public Customer(String name, double creditLimit, String emailAddress) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }

    public Customer() {
        this("nobody", 0, "nobody@nowhere.com");
    }

    public Customer(String name, String emailAddress) {
        this(name, 0, emailAddress);
    }



    public String getName() {
        return name;
    }
    public double getCreditLimit() {
        return creditLimit;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

}
