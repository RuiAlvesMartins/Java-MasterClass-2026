package section15.HashSetsAndMaps;

public class PlayingCard {
    
    private String suit;
    private String face;
    private int internalHash;

    public PlayingCard(String suit, String face) {
        this.suit = suit;
        this.face = face;
        // this.internalHash = 1;
        this.internalHash = suit.equals("Hearts") ? 11 : 12;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }

    // @Override
    // public boolean equals(Object obj) {
    //     System.out.println("--> Checking Playing Card equality");
    //     return true;
    // }

    // @Override
    // public int hashCode() {
    //     return internalHash;
    // }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        PlayingCard that = (PlayingCard) obj;

        if (!suit.equals(that.suit)) return false;
        return face.equals(that.face);
    }

    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + face.hashCode();
        return result;
    }

    //  If you are using your classes in hashed collections, you SHOULD OVERRIDE both .equals() and .hashCode()!
    //  When overriding .equals() and .hashCode(), your code should:
    //          Be very fast to compute;
    //          Produce a consistent result each time it's called;
    //          Objects that are considered equal should produce the same hashCode;
    //          Values used in the calculation should not be mutable;
    //  A small PRIME NUMBER is used as a multiplier when overriding .hashCode():
    //          This helps spread out hash codes more evenly, reducing the chance that different objects end up with the same hash code;
    //          Very useful if the data might naturally cluster or follow patterns;
    //          Very large prime numbers are ineficcient;
    //          Very small primes (2, 3, 5, 7) run the risk of less effective distribution, as many numbers are divisible by them;
    //          31, 29, 37, 43, or even non-primes like 33 do just fine;
    
}
