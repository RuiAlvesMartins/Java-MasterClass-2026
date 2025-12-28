package section8.Encapsulation;
public class Player {

    //  HOW TO NOT ENCAPSULATE A CLASS

    //  these fields are public, so that we can set them on psvm;
    public String fullName;
    // public String name;
    public int health;
    public String weapon;

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
