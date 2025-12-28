package section11.Challenges.StoreFront;

public class OrderItem {

    private int quantity;
    private ProductForSale productItem;
    
    protected OrderItem newOrderItem(int quantity, ProductForSale productItem) {
        return new OrderItem(quantity, productItem);
    }

    public OrderItem(int quantity, ProductForSale productItem) {
        this.quantity = quantity;
        this.productItem = productItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductForSale getProductItem() {
        return productItem;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //  .getSalesPrice()    //  takes quantity, returns quantity * price
    public double getSalePrice() {
        return productItem.getPrice() * quantity;
    }

    //  .printPricedItem()  //  takes qty, print itemized line item (qty & line item price)
    public void printPricedItem() {
        String subType = "";
        switch (productItem.getType()) {
            case POULTRY:
                Poultry poultryItem = (Poultry) productItem;
                subType = String.format("%s", poultryItem.getPoultryType());
                break;
            case VEGETABLES:
                Vegetables vegetableItem = (Vegetables) productItem;
                subType = String.format("%s", vegetableItem.getVegetableType());
                break;
            case FRUITS:
                Fruits fruitItem = (Fruits) productItem;
                subType = String.format("%s", fruitItem.getFruitType());
                break;
            default:
                break;
        }
        String lineString = String.format("%-12s %-12s %2d * %.2f$    %.2f$", productItem.getType(), subType, quantity, productItem.getPrice(), this.getSalePrice());
        System.out.println(lineString);
    }
    
}
