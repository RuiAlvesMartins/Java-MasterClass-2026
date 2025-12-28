package section11.Challenges.StoreFront;

enum FruitType {
    STRAWBERRY, APPLE, ORANGE, BANANA, PEACH, CHERRY
}

public class Fruits extends ProductForSale {

    FruitType fruitType;

    public static Fruits newFruit(FruitType type, double price, String description) {
        Boolean validPrice = ProductForSale.priceValidation(price);
        if (validPrice) {
            return new Fruits(price, description, type);
        } else {
            return null;
        }
            
    }
    
    protected Fruits(double price, String description, FruitType fruitType) {
        super(ProductType.FRUITS, price > 0 ? price : 100, description);
        this.fruitType = fruitType;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    @Override
    public void showDetails() {
        String details = String.format("%s %.2f$ %s %s%n", this.getType(), this.getPrice(), fruitType, this.getDescription());
        System.out.println(details);
    }

}
