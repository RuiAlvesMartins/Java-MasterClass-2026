package section16.Challenges.GameConsole;

public class Main {
    
    //todo create simple game
    //todo create simple player
    //todo test the console with the simple game

    public static void main(String[] args) {

        var console = new GameConsole<>(new section16.Challenges.RockPaperScisors.Game("Rock, Paper, Scisors"));
        // int playerIndex = console.addPlayer();
        // console.playGame(playerIndex);

        var consoleTreasureIsland = new GameConsole<>(new section16.Challenges.PirateInvasion.Game("Ostrov Sokrovishch"));
        int playerIndex = consoleTreasureIsland.addPlayer();
        consoleTreasureIsland.playGame(playerIndex);

    }

}
