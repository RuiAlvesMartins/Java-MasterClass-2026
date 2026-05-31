package section16.Challenges.RockPaperScisors;

import java.util.LinkedHashMap;
import java.util.Map;

import section16.Challenges.GameConsole.GameAction;

enum GameMoves {
    ROCK,
    PAPER,
    SCISORS
}

public class Game extends section16.Challenges.GameConsole.Game<section16.Challenges.RockPaperScisors.Player> {

    //  INSTANCE INITIALIZER
    {

    }

    public Game(String gameName) {
        super(gameName);
    }

    private boolean drawRock(int playerIndex) {
        System.out.println("You draw... Rock");
        return false;
    }

    private boolean drawPaper(int playerIndex) {
        System.out.println("You draw... Paper");
        return false;
    }

    private boolean drawScisors(int playerIndex) {
        System.out.println("You draw... Scisors");
        return false;
    }

    @Override
    public Player createNewPlayer(String name) {
        return new Player(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        
        var map = new LinkedHashMap<>(Map.of(
            'R', new GameAction('R', "Draw Rock", i -> this.drawRock(i)),
            'P', new GameAction('P', "Draw Paper", this::drawPaper),
            'S', new GameAction('S', "Draw Scisors", this::drawScisors)
        ));

        map.putAll(this.getStandardActions());
        return map;

    }
    


}
