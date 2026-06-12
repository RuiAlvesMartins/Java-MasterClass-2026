package section16.FinalSealedClasses;

import section16.Challenges.GameConsole.Game;
import section16.Challenges.GameConsole.GameAction;
import section16.Challenges.GameConsole.GameConsole;
import section16.Challenges.GameConsole.Player;
import section16.Challenges.PirateGame.Weapon;

    //  FINAL CLASS
    //  A final class is one that can't be EXTENDED, i.e. can't ave SUBCLASSES;
    //  ENUMS and RECORDS are final classes;

    //  This is an important thing for DEFENSIVE CODING;
    //  As subclasses can take advantage of mutable fields on parent classes;

    //  Further downstream, MODULAR JDK and SEALED CLASSES will be discussed; 



//  RECORDS cannot be extended!
// class SpecialGameAction extends GameAction {} 
//  ENUMS cannot be extended!
// class SpecialWeapon extends Weapon {} 
//  FINAL classes cannot be extended!
// class SpecialGameConsole<T extends Game<? extends Player>> extends GameConsole<Game<? extends Player>> {

//     public SpecialGameConsole(Game<? extends Player> game) {
//         super(game);
//     }

// }



public final class FinalClasses {
    
    public static void main(String[] args) {
        
    //  SpecialGameConsole is extending a final class, hence the error;
        // SpecialGameConsole<section16.Challenges.PirateGame.Game> game = 
        //     new SpecialGameConsole<>(new section16.Challenges.PirateGame.Game("Treasure Island")); 

    //  Tip: Making CONSTRUCTORS PACKAGE-PRIVATE is the same as making a class FINAL;
    //  (because subclasses cannot reach and chain parent constructor to their own)

    //  GameConsole can only be instantiated here if it's constructor is PUBLIC!
        GameConsole<section16.Challenges.PirateGame.Game> game = 
            new GameConsole<>(new section16.Challenges.PirateGame.Game("Treasure Island")); 

    }
    //  A FINAL class can still be instantiated from outside if it's constructor is PUBLIC!
    //  A good alternative strategy could be making the class ABSTRCT(can be extended but not instantiated), instead of FINAL(can't be extended but can be instantiated);
    //  An ABSTRACT class can't be FINAL!



}
