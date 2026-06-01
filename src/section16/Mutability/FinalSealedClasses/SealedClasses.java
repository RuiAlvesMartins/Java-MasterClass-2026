package section16.Mutability.FinalSealedClasses;

import section16.Challenges.GameConsole.GameConsole;

public class SealedClasses {
    
    //  SEALED
    //  MODIFIER for CLASSES and INTERFACES, introduced in JDK17;
    //  Almost always acompanied by a PERMITS clause that lists allowed subclasses;
    //  Subclasses can be:
    //          Outer types;
    //          Nested types;
    //          Types declared on the same file, package or module;
    //  A sealed class and it's direct subclasses create a CIRCULAR REFERENCE!
    //  (i.e. parent class must know all of it's child classes)



    //  All sealed SUBCLASSES must:
    //          be on the same PACKAGE / MODULE as the parent;
    //          be either:
    //              FINAL:      cannot be subclassed any further;      
    //              SEALED:     can be subclassed by classes declared on it's own permits clause;
    //              NON-SEALED: can be suclassed at will (but the non_sealed modifier must be declared explicitly!);



    //  All out code so far, since JDK9, is part of the UNNAMED DEFAULT MODULE;
    //  This means that classes in other packages cant be used in the permits clause!

    public static void main(String[] args) {
        
        GameConsole<section16.Challenges.PirateGame.Game> game = 
            new GameConsole<>(new section16.Challenges.PirateGame.Game("Treasure Island")); 

    }

}
