package section5.Methods;

public class Methods {

    // SIGNATURE: the name of the method, as well as its parameters 

    public static void main(String[] args) {
        // calculateScore();
        // System.out.println("Got here");

        boolean gameOver = true;
        int score = 800;    
        int levelCompleted = 8;
        int bonus = 200;

        // calculateScore2(gameOver, score, levelCompleted, bonus);

        // int finalScore = calculateScore3(gameOver, score, levelCompleted, bonus);
        // System.out.println("Your final score was " + finalScore);
        System.out.println("Your final score was " + calculateScore3(gameOver, score, levelCompleted, bonus));
    }

    //  no arguments, returns nothing
    public static void calculateScore() {
        
        boolean gameOver = true;
        int score = 5000;
        int levelCompleted = 5;
        int bonus = 100;
        int finalScore = score;

        if (gameOver) {     //  gameOver == true
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }

    }

    //  four arguments, returns nothing
    public static void calculateScore2(boolean gameOver, int score, int levelCompleted, int bonus) {

        if (gameOver) {     //  gameOver == true
            score += (levelCompleted * bonus);
            System.out.println("Your final score was " + score);
        }

    }

    //  four arguments, returns an int
    public static int calculateScore3(boolean gameOver, int score, int levelCompleted, int bonus) {

        if (gameOver) {     //  gameOver == true
            score += (levelCompleted * bonus);
            return score;
        } else {
            System.out.println("Game is still running");
            return score;
        }

    }

}
