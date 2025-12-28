package section4.Operators;

public class LogicalOperators {

    //  https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html
    //  https://www.cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html

    public static void main(String[] args) {
        
        int topScore = 100;
        int secondTopScore = 60;

        if (topScore == 100) {
            System.out.println("You got the highscore!");
        }

        if (topScore == 100);
        if (topScore != 100);
        if (topScore > 100);
        if (topScore >= 100);
        
        // AND operator && (single & is bitwise operator)
        if ((topScore >= secondTopScore) && (topScore <= 100)) {
            System.out.println("Between First and Second Top Scores!");
        }

        // OR operator || (single | is bitwise operator)
        if ((topScore > 90) || (secondTopScore <= 50)) {
            System.out.println("Flag OR");
        }

        boolean isGay = false;
        //  you can assign a value to a boolean variable inside an if condition
        if (isGay = true) {
            System.out.println("You are gay!");
        }

        isGay = false;
        if (isGay) {
            //  this condition is TRUE
            System.out.println("You are gay!");
        }

        if (!isGay) {
            //  this condition is FALSE
            System.out.println("You should try Starbuck's new SoyLatteTM, it goes well with that avocado toast.");
        }

    }

}
