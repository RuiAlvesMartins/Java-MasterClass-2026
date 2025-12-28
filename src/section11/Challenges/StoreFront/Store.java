package section11.Challenges.StoreFront;

import java.util.ArrayList;

public class Store {

    //  features
    //  list of products for sale
    private ArrayList<ProductForSale> productsForSale; 
    private ArrayList<Order> orders;
    //  manage order / list of OrderItem

    public Store() {
        this.productsForSale = new ArrayList<>();
        this.orders = new ArrayList<>();
    }
    
    public ArrayList<ProductForSale> getProductsForSale() {
        return productsForSale;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    protected boolean addOrder(Order keyOrder) {
        if (this.findOrder(keyOrder.getOrderId()) != null) {
            //  order already exists
            return false;
        }
        orders.add(keyOrder);
        return true;
    }

    protected Order findOrder(int keyId) {
        for (Order order : orders) {
            if (order.getOrderId() == keyId) {
                //  found it
                return order;
            }
        }   
        //  order not found     
        return null;
    }

}
