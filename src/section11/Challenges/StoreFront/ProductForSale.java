package section11.Challenges.StoreFront;

public abstract class ProductForSale {

    private ProductType type;
    private double price;
    private String description;

    //  behaviour

    protected ProductForSale(ProductType type, double price, String description) {
        Boolean validPrice = priceValidation(price);
        if (validPrice) {
            this.type = type;
            this.price = price;
            this.description = description;
        }
    }

    public ProductType getType() {
        return type;
    };

    public double getPrice() {
        return price; 
    };

    public String getDescription() {
        return description;
    };

    //  price control
    protected static boolean priceValidation(double price) {
        if (price <= 0) {
            return false;
        }
        return true;
    }

    public abstract void showDetails();

}
