package section6.Loops;

public class ForLoop {

    //  FOR LOOP (or statement) iterates until a condition is satisfied;

    //  for (initialization; expression; increment) {}
    //  INITIALIZATION initializes the ITERATION VARIABLE; it may also declare it;
    //  CONDITION resumes to a boolean; for loop stops when false;
    //  INCREMENT changes the ITERATION VARIABLE after the first iteration;

    //  Be wary of NON-STARTER loops !!!
    //  Be wary of ENDLESS LOOPS !!!

    public static void main(String[] args) {
        
        for (int counter = 1; counter <= 5; counter++) {
            System.out.println(counter);
        }

        //  System.out.println("10,000 at 2% interest = " + calculateInterest(10000, 2));
        //  System.out.println("10,000 at 3% interest = " + calculateInterest(10000, 3));
        //  System.out.println("10,000 at 4% interest = " + calculateInterest(10000, 4));
        //  System.out.println("10,000 at 5% interest = " + calculateInterest(10000, 5));

        for (int interestRate = 1; interestRate <= 5; interestRate++) {
            double amount = 10000;
            System.out.println(amount + " at " + interestRate + "% interest = " + calculateInterest(amount, interestRate));
        }

        for (double i = 7.5; i <= 10; i = i + 0.25D) {
            //  i is common designator of the ITERATION VARIABLE;
            double amount = 100;
            double interestRate = i;
            double interestAmount = calculateInterest(amount, interestRate);
            //  BREAK can be used inside IF to exit loop before the FOR;
            if (interestAmount > 8.5) {break;}
            System.out.println(amount + " at " + interestRate + "% interest = " + interestAmount);
        }

    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100D));
    }

}
