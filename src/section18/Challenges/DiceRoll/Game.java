package section18.Challenges.DiceRoll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    
    private static Scanner scn = new Scanner(System.in);

    private static Random dice1 = new Random();
    private static Random dice2 = new Random();
    private static Random dice3 = new Random();
    private static Random dice4 = new Random();
    private static Random dice5 = new Random();



    private static int rollDice(int diceIndex) {
        int rollResult = switch (diceIndex) {
            case 1 -> dice1.nextInt(1, 7);
            case 2 -> dice2.nextInt(1, 7);
            case 3 -> dice3.nextInt(1, 7);
            case 4 -> dice4.nextInt(1, 7);
            case 5 -> dice5.nextInt(1, 7);
            default -> -1;
        };
        return rollResult;
    }

    public static void runGame() {

        List<Integer> results = new ArrayList<>(5);
        List<Integer> keep = new ArrayList<>();
        List<Integer> reRoll = new ArrayList<>();

        //  introduction
        System.out.println("Wellcome to 'Yahtzee'!");
        System.out.println("Roll five dice!");
        System.out.println("Rolling dice 1...");
        results.add(0, rollDice(1));
        System.out.println("Rolling dice 2...");
        results.add(1, rollDice(2));
        System.out.println("Rolling dice 3...");
        results.add(2, rollDice(3));
        System.out.println("Rolling dice 4...");
        results.add(3, rollDice(4));
        System.out.println("Rolling dice 5...");
        results.add(4, rollDice(5));

        while (true) {
            
            keep.clear();
            reRoll.clear();

            //  print result
            System.out.println("Your dice are: " + results);
            System.out.println();

            //  print options
            System.out.println("Press Enter to score.");
            System.out.println("Type 'All' to re-roll all the dice.");
            System.out.println("List numbers (separated by spaces) to re-roll selected dice.");

            //  receive and parse player input
            System.out.print("--> ");
            String input = scn.nextLine();
            reRoll = Arrays.stream(input.split(" "))
                      .filter(s -> s.matches("-?\\d+"))             // only valid integers; prevents NumberFormatException
                      .map(Integer::parseInt)
                      .collect(Collectors.toList());

            //  act on player input
            if (input == "") {
                System.out.println("Game over. Real game would score and continue");
                //  terminates main loop;
                break;
            }

            else if (input.toUpperCase().equals("ALL")) {
                System.out.println("Rolling dice 1...");
                results.set(0, rollDice(1));
                System.out.println("Rolling dice 2...");
                results.set(1, rollDice(2));
                System.out.println("Rolling dice 3...");
                results.set(2, rollDice(3));
                System.out.println("Rolling dice 4...");
                results.set(3, rollDice(4));
                System.out.println("Rolling dice 5...");
                results.set(4, rollDice(5));
            }

            else {
                for (int j=0; j<results.size(); j++) {
                    boolean keepThisDice = true;
                    for (int i=0; i<reRoll.size(); i++) {
                        if (results.get(j) == reRoll.get(i)) {
                            reRoll.remove(i);
                            System.out.println("Rolling dice %d...".formatted(j+1));
                            results.set(j, rollDice(j+1));
                            keepThisDice = false;
                            break;
                        }
                    }
                    if (keepThisDice) {
                        keep.add(results.get(j));
                    }
                }
                System.out.println("Keeping: " + keep);
            }

        }

    }

}
