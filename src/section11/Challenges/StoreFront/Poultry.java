package section11.Challenges.StoreFront;

enum PoultryType {
    CHICKEN, DUCK, GOOSE
}

public class Poultry extends ProductForSale {

    PoultryType poultryType;

    public static Poultry newPoultry(PoultryType type, double price, String description) {
        Boolean validPrice = ProductForSale.priceValidation(price);
        if (validPrice) {
            return new Poultry(price, description, type);
        } else {
            return null;
        }
            
    }

    protected Poultry(double price, String description, PoultryType type) {    
        super(ProductType.POULTRY, price > 0 ? price : 100, description);
        this.poultryType = type;
    }

    public PoultryType getPoultryType() {
        return poultryType;
    }

    @Override
    public void showDetails() {
        String details = String.format("%s %.2f$ %s %s%n", this.getType(), this.getPrice(), poultryType, this.getDescription());
        System.out.println(details);
    }

}
