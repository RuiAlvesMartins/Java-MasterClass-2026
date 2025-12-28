package section6.ExceptionHandlingAndUserInput;

import java.util.Scanner;

public class ExceptionHandling {

    //  EXCEPTION is an error that happens in code;
    //  https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Exception.html

    //  TRY {} CATCH {}
    //  try is where you write the code to be tested for errors;
    //  catch is where you write what to do when an exception is caught;

    public static void main(String[] args) {

        int currentYear = 2025;

        //  this will not throw an exception, I don't know why;
        try {
            System.out.println(getInputFromConsole(currentYear));
        } catch (NullPointerException e) {
            System.out.println(getInputFromScanner(currentYear));
        }
        
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

}
