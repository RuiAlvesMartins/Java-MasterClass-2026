package section6.Challenges;

import java.util.Scanner;

public class ReadingUserInput {

    public static void main(String[] args) {
        
        // readFiveNumbers();
        // readFiveDecimals();
        readMinMaxInt();

    }

    // validtion
    public static boolean validateInteger (int integer, int minInt, int maxInt) {

        if (integer < minInt || integer < maxInt) {
            return false;
        }

        return true;

    }

    public static void readFiveNumbers() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("READ FIVE NUMBERS PROGRAM");

        String stringInput = "";
        int number = 0;
        int numberCount = 1;
        int numberSum = 0;
        
        boolean validInput = false;

        do {

            do {

                System.out.println("Please input the #"+numberCount+" number:");
                stringInput = scanner.nextLine();

                try {
                    number = Integer.parseInt(stringInput);
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input!");
                    System.out.println("Valid integer range: "+Integer.MIN_VALUE+" to "+Integer.MAX_VALUE);
                }

            } while (!validInput);

            System.out.println("#"+numberCount+" is "+number);

            validInput = false;
            numberCount++;
            numberSum+=number;

        } while (numberCount <= 5);

        System.out.println("The sum of the 5 inputed numbers is "+numberSum);
        System.out.println("PROGRAM EXIT");

    }

    public static void readFiveDecimals() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("READ FIVE DECIMAL NUMBERS PROGRAM");

        String stringInput = "";
        double decimal = 0D;
        double decimalSum = 0D;
        int decimalCount = 1;

        do {

            System.out.println("Please input the #"+decimalCount+" number:");
            stringInput = scanner.nextLine();

            try {

                decimal = Double.parseDouble(stringInput);
                System.out.println("#"+decimalCount+" is "+decimal);
                decimalCount++;
                decimalSum+=decimal;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                System.out.println("Valid double range: "+Double.MIN_VALUE+" to "+Double.MAX_VALUE);
            }

        } while (decimalCount <= 5);

        System.out.println("The sum of the 5 inputed numbers is "+decimalSum);
        System.out.println("PROGRAM EXIT");

    }

    public static void readMinMaxInt() {

        System.out.println("READ MINIMUM AND MAXIMUM INTEGER");

        Scanner scanner = new Scanner(System.in);
        String stringInput = "";
        int parsedInput = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean validInput = true;

        do {

            System.out.println("Please input a valid integer:");
            System.out.println("(or type a non-numeric character to exit program)");
            
            stringInput = scanner.nextLine();

            try {

                parsedInput = Integer.parseInt(stringInput);
                min = parsedInput <= min ? parsedInput : min;
                max = parsedInput >= max ? parsedInput : max;

                System.out.println(parsedInput+" read as integer");
                System.out.println("MAXMIMUM = "+max);
                System.out.println("MINIMUM = "+min);

            } catch (NumberFormatException e) {

                validInput = false;
                System.out.println(stringInput+" not read as integer");
                System.out.println("Invalid input, program closing...");

            }

        } while (validInput);

        System.out.println("MAXMIMUM = "+max);
        System.out.println("MINIMUM = "+min);
        System.out.println("PROGRAM EXIT");

    }

}
