package section15.JavaCollections.Games.Poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import section15.JavaCollections.Games.Card;

public class PokerGame {
    
    private final List<Card> deck = Card.getStandardDeck();
    private int playerCount;
    private int cardsInHand;
    private List<PokerHand> pokerHands;
    private List<Card> remainingCards;

    public PokerGame(int playerCount, int cardsInHand) {
        this.playerCount = playerCount;
        this.cardsInHand = cardsInHand;
        pokerHands = new ArrayList<>(cardsInHand);
    }

    public void startPlay() {
        Card.printDeck(deck, "Standard Deck");
        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck");
        int randomMiddle = new Random().nextInt(18, 34);
        Collections.rotate(deck, randomMiddle);
        Card.printDeck(deck, "Sliced Deck");

        deal();
        System.out.println("-".repeat(30));
        Consumer<PokerHand> checkHand = PokerHand::evalHand;
        pokerHands.forEach(checkHand.andThen(System.out::println));

        int cardsDealt = playerCount * cardsInHand;
        int cardsRemaining = deck.size() - cardsDealt;

        //  Why use Collections.nCopies()?
        //  because it allows us to use .replaceAll() further down the line;
        //  while new ArrayList<>(Capacity) won't have any elements inside it to replace!
        // remainingCards = new ArrayList<>(cardsRemaining);
        remainingCards = new ArrayList<>(Collections.nCopies(cardsRemaining, null));
        remainingCards.replaceAll(c -> deck.get(cardsDealt + remainingCards.indexOf(c)));
        //  this will print an empty deck if you instantiate rremainingCards = new ArrayList<>(cardsRemaining); !!!
        Card.printDeck(remainingCards, "Remaining Cards", 2);

    }   
    
    public void deal() {
        Card[][] hands = new Card[playerCount][cardsInHand];
        int deckIndex = 0;

        for(int i=0; i<cardsInHand; i++) {
            for(int j=0; j<playerCount; j++) {
                //  this will assign the current value of deckIndex to deck.get()
                //  whilst at the same time moving it forward (deckIndex++)
                hands[j][i] = deck.get(deckIndex++);

            }
        }

        int playerNo = 1;
        for (Card[] hand : hands) {
            pokerHands.add(new PokerHand(playerNo++, Arrays.asList(hand)));
        }
    }

}
