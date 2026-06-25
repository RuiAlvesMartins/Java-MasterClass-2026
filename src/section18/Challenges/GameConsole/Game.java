package section18.Challenges.GameConsole;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Game <T extends Player> {
    
    private final String gameName;
    private final List<T> players = new ArrayList<>();
    private Map<Character, GameAction> standardActions = null;

    public abstract T createNewPlayer(String name);
    public abstract Map<Character, GameAction> getGameActions(int playerIndex);

    //DONE include getter and helper methods as appropriate
    protected Game(String gameName) {
        this.gameName = gameName;
    }
    public String getGameName() {
        return gameName;
    }
    public List<T> getPlayers() {
        //todo defensive copy?
        return players;
    }
    public Map<Character, GameAction> getStandardActions() {
        //todo defensive copy?
        if (standardActions == null) {
            standardActions = new LinkedHashMap<>(Map.of(
                'I', new GameAction('I', "Print Player Info", i -> this.printPlayer(i)),
                'Q', new GameAction('Q', "Quit Game", i -> this.quitGame(i))
            ));
        }
        return standardActions;
    }

    protected final T getPlayer(int playerIndex) {
        return players.get(playerIndex);
    }

    final int addPlayer(String name) {
        //  instantiates player and adds it to list
        //  returns player index

        T newPlayer = createNewPlayer(name);
        if (newPlayer == null) {return -1;}
        if (players.contains(newPlayer)) {return -1;}

        players.add(newPlayer);
        int newPlayerIndex = players.indexOf(newPlayer);
        System.out.println("Added Player #%d: %s".formatted(newPlayerIndex + 1, newPlayer.name()));
        return newPlayerIndex;
    }

    public boolean executeGameAction(int player, GameAction action) {
        //  calls predicate test method
        //  returns boolean

        return action.action().test(player);
    }

    public boolean printPlayer(int index) {
        T player = null;
        try {
            player = players.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Player at index #%d not found.".formatted(index));
            return false;
        }
        System.out.println(player);
        return false;
    }

    public boolean quitGame(int playerIndex) {
        T player = players.get(playerIndex);
        if (player == null) {
            return false;
        }
        System.out.println("Player #%d: %s has left the game.".formatted(playerIndex + 1, player.name()));
        return true;
    }

}
