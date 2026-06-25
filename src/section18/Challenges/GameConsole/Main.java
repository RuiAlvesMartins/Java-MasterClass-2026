package section18.Challenges.GameConsole;

public class Main {
    
    //DONE create simple game
    //DONE create simple player
    //DONE test the console with the simple game

    public static void main(String[] args) {

        var console = new GameConsole<>(new section16.Challenges.RockPaperScisors.Game("Rock, Paper, Scisors"));
        // int playerIndex = console.addPlayer();
        // console.playGame(playerIndex);

        var consolePirateGame = new GameConsole<>(new section16.Challenges.PirateGame.Game("Treasure Adventure"));
        // int playerIndex = consolePirateGame.addPlayer();
        // consolePirateGame.playGame(playerIndex);

        var consoleTreasureIsland = new GameConsole<>(new section16.Challenges.TreasureIsland.Game("Ostrov Sokrovishch"));
        int playerIndex = consoleTreasureIsland.addPlayer();
        consoleTreasureIsland.playGame(playerIndex);
    }

}
