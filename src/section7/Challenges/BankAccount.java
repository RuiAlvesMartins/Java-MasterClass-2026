package section7.Challenges;

public class BankAccount {

    private long number;
    private double balance;
    private String customerName;
    private String eMail;
    private int phoneNumber;

    public void deposit(double depositAmount) {
        this.balance+=depositAmount;
    }

    public void withdraw(double withdrawAmount) {
        if (balance < withdrawAmount) {
            System.out.println("Operation refused: insuficient funds!");
        }
        else {
            balance-=withdrawAmount;
        }
    }

    public long getNumber() {
        return number;
    }
    public void setNumber(long number) {
        this.number = number;
    }
    public double getBalance() {
        System.out.println("Current Balance: " + balance);
        return balance;
    }
    private void setBalance(double balance) {
        this.balance = balance;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    

}
