package section11.Challenges.StoreFront;

enum VegetableType {
    ONION, CARROT, POTATO, CABBAGE, BEET, TURNIP
}

public class Vegetables extends ProductForSale {

    VegetableType vegetableType;

    public static Vegetables newVegetable(VegetableType type, double price, String description) {
        Boolean validPrice = ProductForSale.priceValidation(price);
        if (validPrice) {
            return new Vegetables(price, description, type);
        } else {
            return null;
        }
            
    }
    
    protected Vegetables(double price, String description, VegetableType vegetableType) {
        super(ProductType.VEGETABLES, price > 0 ? price : 100, description);
        this.vegetableType = vegetableType;
    }

    public VegetableType getVegetableType() {
        return vegetableType;
    }

    @Override
    public void showDetails() {
        String details = String.format("%s %.2f$ %s %s%n", this.getType(), this.getPrice(), vegetableType, this.getDescription());
        System.out.println(details);
    }

}
