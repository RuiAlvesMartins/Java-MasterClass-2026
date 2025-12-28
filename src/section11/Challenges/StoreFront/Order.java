package section11.Challenges.StoreFront;

import java.util.ArrayList;

public class Order {

    private static int idInitializer = 123_456_789;
    private int orderId;
    private ArrayList<OrderItem> items;
    private double orderTotal;

    public static Order newOrder() {
        return new Order();
    }

    public Order() {
        this.orderId = idInitializer + 1;
        idInitializer++;
        this.items = new ArrayList<>();
        this.orderTotal = 0;
    }

    public int getOrderId() {
        return orderId;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public boolean addItem(OrderItem key) {
        if (this.findItem(key.getProductItem()) != null) {
            //  item already on the order
            return false;
        }
        this.items.add(key);
        return true;
    }

    public boolean removeItem(ProductForSale keyProduct) {
        OrderItem item = this.findItem(keyProduct);
        if (item == null) {
            //  item not found
            return false;
        }
        items.remove(item);
        return true;
    }

    public boolean changeQuantity(ProductForSale keyProduct, int newQuantity) {
        OrderItem item = this.findItem(keyProduct);
        if (item == null) {
            //  item not found
            return false;
        }
        if (newQuantity < 0) {
            //  invalid quantity
            return false;
        }
        if (newQuantity == 0) {
            //  remove item from order
            items.remove(item);
            return true;
        }
        item.setQuantity(newQuantity);
        return true;
    }

    protected OrderItem findItem(ProductForSale keyProduct) {
        ProductForSale itemProduct;
        for (OrderItem item : items) {
            itemProduct = item.getProductItem();
            if (itemProduct.getType().equals(keyProduct.getType())) {
                switch (keyProduct.getType()) {
                    case POULTRY:
                        Poultry itemPoultry = (Poultry) itemProduct;
                        Poultry keyPoultry = (Poultry) keyProduct;
                        if (itemPoultry.getPoultryType().equals(keyPoultry.getPoultryType())) {
                            //  found it
                            return item;
                        }
                        break;

                    case VEGETABLES:
                        Vegetables itemVegetables = (Vegetables) itemProduct;
                        Vegetables keyVegetables = (Vegetables) keyProduct;
                        if (itemVegetables.getVegetableType().equals(keyVegetables.getVegetableType())) {
                            //  found it
                            return item;
                        }
                        break;

                    case FRUITS:
                        Fruits itemFruits = (Fruits) itemProduct;
                        Fruits keyFruits = (Fruits) keyProduct;
                        if (itemFruits.getFruitType().equals(keyFruits.getFruitType())) {
                            //  found it
                            return item;
                        }
                        break;
                
                    default:
                        break;
                }
            }
        }
        //  not found
        return null;

    }
    
    //  calculate orderTotal
    private void calculateOrderTotal() {
        orderTotal = 0;
        for (OrderItem item : items) {
            orderTotal += item.getSalePrice();
        }
    }

    //  print order
    public void printOrder() {
        System.out.println();
        System.out.printf("%-12s %-12s %-4s %-8s %s%n", "Type", "Product", "Qty", "Price", "Total");
        for (OrderItem item : items) {
            item.printPricedItem();
        }
        calculateOrderTotal();
        System.out.println();
        System.out.printf("Order total: %s %.2f$", "-".repeat(26), orderTotal);
        System.out.println();
    }

}
