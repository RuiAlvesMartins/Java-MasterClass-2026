package section16.Challenges.BankImmutablePartTwo;

    //  DTOs: DATA TRANSFER OBJECTS

    //  DTOs are used to RETRIEVE data from, and COMMIT data to, a DATABASE;
    //  Because of two way communication, it needs getters and setters!
    //  It also usually features an all args constructor for ease of use;

public final class TransactionDTO {
    
    //  Do NOT initialize IDs in a DTO!!!
    // private static long idInitializer = 100_000_000_000_001l;
    //  Why?
    //          IDs RESET when the app restarts;
    //          not thread-safe;
    //          collisions possible across machines/users;
    //          DTO now contains BUSINESS LOGIC/STATE!!!
    //          databases usually generate IDs themselves;

    //  routingNumber is the ID for the Bank;
    private int routingNumber;
    private long customerId;
    private long transactionId;
    private double transactionAmount;

    //allArgs constructor
    //  are defensive copies necessary?
    //          all fields are PRIMITIVES;
    //          like String, they are IMMUTABLE!
    //  so the answer here is NO!
    //  the same is true for SETTERS and GETTERS!
    TransactionDTO(int routingNumber, long customerId, long transactionId, double transactionAmount) {
        this.routingNumber = routingNumber;
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
    }

    //  copy constructor
    public TransactionDTO(TransactionDTO original) {
        this.routingNumber = original.getRoutingNumber();
        this.customerId = original.getCustomerId();
        this.transactionId = original.getTransactionId();
        this.transactionAmount = original.getTransactionAmount();
    }

    //setters
    void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }
    void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }
    void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    //getters
    public int getRoutingNumber() {
        return routingNumber;
    }
    public long getCustomerId() {
        return customerId;
    }
    public long getTransactionId() {
        return transactionId;
    }
    public double getTransactionAmount() {
        return transactionAmount;
    }

    @Override
    public String toString() {
        return "TransactionDTO [routingNumber=" + routingNumber + ", customerId=" + customerId + ", transactionId="
                + transactionId + ", transactionAmount=" + transactionAmount + "]";
    }


    
}
