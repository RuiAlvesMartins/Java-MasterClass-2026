package section16.Challenges.GameConsole;

import java.util.Scanner;

public class GameConsole <T extends Game<? extends Player>> {
    
    //  Game Console is to be a container for execution of scanner code;
    //  Driving a text base game;
    //  will collect user name, creating player from that;
    //  start a while loop, display menu of options, then solicit player response;
    //  will execute Game/Player method, based on user's selected action;
    //  end the game when player decides to;

    private static final Scanner scn = new Scanner(System.in);
    private final T game;

    //  constructor should take a new instance of a game;
    public GameConsole(T game) {
        this.game = game;
    }

    public final int addPlayer() {
        //  prompt user for name
        //  validate response from scanner
        //  pass it to addPlayer on Game

        System.out.print("Input player's name: ");
        String playerName = scn.nextLine();

        int result = this.game.addPlayer(playerName);
        System.out.println();
        System.out.println("Wellcome to %s, %s!".formatted(this.game.getGameName(), playerName));
        return result;
    }

    public final void playGame(int playerIndex) {
        boolean exit = false;
        while (!exit) {
            
            System.out.println();
            System.out.println("-".repeat(90));
            var gameOptions = this.game.getGameActions(playerIndex);
            System.out.println("What to do? Pick an option:");
            System.out.println();

            //  display all available game options
            for (var option : gameOptions.values()) {
                System.out.println("\t %s (%s)".formatted(option.prompt(), option.key()));
            }

            //  solicit user input in a while loop
            System.out.println();
            System.out.print("Choose: ");
            char input = scn.nextLine().toUpperCase().charAt(0);
            System.out.println();

            if (gameOptions.containsKey(input)) {
                //  call the action associated with input
                exit = this.game.executeGameAction(playerIndex, gameOptions.get(input));
            }

            else {
                System.out.println("Input %s unrecognized.".formatted(input));
            }


        }

        
    }

}
