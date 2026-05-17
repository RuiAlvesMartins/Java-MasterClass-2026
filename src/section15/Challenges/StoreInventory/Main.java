package section15.Challenges.StoreInventory;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    
    //  Challenge: can you implement the conceptual model shown on the video?

    //  When choosing the data structure for a variable, consider:
    //          can you allow DUPLICATES?
    //          do you need elements to be SORTED?
    //          is INSERTION order good enough?
    //          would it be easier to handle data in KEY-VALUE pairs?

    //  What methods on Collections classes might be useful?
    //          Set math?
    //          Navigational methods?
    //          Collections.java?

    public static void main(String[] args) {
        
        Product pMilk = new Product("Milk", "EvilBigCorp", Category.DAIRY);
        Product pEggs = new Product("Eggs", "EvilBigCorp", Category.DAIRY);
        Product pCarrots = new Product("Carrots", "FarmerJoe", Category.VEGETABLES);
        Product pOnions = new Product("Onions", "FarmerJoe", Category.VEGETABLES);
        System.out.println(pMilk);
        System.out.println(pEggs);
        System.out.println(pCarrots);
        System.out.println(pOnions);

        System.out.println("_".repeat(90));
        InventoryItem iMilk = new InventoryItem(pMilk, 0.8, 80, 40);
        InventoryItem iEggs = new InventoryItem(pEggs, 2.5, 30, 10);
        InventoryItem iCarrots = new InventoryItem(pCarrots, 0.25, 100, 40);
        InventoryItem iOnions = new InventoryItem(pOnions, 0.3, 100, 40);
        System.out.println(iMilk);
        System.out.println(iEggs);
        System.out.println(iCarrots);
        System.out.println(iOnions);

        iMilk.placeInventoryOrder();
        iMilk.placeInventoryOrder();
        iMilk.reserveItem(81);
        iMilk.reserveItem(80);
        iMilk.reserveItem(1);
        iMilk.placeInventoryOrder();
        iMilk.sellItem(40);
        iMilk.releaseItem(40);
        iMilk.reserveItem(20);
        iMilk.placeInventoryOrder();
        iMilk.placeInventoryOrder();
        iMilk.sellItem(21);
        iMilk.sellItem(20);

        System.out.println(LocalDate.now());

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);

        char c = Category.DAIRY.toString().charAt(0);
        c = 'Z';
        int i = (int) c;
        System.out.println(c + " = " + i);
        System.out.println(i * 10_000_000 + i * 100_000 + i * 100);



        System.out.println();
        System.out.println("_".repeat(120));
        System.out.println("_".repeat(120));
        System.out.println("_".repeat(120));
        System.out.println();

        Store lidl = new Store();
        lidl.getInventory().put(iMilk.getProduct().getSku(), iMilk);
        lidl.getInventory().put(iEggs.getProduct().getSku(), iEggs);
        lidl.getInventory().put(iCarrots.getProduct().getSku(), iCarrots);
        lidl.getInventory().put(iOnions.getProduct().getSku(), iOnions);

        lidl.listProductsByCategory(Category.VEGETABLES, Category.DAIRY);
        iMilk.placeInventoryOrder();
        iEggs.placeInventoryOrder();
        iCarrots.placeInventoryOrder();
        iOnions.placeInventoryOrder();
        lidl.listProductsByCategory(Category.VEGETABLES, Category.DAIRY);

        Cart c1 = new Cart(StoreType.PHYSICAL);
        lidl.getCarts().add(c1);

        c1.addItem(iOnions, 20);
        c1.addItem(iCarrots, 20);
        c1.addItem(iEggs, 10);
        lidl.listProductsByCategory(Category.VEGETABLES, Category.DAIRY);
        c1.printSalesSlip(lidl.getInventory());

        c1.removeItem(iMilk);
        c1.removeItem(iEggs);
        c1.removeItem(iOnions);
        lidl.listProductsByCategory(Category.VEGETABLES, Category.DAIRY);
        c1.printSalesSlip(lidl.getInventory());

        c1.addItem(iMilk, 60);
        c1.addItem(iEggs, 30);
        lidl.listProductsByCategory(Category.VEGETABLES, Category.DAIRY);
        c1.printSalesSlip(lidl.getInventory());

        Cart c2 = new Cart(StoreType.PHYSICAL);
        lidl.getCarts().add(c2);

        c2.addItem(iMilk, 40);
        c2.addItem(iEggs, 10);
        c2.addItem(iOnions, 60);

        lidl.listProductsByCategory(Category.VEGETABLES, Category.DAIRY);
        c2.printSalesSlip(lidl.getInventory());

        c1.removeItem(iEggs);
        c2.addItem(iEggs, 10);

        System.out.println("Carts in store: " + lidl.getCarts().size());
        lidl.getCarts().forEach(cart -> System.out.println(cart.getDate()));

        Cart c3 = new Cart(StoreType.PHYSICAL, -1);
        lidl.getCarts().add(c3);
        c3.addItem(iEggs, 10);
        Cart c4 = new Cart(StoreType.PHYSICAL, 1);
        lidl.getCarts().add(c4);
        c4.addItem(iCarrots, 40);
        c3.printSalesSlip(lidl.getInventory());
        c4.printSalesSlip(lidl.getInventory());
        System.out.println("Carts in store: " + lidl.getCarts().size());
        lidl.getCarts().forEach(cart -> System.out.println(cart.getDate()));

        lidl.abandonCarts();
        System.out.println("Carts in store: " + lidl.getCarts().size());

        lidl.checkOutCart(c4);
        System.out.println("Carts in store: " + lidl.getCarts().size());
        lidl.checkOutCart(c2);
        System.out.println("Carts in store: " + lidl.getCarts().size());
        lidl.checkOutCart(c1);
        System.out.println("Carts in store: " + lidl.getCarts().size());




        


    }

}
