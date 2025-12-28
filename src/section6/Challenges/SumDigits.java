package section6.Challenges;

public class SumDigits {

    public static void main(String[] args) {
        
        System.out.println(Integer.MAX_VALUE);
        System.out.println(sumDigits(Integer.MAX_VALUE));
        System.out.println(sumDigits(Integer.MIN_VALUE));

    }

    public static int sumDigits(int number) {
        if (number < 0) {
            System.out.println("Invalid input!");
            return -1;
        }

        int dividend = number;
        int digit = 0;
        int digitSum = 0;

        while (dividend > 0) {
            digit = dividend%10;
            dividend/=10;
            digitSum+=digit;
        }

        return digitSum;
    }

}
