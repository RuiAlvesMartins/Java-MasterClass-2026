package section4.Operators;

public class TernaryOperator {

    //  https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html
    //  https://www.cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html

    //  Ternary Operator has 3 operands:
    //      x: condition (must be a boolean)
    //      y: result if true
    //      z: result if false
    //  
    //      x ? y : z

    public static void main(String[] args) {
        
        String autoMaker = "Opel Corsa";
        boolean isDomestic = autoMaker == "Opel Corsa" ? false : true;
        if (isDomestic) {
            System.out.println("This car is domestic to our country.");
        }
        String isDomesticString = isDomestic ? "This car is domestic to our country." : "This car is imported.";
        System.out.println(isDomesticString);

        int ageOfClient = 20;
        String ageText = ageOfClient >= 18 ? "over eighteen." : "still a kid.";
        System.out.println("Our client is " + ageText);

        //  statement is more readable if you add parenthesis on the conditional operator
        //  String ageText = (ageOfClient >= 18) ? "over eighteen." : "still a kid.";
    }

}
