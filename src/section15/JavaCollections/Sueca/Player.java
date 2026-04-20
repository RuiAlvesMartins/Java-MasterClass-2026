package section15.JavaCollections.Sueca;

import java.util.ArrayList;
import java.util.List;

public class Player {
    
    String name;
    List<Card> deck;

    public Player(String name) {
        this.name = name;
        this.deck = new ArrayList<>(10);
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public List<Card> getDeck() {
        return deck;
    }

    void setDeck(List<Card> deck) {
        this.deck = deck;
    }


    
    

}
