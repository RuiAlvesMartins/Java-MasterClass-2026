package section15.JavaCollections.Sueca;

public record Card(Suit suit, String color, String face, int rank) {

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

        public String getColor() {
            return switch(this) {
                case CLUB, SPADE -> "Black";
                case HEART, DIAMOND -> "Red";
                default -> null;
            };
        }
    }

    public static Card getNumericCard(Suit suit, int number, int rank) {
        if (number < 2 || number > 10) {
            System.out.println("Face must be between 2 and 10");
            return null;
        }
        return new Card(suit, suit.getColor(), String.valueOf(number), rank);
    }

    public static Card getFaceCard(Suit suit, char face, int rank) {
        if (face != 'J' && face != 'Q' && face != 'K' && face != 'A') {
            System.out.println("Face must be J, Q, K or A");
            return null;
        }
        return new Card(suit, suit.getColor(), String.valueOf(face), rank);
    }

    @Override
    public String toString() {
        return String.format("%s%c(%d)", face, suit.getIcon(), rank);

    }

}
