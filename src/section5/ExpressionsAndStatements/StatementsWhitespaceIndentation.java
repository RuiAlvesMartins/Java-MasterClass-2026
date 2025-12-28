package section5.ExpressionsAndStatements;

public class StatementsWhitespaceIndentation {

    //  What is whitespace?
    //      Whitespace is any extra spacing, horizontally or vertically, placed around Java source code.
    //      It's usually added for human readability purposes.
    //      In Java, all these extra spaces are ignored.

    //  https://google.github.io/styleguide/javaguide.html#s4.6-whitespace

    public static void main(String[] args) {
        
        int myVariable = 50;

        myVariable++;
        myVariable--;

        System.out.println("This is a test.");

        System.out.println("This is" + 
            " another" +
            " test."
        );

        int anotherVariable=50;myVariable--;System.out.println("myVariable = "+myVariable);
        System.out.println(myVariable == anotherVariable);

    }

}
