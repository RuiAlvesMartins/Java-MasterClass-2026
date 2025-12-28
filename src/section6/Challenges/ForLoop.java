package section6.Challenges;

public class ForLoop {

    public static void main(String[] args) {
        
        // int wholeNumber = 4;
        // System.out.println(wholeNumber + " is " + (isPrimeNumber(wholeNumber) ? "" : "not ") + "a prime number");

        //  for (int i = -1; i <= 20; i++) {
        //      int wholeNumber = i;
        //      System.out.println(wholeNumber + " is " + (isPrimeNumber(wholeNumber) ? "" : "not ") + "a prime number");
        //  }

        //  threePrimes(100, 150);

        divisibleByThreeAndFive(1, 1000);

    }

    public static boolean isPrimeNumber(int n) {
        if (n <= 0) {
            System.out.println(n + " is not a valid input! Whole number must be positive!");
            return false;
        }

        if (n <= 2) {return true;}
        
        //  this is my solution
        //  for (int i = n - 1; n%i != 0; i--) {
        //  
        //      if (i == 2) {
        //          return true;
        //      }
        //  }
        //  return false;

        //  this is Buchalka's solution, it is much more efficient
        for (int i = 2; i <= (n/2); i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void threePrimes(int n1, int n2) {
        if (n1 <= 0 || n2 <= 0) {
            System.out.println("Invalid input, number range must be positive!");
        }
        if (n1 > n2) {
            int n3 = n1;
            n1 = n2;
            n2 = n3;
        }
        int primeCounter = 0;
        for (int i = n1; i <= n2; i++) {
            if (isPrimeNumber(i)) {
                System.out.println(i+" is a prime number!");
                primeCounter++;
            }
            if (primeCounter == 3) {
                // System.out.println("break flag");
                break;
            }
        }

    }

    public static void divisibleByThreeAndFive(int n1, int n2) {
        if (n1 <= 0 || n2 <= 0) {
            System.out.println("Invalid input, number range must be positive!");
        }
        if (n1 > n2) {
            int n3 = n1;
            n1 = n2;
            n2 = n3;
        }
        int divisorCount = 0;
        int divisiorSum = 0;
        for (int i = n1; i <= n2; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    divisorCount++;
                    divisiorSum+=i;
                    System.out.println(i+" is divisible by both 3 and 5!");
                    if (divisorCount == 5) {
                        break;
                    }
                }
            }
        }
        System.out.println("Sum of the first "+divisorCount+" divisors in the "+n1+" - "+n2+" range is "+divisiorSum+"!");
    }

}
