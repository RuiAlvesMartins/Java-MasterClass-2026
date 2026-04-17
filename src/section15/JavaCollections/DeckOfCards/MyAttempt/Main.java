package section15.JavaCollections.DeckOfCards.MyAttempt;

public class Main {

    public static void main(String[] args) {
        
        System.out.print(Card.Suit.CLUB.getSuit());
        System.out.print(Card.Suit.DIAMOND.getSuit());
        System.out.print(Card.Suit.HEART.getSuit());
        System.out.print(Card.Suit.SPADE.getSuit());

        System.out.printf("%n%n%n");

        Card card1 = Card.getNumericCard(Card.Suit.CLUB, 2, 0);
        System.out.println(card1);

        Card.printDeck("Standard Deck", Card.getStandardDeck());



    }

}
