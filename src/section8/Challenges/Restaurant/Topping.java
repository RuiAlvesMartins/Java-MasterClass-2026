package section8.Challenges.Restaurant;

public class Topping {

    private String type;
    private double price;

    protected Topping(String type, double price) {
        this.type = type;
        // validation for price;
        this.price = price <= 0 ? 1D : price;
    }

    public static Topping getTopping(String type, double price) {

        return new Topping(type, price);

    }

    protected void setPrice(double price) {
        this.price = price <= 0 ? 1D : price;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Topping [type=" + type + ", price=" + price + "]";
    }

}
