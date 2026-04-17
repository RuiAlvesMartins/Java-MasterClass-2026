package section15.JavaCollections.DeckOfCards.MyAttempt;

public record Card(Suit suit, String face, int rank) {

    enum Suit {
        CLUB, 
        DIAMOND, 
        HEART, 
        SPADE;

        public char getSuit() {
            return switch(this) {
                // case CLUB -> "\u2663";
                // case DIAMOND -> "\u2666";
                // case HEART -> "\u2665";
                // case SPADE -> "\u2660";
                case CLUB -> (char) 9827;
                case DIAMOND -> (char) 9830;
                case HEART -> (char) 9829;
                case SPADE -> (char) 9824;
                default -> ' ';
            };
        }

    }

    public static Card getNumericCard(Suit suit, int number, int rank) {
        if (number < 2 || number > 10) {
            throw new IllegalArgumentException("Face must be between 2 and 10");
        }
        return new Card(suit, String.valueOf(number), rank);
    }

    public static Card getFaceCard(Suit suit, char face, int rank) {
        if (face == 'J' || face == 'Q' || face == 'K' || face == 'A') {
            return new Card(suit, String.valueOf(face), rank);
        }
        throw new IllegalArgumentException("Face must be J, Q, K or A");
        
    }

    @Override
    public String toString() {
        return String.format("%s%c(%d)", face, suit.getSuit(), rank);

    }

    public static Card[][] getStandardDeck() {
        Suit[] suits = Suit.values();
        Card[][] deck = new Card[suits.length][13];

        for (int j = 0; j < suits.length; j++) {
            for(int i = 0; i < 13; i++) {
                if(i > 8) {
                    // System.out.println("this is position " + i);
                    deck[j][i] = switch(i) {
                        case 9 -> getFaceCard(suits[j], 'J', i);
                        case 10 -> getFaceCard(suits[j], 'Q', i);
                        case 11 -> getFaceCard(suits[j], 'K', i);
                        case 12 -> getFaceCard(suits[j], 'A', i);
                        default -> throw new IllegalArgumentException("Face must be J, Q, K or A");

                    };
                    continue;
                }
                deck[j][i] = getNumericCard(suits[j], i+2, i);
            }
        }

        return deck;

    }

    public static void printDeck(String description, Card[][] deck) {

        System.out.println(description);

        for(int j = 0; j < Suit.values().length; j++) {
            String line = "";
            for(int i = 0; i < 13; i++) {
                line = line + deck[j][i].toString() + " ";
            }
            System.out.println(line);
        }

    }

}
