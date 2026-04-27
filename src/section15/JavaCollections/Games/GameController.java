package section15.JavaCollections.Games;

import section15.JavaCollections.Games.Poker.PokerGame;

public class GameController {
    
    public static void main(String[] args) {
        
        PokerGame fiveCardDraw = new PokerGame(8, 5);
        fiveCardDraw.startPlay();

    }

}
