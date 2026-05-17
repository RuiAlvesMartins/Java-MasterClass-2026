package section15.Challenges.StoreInventory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Store {
    
    // inventory        (collection of InventoryItem)
    // carts            (collection of Cart)
    // aisleInventory   (collection of InventoryItem)
    //                  (part of Inventory displayed physically on store shelves)
    //                  (assume isles can be keyed by productCategory)

    //  Map<sku, InvItem>
    private NavigableMap<Integer, InventoryItem> inventory;
    private NavigableSet<Cart> carts;       //  should be sorted by date!
    private NavigableMap<Category, NavigableSet<InventoryItem>> aisleInventory;

    public Store() {
        this.inventory = new TreeMap<>();
        this.carts = new TreeSet<>();
        this.aisleInventory = new TreeMap<>();
    }


    
    

    public NavigableMap<Integer, InventoryItem> getInventory() {
        return inventory;
    }



    public NavigableSet<Cart> getCarts() {
        return carts;
    }


    //todo manageStoreCarts


    //checkOutCart
    public boolean checkOutCart(Cart cart) {
        //todo test
        Cart cartObj = carts.ceiling(cart);

        if (cartObj != null) {
            for (Integer sku : cartObj.getProducts().keySet()) {
                InventoryItem item = inventory.get(sku);
                item.sellItem(cartObj.getProducts().get(sku));
            }
            System.out.println("Checking out ID%s".formatted(cartObj.getId()));
            cartObj.printSalesSlip(inventory);
            carts.remove(cartObj);
            return true;
        }
        else {
            System.out.println("Could not checkout ID%s. Cart not found!".formatted(cart.getId()));
        }
        return false;
    }

    //abandonCarts     (if cartDate != currentDate -> abandon cart)
    public boolean abandonCarts() {
        boolean modified = false;

        //TODO: IMPORTANT - DO NOT REMOVE ITEMS FROM LIST WILST ITERATING THROUGH IT!
        //  why use an iterator?
        //  because we are going to be iterating over a collection, 
        //  wilst at the same time potentially removing elements from it;
        //  if we run a traditional for loop (or forEach), we may encounter ConcurrentModificationException!
        //  we cannot iterate through an indexed collection and remove elements from it at the same time!
        var cartIterator = carts.iterator();

        while (cartIterator.hasNext()) {
            Cart cart = cartIterator.next();

            if (!cart.getDate().equals(LocalDate.now())) {
                var prodIterator = cart.getProducts().entrySet().iterator();

                while (prodIterator.hasNext()) {
                    var prodEntry = prodIterator.next();
                    int sku = prodEntry.getKey();
                    int qty = prodEntry.getValue();

                    inventory.get(sku).releaseItem(qty);
                    prodIterator.remove();
                }

                cartIterator.remove();
                modified = true;

            }

        }

        return modified;
    }

    //listProductsByCategory
    public void listProductsByCategory(Category... categories) {

        var sortedCategories = new ArrayList<>(Arrays.asList(categories));
        Collections.sort(sortedCategories);

        String header = "%-12s %-11s  %-12s %-7s  %-12s %-6s %-6s"
            .formatted("Category", "SKU", "Product", "Price", "Supplier", "Stock", "Locked");

        System.out.println();
        System.out.println("-".repeat(75));
        System.out.println(header);
        System.out.println("-".repeat(75));

        for (Category category : sortedCategories) {

            String c = category.toString().toUpperCase();
            int c1 = ((int) c.charAt(0)) * 10_000_000;
            int c2 = ((int) c.charAt(1)) * 100_000;
            int c3 = ((int) c.charAt(2)) * 100;
            int rangeLow = c1+c2+c3;
            int rangeHigh = rangeLow + 100;

            var invCat = inventory.tailMap(rangeLow).headMap(rangeHigh);
            for (Integer sku : invCat.keySet()) {
                InventoryItem i = invCat.get(sku);
                System.out.println(i);
            }

        }

        System.out.println("-".repeat(75));
        System.out.println();

    }

}
