package section15.JavaCollections.DeckOfCards;

import java.util.ArrayList;
import java.util.List;

public record Card(Suit suit, String face, int rank) {
    
    public enum Suit {
        CLUB, 
        DIAMOND, 
        HEART, 
        SPADE;

        public char getIcon() {
            return switch(this) {
                case CLUB -> (char) 9827;
                case DIAMOND -> (char) 9830;
                case HEART -> (char) 9829;
                case SPADE -> (char) 9824;
                default -> ' ';
            };
        }

        // public char getImage() {
        //     return (new char[] {9827, 9830, 9829, 9824})[this.ordinal()];
        // }



    }

    public static Card getNumericCard(Suit suit, int number) {
        if (number < 2 || number > 10) {
            System.out.println("Face must be between 2 and 10");
            return null;
        }
        return new Card(suit, String.valueOf(number), number - 2);
    }

    public static Card getFaceCard(Suit suit, char face) {
        if (face != 'J' && face != 'Q' && face != 'K' && face != 'A') {
            System.out.println("Face must be J, Q, K or A");
            return null;
        }
        int rank = switch(face) {
            case 'J' -> 9;
            case 'Q' -> 10;
            case 'K' -> 11;
            default -> 12;
        };
        return new Card(suit, String.valueOf(face), rank);
    }

    @Override
    public String toString() {
        return String.format("%s%c(%d)", face, suit.getIcon(), rank);

    }

    public static List<Card> getStandardDeck() {
        List<Card> deck = new ArrayList<>(52);
        for (Suit suit : Suit.values()) {
            for(int i = 2; i < 11; i++) {
                deck.add(getNumericCard(suit, i));
            }
            for(char c : new char[] {'J', 'Q', 'K', 'A'}) {
                deck.add(getFaceCard(suit, c));
            }
        }
        return deck;
    }

    public static void printDeck(List<Card> deck, String description, int rows) {

        int cardsInRow = deck.size() / rows;

        System.out.println("-".repeat(30));
        if (description != null) {
            System.out.println(description);
        }

        for(int i = 0; i < rows; i++) {
            int startIndex = i * cardsInRow;
            int endIndex = startIndex + cardsInRow;
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
            System.out.println();
        }

    }

    public static void printDeck(List<Card> deck, String description) {
        printDeck(deck, description, 4);
    }

}
