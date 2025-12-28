package section8.Encapsulation;

public class EnhancedPlayer {

    //  HOW TO PROPERLY ENCAPSULATE A CLASS

    //  (you are supposed to know how to refactor variables)
    //  (but VSC doesn't allow for it; Intelij does)

    //  fields are declared private (problem 1 and 2);
    private String name;
    private int health;
    private String weapon;

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        //  constructors implement validation code (problem 1);
        this.health = health <= 0 ? 1 : health > 100 ? 100 : health;
        this.weapon = weapon;
    }

    //  construtors instantiate objects with the correct initialization data (problem 3);
    public EnhancedPlayer(String name) {
        this(name, 100, "Sword");
    }

    //  use SETTERS sparingly, only if needed!
    //  use less restricted access modifiers only where needed!

    public void loseHealth(int damage) {
        health = health - damage;
        if (health <= 0) {
            System.out.println("PLayer knocked out of the game");
        }
    }

    public void restoreHealth(int extraHealth) {
        health = health + extraHealth;
        if (health > 100) {
            health = 100;
            System.out.println("Player's health restored to 100%");
        }
    }

    public int healthRemaining() {
        return health;
    }

}
