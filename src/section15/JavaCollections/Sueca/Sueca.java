package section15.JavaCollections.Sueca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Sueca {
    
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);
    
    static List<Card> deck = getDeck();
    static Player[] players = new Player[4];

    static int shuffleIndex;
    static int dealerIndex;

    Card tableCard;

    // TODO make a constructor
    public Sueca() {

    }


    public static List<Card> getDeck() {
        List<Card> deck = new ArrayList<>(40);
        for (Card.Suit suit : Card.Suit.values()) {
            for(int i = 2; i < 8; i++) {
                int numericRank = i == 7 ? 10 : 0;
                deck.add(Card.getNumericCard(suit, i, numericRank));
            }
            for(char c : new char[] {'J', 'Q', 'K', 'A'}) {
                int faceRank = switch (c) {
                    case 'J' -> 2;
                    case 'Q' -> 3;
                    case 'K' -> 4;
                    case 'A' -> 11;
                    default -> 0;
                };
                deck.add(Card.getFaceCard(suit, c, faceRank));
            }
        }
        return deck;
    }


    public static void printDeck(List<Card> deck, String description, int rows) {

        int cardsPerRow = deck.size()%rows == 0 ? deck.size()/rows : deck.size()/rows + 1;
        System.out.println("-".repeat(30));
        System.out.println(description);

        for (int j=0; j<rows; j++) {
            for (int i=0; i<cardsPerRow; i++) {
                int cardIndex = j*cardsPerRow + i;
                if (cardIndex < deck.size()) {
                    System.out.print(deck.get(cardIndex) + " ");
                }
            }
            System.out.println("");
        }

    }

    public static void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public static void sliceDeck(List<Card> deck) {
        int randomIndex = random.nextInt(1, deck.size() -1);
        Collections.rotate(deck, randomIndex);
    }

    public static void inputPlayers() {
        for(int i=0; i<players.length; i++) {
            System.out.printf("Input Player %d: ", i + 1);
            players[i] = new Player(scanner.next());
        }        
    }

    public static boolean inputPlayers(String[] playerNames) {
        if (playerNames.length == players.length) {
            for (int i=0; i<players.length; i++) {
                players[i] = new Player(playerNames[i]);
            }
            return true;
        }
        return false;
    }

    public static void printPlayers() {
        System.out.println();
        System.out.println("-".repeat(30));
        System.out.println("Team #1:");
        System.out.println("Player 1: " + players[0].getName());
        System.out.println("Player 3: " + players[2].getName());
        System.out.println("-".repeat(30));
        System.out.println("Team #2:");
        System.out.println("Player 2: " + players[1].getName());
        System.out.println("Player 4: " + players[3].getName());
        System.out.println("-".repeat(30));
        System.out.println();
    }

    public static void runGame() {

        System.out.printf("%n%n%nSUECA%n");
        System.out.printf("%nWho is playing?%n");

        Boolean pIsNull = false;
        for (Player p : players) {
            pIsNull = p == null;
            if (pIsNull) {
                break;
            }
        }
        if (pIsNull) {
            inputPlayers();
        }
        printPlayers();

        
        Boolean validatedInput = false;
        do {
            System.out.printf("Which player will start the game?%n");
            String input = scanner.nextLine();
            for (int i=0; i<players.length; i++) {
                if (players[i].getName().equalsIgnoreCase(input)) {
                    validatedInput = true;
                    shuffleIndex = i;
                    dealerIndex = indexDisplacer(i, 3);
                    break;
                }
            }
            if (!validatedInput) {
                System.out.printf("%nPlayer %s not found!%n", input);
            }
        } while (!validatedInput);
        System.out.printf("%n%s starts the game!", players[shuffleIndex].getName());

        System.out.printf("%n%s shuffles the deck...%n", players[shuffleIndex].getName());
        shuffleDeck();
        // printDeck(deck, "Shuffled Deck", 4);

        System.out.printf("%n%s slices the deck...%n", players[indexDisplacer(shuffleIndex, 2)].getName());
        // printDeck(deck, "Sliced Deck", 4);

        deal();






        System.out.println("GOT TO THE FINNISH LINE!!!");



    }

    public static int indexDisplacer(int startingIndex, int displacement) {
        int finalIndex = startingIndex;
        for(int i=0; i<displacement; i++) {
            if (finalIndex == players.length -1) {
                finalIndex = -1;
            }
            finalIndex++;
        }
        return finalIndex;
    }

    static void deal() {
        int dealCode = -1;
        do {
            System.out.printf("%n%s will deal the hands%n", players[dealerIndex].getName());
            System.out.println("From the top or the bottom of the deck?");
            System.out.printf("(type 't' for top or 'b' for bottom)%n");
            String input = scanner.next();
            dealCode = switch (input.toUpperCase()) {
                case "T", "TOP" -> 1;
                case "B", "BOTTOM" -> 0;
                default -> -1;
            };
            System.out.println();
        } while (dealCode == -1);

        if (dealCode == 1) {dealTop();}
        if (dealCode == 0) {dealBottom();}

    }

    static void dealTop() {
        //  remove card from top, deal from bottom;
        //  tableCard for dealer, deal 9 dealer, deal 10 right x3
        // printDeck(deck, "sliced", 4);

        //  TODO fix this
        Card tableCard = deck.get(0);
        // System.out.println("table card = " + tableCard);
        System.out.printf("%n%s deals the first card from the top of the deck...%n", players[dealerIndex].getName());

        Card[] dealerDeck = new Card[10];
        dealerDeck[0] = tableCard;
        // players[dealerIndex].setDeck(Arrays.asList(dealerDeck));
        // printDeck(players[dealerIndex].getDeck(), players[dealerIndex].getName() + "'s deck:", 1);
        System.out.printf("A %s is flipped on the table, for everyone to see%n", tableCard);
        System.out.printf("%s will be the trump suit%n", tableCard.suit().getIcon());

        //  deal dealer's hand
        for(int i=0; i<9; i++) {
            dealerDeck[i+1] = deck.get(deck.size()-1 -i);
        }
        players[dealerIndex].setDeck(Arrays.asList(dealerDeck));
        System.out.printf("%n%s deals himself nine more cards%n", players[dealerIndex].getName());
        // printDeck(players[dealerIndex].getDeck(), players[dealerIndex].getName() + "'s deck:", 1);

        //  deal other player's hands
        for(int j=0; j<3; j++) {
            int playerIndex = indexDisplacer(dealerIndex, j+1);
            Card[] playerDeck = new Card[10];
            for(int i=0; i<10; i++) {
                playerDeck[i] = deck.get(deck.size()-1 -9 -j*playerDeck.length -i);
            }
            players[playerIndex].setDeck(Arrays.asList(playerDeck));
            System.out.printf("%n%s deals %s ten cards%n", 
                        players[dealerIndex].getName(), 
                        players[playerIndex].getName()
            );
            // printDeck(players[playerIndex].getDeck(), players[playerIndex].getName() + "'s deck:", 1);
        }


    }

    static void dealBottom() {
        //  remove card from bottom, deal from top;
        //  tableCard for dealer, deal 10 right x3, final 9 cards for dealer
        // printDeck(deck, "Sliced", 4);

        //  TODO fix this
        Card tableCard = deck.get(deck.size()-1);
        // System.out.println("table card = " + tableCard);
        System.out.printf("%n%s deals the first card from the bottom of the deck...%n", players[dealerIndex].getName());

        Card[] dealerDeck = new Card[10];
        dealerDeck[0] = tableCard;
        // players[dealerIndex].setDeck(Arrays.asList(dealerDeck));
        // printDeck(players[dealerIndex].getDeck(), players[dealerIndex].getName() + "'s deck:", 1);
        System.out.printf("A %s is flipped on the table, for everyone to see%n", tableCard);
        System.out.printf("%s will be the trump suit%n", tableCard.suit().getIcon());

        //  deal other player's hands
        for(int j=0; j<3; j++) {
            int playerIndex = indexDisplacer(dealerIndex, j+1);
            Card[] playerDeck = new Card[10];
            for(int i=0; i<10; i++) {
                playerDeck[i] = deck.get(j*playerDeck.length + i);
            }
            players[playerIndex].setDeck(Arrays.asList(playerDeck));
            System.out.printf("%n%s deals %s ten cards%n", 
                        players[dealerIndex].getName(), 
                        players[playerIndex].getName()
            );
            // printDeck(players[playerIndex].getDeck(), players[playerIndex].getName() + "'s deck:", 1);
        }

        //  deal dealer's hand
        for(int i=0; i<9; i++) {
            dealerDeck[i+1] = deck.get(30 + i);
        }
        players[dealerIndex].setDeck(Arrays.asList(dealerDeck));
        System.out.printf("%n%s deals himself the last nine cards%n", players[dealerIndex].getName());
        // printDeck(players[dealerIndex].getDeck(), players[dealerIndex].getName() + "'s deck:", 1);

    }


}
