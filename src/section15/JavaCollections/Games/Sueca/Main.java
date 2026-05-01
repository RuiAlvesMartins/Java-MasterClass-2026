package section15.JavaCollections.Games.Sueca;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    //  SUECA ou BISCA de 7

    public static void main(String[] args) {
        
            // List<Card> deck = Sueca.getDeck();
            // System.out.println(Sueca.indexDisplacer(0, 1));
            // System.out.println(Sueca.indexDisplacer(1, 1));
            // System.out.println(Sueca.indexDisplacer(2, 1));
            // System.out.println(Sueca.indexDisplacer(3, 1));

            // Sueca.printDeck("Deck", 4);
            // Sueca.shuffleDeck(deck);
            // Sueca.sliceDeck(deck);

            String[] players = {"George", "Josefina", "Salomé", "Saul"};
            Sueca.inputPlayers(players);
            

            // Sueca.runGame();


            // Sueca.dealBottom();
            


            Card twoClubs = Card.getNumericCard(Card.Suit.CLUB, 2, 0);
            Card threeClubs = Card.getNumericCard(Card.Suit.CLUB, 3, 0);
            Card fourClubs = Card.getNumericCard(Card.Suit.CLUB, 4, 0);
            Card fiveClubs = Card.getNumericCard(Card.Suit.CLUB, 5, 0);
            Card sixClubs = Card.getNumericCard(Card.Suit.CLUB, 6, 0);
            Card sevenClubs = Card.getNumericCard(Card.Suit.CLUB, 7, 10);
            Card jackClubs = Card.getFaceCard(Card.Suit.CLUB, 'J', 2);
            Card queenClubs = Card.getFaceCard(Card.Suit.CLUB, 'Q', 3);
            Card kingClubs = Card.getFaceCard(Card.Suit.CLUB, 'K', 4);
            Card aceClubs = Card.getFaceCard(Card.Suit.CLUB, 'A', 11);

            Card twoDiamonds = Card.getNumericCard(Card.Suit.DIAMOND, 2, 0);
            Card threeDiamonds = Card.getNumericCard(Card.Suit.DIAMOND, 3, 0);
            Card fourDiamonds = Card.getNumericCard(Card.Suit.DIAMOND, 4, 0);
            Card fiveDiamonds = Card.getNumericCard(Card.Suit.DIAMOND, 5, 0);
            Card sixDiamonds = Card.getNumericCard(Card.Suit.DIAMOND, 6, 0);
            Card sevenDiamonds = Card.getNumericCard(Card.Suit.DIAMOND, 7, 10);
            Card jackDiamonds = Card.getFaceCard(Card.Suit.DIAMOND, 'J', 2);
            Card queenDiamonds = Card.getFaceCard(Card.Suit.DIAMOND, 'Q', 3);
            Card kingDiamonds = Card.getFaceCard(Card.Suit.DIAMOND, 'K', 4);
            Card aceDiamonds = Card.getFaceCard(Card.Suit.DIAMOND, 'A', 11);

            Card sevenSpades = Card.getNumericCard(Card.Suit.SPADE, 7, 10);
            Card sevenHearts = Card.getNumericCard(Card.Suit.HEART, 7, 10);

            List<Card> deck = new ArrayList<>();
            deck.add(twoClubs);
            deck.add(threeClubs);
            deck.add(fourClubs);
            deck.add(fiveClubs);
            deck.add(sixClubs);
            deck.add(sevenClubs);
            deck.add(sevenDiamonds);
            deck.add(sevenSpades);
            deck.add(sevenHearts);
            deck.add(aceClubs);

            Sueca.printDeck(deck, null, 1);
            Sueca.assessScore(deck);

            List<Card> newDeck = new ArrayList<>();
            newDeck.add(twoDiamonds);
            newDeck.add(threeDiamonds);
            newDeck.add(fourDiamonds);
            newDeck.add(sevenSpades);
            newDeck.add(sevenHearts);
            newDeck.add(sevenClubs);
            newDeck.add(jackDiamonds);
            newDeck.add(queenDiamonds);
            newDeck.add(kingDiamonds);
            newDeck.add(aceDiamonds);

            Sueca.printDeck(deck, null, 1);
            Sueca.assessScore(newDeck);

    }



}
