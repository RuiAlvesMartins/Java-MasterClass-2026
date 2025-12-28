package section8.Challenges.Restaurant;

public class HamburgerDeluxe extends Hamburger {

    private Topping toppingFour;
    private Topping toppingFive;

    protected HamburgerDeluxe(String type, double basePrice) {
        super(type, basePrice);
    }

    protected void setToppingFour(Topping toppingFour) {
        this.toppingFour = toppingFour;
    }

    protected void setToppingFive(Topping toppingFive) {
        this.toppingFive = toppingFive;
    }

    public Topping getToppingFour() {
        return toppingFour;
    }

    public Topping getToppingFive() {
        return toppingFive;
    }

    @Override
    public String toString() {
        return super.toString() + "HamburgerDeluxe [toppingFour=" + toppingFour + ", toppingFive=" + toppingFive + "]";
    }

}
