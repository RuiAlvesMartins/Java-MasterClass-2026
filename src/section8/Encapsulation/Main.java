package section8.Encapsulation;
public class Main {

    //  ENCAPSULATION
    //  Making things private i.e. inaccessible; 
    //  Why do we want to hide things?
    //      hide unnecessary details to make interfaces simpler;
    //      protect the integrity of data on an object;
    //      decouple published interface from internal details of the class;
    //  In this case interface refers to APIs (Application Programing Interfaces), not Java's INTERFACES; 
    
    //  What if you don't encapsulate?
    //  PROBLEM #1
    //  Allowing direct access to data on an object can potentially bypass checks and additional processing your class has in place to manage the data;
    //  PROBLEM #2
    //  Allowing direct access to fields means calling code would need to change when you edit any of the fields;
    //  PROBLEM #3
    //  Omiting a constructor that would accept initialization data means the calling code is responsible for setting up this data on the new object;

    public static void main(String[] args) {
        
        //  HOW TO NOT ENCAPSULATE

        Player player = new Player();
        // Problem 2
        // player.name = "Tim";
        player.fullName = "Tim";
        // Problem 3
        // player.health = -1;
        player.health = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());

        // Problem 1
        // player.health = 200;
        player.loseHealth(11);
        System.out.println("Remaining health = " + player.healthRemaining());



        //  HOW TO ENCAPSULATE PROPERLY

        //  even though we pass invalid data (health = 200), a constructor with proper validation code will not allow for it;
        EnhancedPlayer tim = new EnhancedPlayer("Tim", 200, "Sword");
        System.out.println("Initial health = " + tim.healthRemaining());        //  output: Initial health = 100;
        

        //  BENEFITS OF ENCAPSULATION
        //  #1: running code has no direct access to variables, and can't easily bypass validation checks;
        //  #2: refactoring doesn't affect running code; encapsulated classes are a black box;
        
    }

}
