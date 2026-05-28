package section16.Challenges.GameConsole;

public class Main {
    
    //todo create simple game
    //todo create simple player
    //todo test the console with the simple game

    public static void main(String[] args) {
        
        // GameConsole.addPlayer();

        var console = new GameConsole<>(new section16.Challenges.RockPaperScisors.Game("Rock, Papper, Scisors"));

        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);

    }

}
