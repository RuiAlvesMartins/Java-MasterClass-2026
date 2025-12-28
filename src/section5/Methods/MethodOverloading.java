package section5.Methods;

public class MethodOverloading {
    
    //  METHOD OVERLOAD occurs when:
    //  a class has multiple methods with the same name;
    //  but they all have different parameters;
    //  since their signatures are different, java allows this;

    //  a methods SIGNATURE (name of method + name, type and number of parameters) must be unique!
    
    public static void main(String[] args) {
        
        int newScore = calculateScore("Tim", 500);
        System.out.println("New score is "+newScore);
        calculateScore(75);
        calculateScore();

    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player "+playerName+" scored "+score+" points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        return calculateScore("Anonymous", score);
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score");
        return 0;
    }

    //  changing the return data type, does not change the signature!
    //  public static void calculateScore() {
    //      System.out.println("No player name, no player score");
    //  }

}
