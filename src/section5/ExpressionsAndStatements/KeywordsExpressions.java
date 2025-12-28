package section5.ExpressionsAndStatements;

public class KeywordsExpressions {

    //  https://docs.oracle.com/javase/specs/jls/se17/html/jls-3.html#jls-3.9

    //  The Expression – An expression computes to a single value.
    //  The Statement – Statements are stand alone units of work.
    //  And Code Blocks – A code block is a set of zero, one, or more statements, usually grouped together in some way to achieve a single goal.

    public static void main(String[] args) {
        
        // double kmToMiles = (100 * 1.609344);

        int highscore = 50;

        if (highscore > 25) {
            highscore = 1000 + highscore;   //  add bonus points
        }

        int health = 100;

        if ((health < 25) && (highscore > 1000)) {
            highscore = highscore - 1000;
        }

    }

}
