package section15.JavaCollections.Sueca;

public class Player {
    
    String name;
    Card[] deck;

    public Player(String name) {
        this.name = name;
        this.deck = new Card[10];
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public Card[] getDeck() {
        return deck;
    }

    void setDeck(Card[] deck) {
        this.deck = deck;
    }

    
    

}
