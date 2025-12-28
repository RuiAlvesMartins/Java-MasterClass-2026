package section8.Challenges.Restaurant;

public class Hamburger {

    private String type;
    private double price;
    private Topping toppingOne;
    private Topping toppingTwo;
    private Topping toppingThree;

    //  constructor
    protected Hamburger(String type, double price) {
        this.type = type;
        // validation for price;
        this.price = price <= 0 ? 1D : price;
    }

    //  factory
    public static Hamburger getHamburger(String type, double price, boolean isDeluxe) {

        return isDeluxe ? new HamburgerDeluxe(type, price) : new Hamburger(type, price);

    }

    //  factory (isDeluxe == false)
    public static Hamburger getHamburger(String type, double price) {

        return getHamburger(type, price, false);

    }

    //  factory (no args)
    public static Hamburger getHamburger() {

        return getHamburger("Classic Burger", 5.00D, false);

    }

    protected void setPrice(double price) {
        this.price = price <= 0 ? 1D : price;
    }

    protected void setToppingOne(Topping toppingOne) {
        this.toppingOne = toppingOne;
    }

    protected void setToppingTwo(Topping toppingTwo) {
        this.toppingTwo = toppingTwo;
    }

    protected void setToppingThree(Topping toppingThree) {
        this.toppingThree = toppingThree;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public Topping getToppingOne() {
        return toppingOne;
    }

    public Topping getToppingTwo() {
        return toppingTwo;
    }

    public Topping getToppingThree() {
        return toppingThree;
    }

    @Override
    public String toString() {
        return "Hamburger [type=" + type + ", price=" + price + ", toppingOne=" + toppingOne + ", toppingTwo="
                + toppingTwo + ", toppingThree=" + toppingThree + "]";
    }

}
