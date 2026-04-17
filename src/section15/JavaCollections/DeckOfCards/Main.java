package section15.JavaCollections.DeckOfCards;

import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        System.out.print(Card.Suit.CLUB.getIcon());
        System.out.print(Card.Suit.DIAMOND.getIcon());
        System.out.print(Card.Suit.HEART.getIcon());
        System.out.print(Card.Suit.SPADE.getIcon());

        System.out.printf("%n%n%n");

        Card card1 = Card.getNumericCard(Card.Suit.CLUB, 2);
        System.out.println(card1);
        Card card2 = Card.getFaceCard(Card.Suit.CLUB, 'A');
        System.out.println(card2);



        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck, "Standard Deck");

        Card[] aceOfHeartsDeck = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(aceOfHeartsDeck, aceOfHearts);
        Card.printDeck(Arrays.asList(aceOfHeartsDeck), "Ace of Hearts Deck", 1);

    }

}
