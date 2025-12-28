package section7.Strings;

public class TextBlocksAdvancedOutputFormating {

    public static void main(String[] args) {
        
        //  ESCAPE SEQUENCES
        //  They start with a "\" followed by a character;
        //  Input a special functionality to a string;

        //      \t      inserts tab character;
        //      \n      inserts new line character;
        //      \"      inserts double quote character;
        //      \\      inserts backslash character;
        //      \u2022  inserts bullet point character;

        String bulletIt = "Pring a Bulleted List:\n" + 
                "\t\u2022 First Point\n" +
                "\t\t\u2022 Sub Point";
        
        System.out.println(bulletIt);



        //  TEXT BLOCK
        //  Introduced in JDK15;
        //  Is a special format for STRING LITERALS;
        //  It uses the indentation in the code as the indentation for the output, making it much simpler to write;
        //  However, if you indent code wrong, indentation in output will also be wrong! 

        String textBlock = """
                Print a Bulleted List:
                        \u2022 First Point
                                \u2022 Sub Point
                """;
        
        System.out.println(textBlock);



        //  FORMAT SPECIFIERS
        //  %[argument_index$][flags][width][.precision]conversion
        //  https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Formatter.html       
        //  Allow variables to be formated into a string;

        //  PRINTF()
        //  A method of System.out that implements format specifiers;
        //  Variables to be formated are passed as arguments;

        //  %d formats integers, longs, shorts, etc;
        //  %n inserts new line;
        int age = 35;
        System.out.printf("Your age is %d%n", age);

        //  multiple specifiers can recive multiple arguments;
        int yearOfBirth = 2023 - age;
        System.out.printf("Age = %d, Birth year = %d%n", age, yearOfBirth);

        //  %f formats doubles, floats, etc;
        double valueOfPi = 3.1416D;
        System.out.printf("The value of Pi is %f%n", valueOfPi);

        //  %.2f formats doubles up to 2 decimals;
        double eulerNumber = 2.7183D;
        System.out.printf("The value of Euler's Number is %.2f%n", eulerNumber);

        //  you can also cast arguments into a specific format;
        double currentBalance = 50.25D;
        System.out.printf("Your current balance is %d%n", (int) currentBalance);

        //  %6d formats integers with 6 figures;
        for (int i = 1; i <= 100_000; i *= 10) {
            System.out.printf("Printing %6d %n", i);
        }



        //  FORMAT()
        //  A method of String that implements format specifiers;
        //  Variables to be formated are passed as arguments;

        String formattedString = String.format("Your age is %d", age);
        System.out.println(formattedString);

        //  FORMATED()
        //  A method of String that implements format specifiers;
        //  Only the variables to be formated are passed as arguments;

        formattedString = "You are %d years old".formatted(age);
        System.out.println(formattedString);
    }

}
