package section6.ExceptionHandlingAndUserInput;

import java.util.Scanner;

public class ConsoleScannerInput {

    //  SYSTEM.CONSOLE() is not supposed to work from an IDE, but it does;

    //  SCANNER alows for reading user input and files;
    //  import java.util.Scanner;    //  It is a class that has to be imported;
    //  Scanner scanner = new Scanner();    //  It has to be instantiated;
    //  Scanner scanner = new Scanner(System.in);    //  It can scan input from the console/terminal;
    //  Scanner scanner = new Scanner(new File ("nameOfFileOnFileSystem"));    //  It can scan input from a file;

    public static void main(String[] args) {
        
        int currentYear = 2025;

        // System.console() is not supposed to work from an IDE, but it does;
        // System.out.println(getInputFromConsole(currentYear));

        // System.out.println(getInputFromScanner(currentYear));

        System.out.println(getInputFromScanner2(currentYear));

    }

    public static String getInputFromConsole(int integer) {

        String name = System.console().readLine("Hi, what is your name?");
        System.out.println("Hi " + name + ", thanks for taking the course!");

        String dateOfBirth = System.console().readLine("What year were you born?");
        int age = integer - Integer.parseInt(dateOfBirth);

        return "So you are " + age + " years old";

    }

    public static String getInputFromScanner(int integer) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi, wht is your name?");
        String name = scanner.nextLine();

        System.out.println("Hi " + name + ", thanks for taking the course!");

        System.out.println("What year were you born?");
        String dateOfBirth = scanner.nextLine();
        int age = integer - Integer.parseInt(dateOfBirth);

        return "So you are " + age + " years old";

    }

    public static int checkData(int currentYear, String dateOfBirth) {

        int dob = Integer.parseInt(dateOfBirth);
        int minimumYear = currentYear - 125;
        
        if ((dob < minimumYear) || (dob > currentYear)) {
            return -1;
        }

        return (currentYear - dob);

    }

    public static String getInputFromScanner2(int currentYear) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi, wht is your name?");
        String name = scanner.nextLine();

        System.out.println("Hi " + name + ", thanks for taking the course!");

        System.out.println("What year were you born?");

        boolean validDob = false;
        int age = -1;

        do {
            System.out.println("Enter a year of birth after " + 
                    (currentYear - 125) + " and before " + (currentYear ));
            try {
                age = checkData(currentYear, scanner.nextLine());
            } catch (NumberFormatException badUserData) {
                System.out.println("Invalid input! Try agin!");
            }
                    
            validDob = age == -1 ? false : true;
        } while (!validDob);

        return "So you are " + age + " years old";

    }

}
