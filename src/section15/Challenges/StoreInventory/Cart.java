package section15.Challenges.StoreInventory;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

enum StoreType {PHYSICAL, ONLINE}

public class Cart implements Comparable<Cart> {

    // id
    // products         (collection of products)
    // date             LocalDate.now() + offset
    // type             (physical or online; Enum)

    private static int idInit = 999_999_999;
    private int id;
    //  hash, linked or tree?????
    //  Map<sku, qty>
    private Map<Integer, Integer> products;
    private LocalDate date;
    private StoreType cartType;

    public Cart(StoreType cartType, int dayOffset) {
        this.id = idInit++;
        this.products = new HashMap<>();
        this.cartType = cartType;
        this.date = dayOffset > 0 ? LocalDate.now().plusDays(Math.abs(dayOffset)) : 
                    dayOffset < 0 ? LocalDate.now().minusDays(Math.abs(dayOffset)) : 
                    LocalDate.now();
    }

    public Cart(StoreType cartType) {
        this(cartType, 0);
    }
    
    public int getId() {
        return id;
    }

    public Map<Integer, Integer> getProducts() {
        return products;
    }

    public LocalDate getDate() {
        return date;
    }

    //addItem      (customer adds item to cart)
    public boolean addItem(InventoryItem item, int qtyOrder) {
        //assume InventoryItem is present in store inventory;
        if (qtyOrder < 1) {return false;}
        if (item.reserveItem(qtyOrder)) {
            //  Map<sku, qty>
            //todo: I don't know how to use the function on Map.merge()
            // products.merge(item.getProduct().getSku(), qtyOrder, Integer::sum);
            if (products.keySet().contains(item.getProduct().getSku())) {
                int qtyValue = products.get(item.getProduct().getSku());
                qtyValue+=qtyOrder;
                products.put(item.getProduct().getSku(), qtyValue);
            } else {
                products.put(item.getProduct().getSku(), qtyOrder);
            }

            return true;
        }

        return false;
    }

    //removeItem   (customer removes item from cart)
    public boolean removeItem(InventoryItem item) {
        //assume InventoryItem is present in store inventory;
        int sku = item.getProduct().getSku();
        if (products.keySet().contains(sku)) {
            item.releaseItem(products.get(sku));
            products.remove(sku);
            return true;
        }

        return false;
    }

    //printSalesSlip   
    public void printSalesSlip(Map<Integer, InventoryItem> inventory) {
        System.out.println("-".repeat(50));
        System.out.println("Transaction ID %35s".formatted(id));
        System.out.println("%50s".formatted(date));
        System.out.println();
        System.out.println("%-12s %-12s %9s %4s %9s".formatted(
            "Category",
            "Product",
            "Price",
            "Qty",
            "Total"
        ));
        System.out.println("_".repeat(50));

        double total = 0;
        for (var prod : products.entrySet()) {
            var item = inventory.get(prod.getKey());
            int qtyProd = prod.getValue();
            double itemPrice = (item.getSalesPrice() * qtyProd);
            total+=itemPrice;
            System.out.println("%-12s %-12s %8.2f$ %3d# %8.2f$".formatted(
                item.getProduct().getCategory(),
                item.getProduct().getName(),
                item.getSalesPrice(),
                qtyProd,
                itemPrice
            ));
        }

        System.out.println("_".repeat(50));
        System.out.println("%36s %12.2f$".formatted("TOTAL:", total));
        System.out.println();
        System.out.println("%s Thank you for your purchase! %s".formatted("-".repeat(10), "-".repeat(10)));
        System.out.println();

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int compareTo(Cart o) {
        int d = this.date.compareTo(o.date);
        if (d != 0) {
            return d;
        }
        return Integer.compare(this.id, o.id);
    }

    

}

