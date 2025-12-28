package section5.Challenges;

public class Methods {

    public static void main(String[] args) {
        
        String playerName = "José Figueiras";
        int playerScore = 1500;

        displayHighScorePosition(playerName, playerScore);
        displayHighScorePosition("Michael Hunt", 1000);
        displayHighScorePosition("John Doe", 500);
        displayHighScorePosition("Mickey Mouse", 100);
        displayHighScorePosition("Inigo Montoya", 25);

    }

    public static int calculateHighScorePosition(int playerScore) {

        int result = 4;

        if (playerScore >= 1000) {
            result = 1;
        } else if (playerScore >= 500) {
            result = 2;
        } else if (playerScore >= 100) {
            result = 3;
        }

        return result;

    }

    public static void displayHighScorePosition(String playerName, int playerScore) {
        System.out.println(playerName + "'s score is #" + calculateHighScorePosition(playerScore));
    }





}
