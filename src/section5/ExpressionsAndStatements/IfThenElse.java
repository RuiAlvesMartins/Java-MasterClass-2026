package section5.ExpressionsAndStatements;

public class IfThenElse {



    public static void main(String[] args) {
        
        boolean gameOver = true;
        int score = 5000;
        int levelCompleted = 5;
        int bonus = 100;

        //  if (score == 5000) {
        //      System.out.println("Your score was 5000");
        //  } else if (score < 5000) {
        //      System.out.println("Your score was less than 5000");
        //  } else {
        //      System.out.println("Your score was greater than 5000");
        //  }



        //  if (score < 5000 && score > 1000) {
        //      System.out.println("Your score less than 5000 but more than 1000");
        //  } else if (score < 1000) {
        //      System.out.println("Your score less than 1000");
        //  } else {
        //      System.out.println("Got here");
        //  }


        int finalScore = score;

        if (gameOver) {     //  gameOver == true
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }

    }

}
