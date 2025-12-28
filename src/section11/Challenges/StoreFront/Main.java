package section11.Challenges.StoreFront;

public class Main {
    
    public static void main(String[] args) {
        
        //  testing factory method price validation
        Poultry poultry = Poultry.newPoultry(PoultryType.CHICKEN, -10, "Rooster");
        // poultry.showDetails();                                                                   //  NPE as expected

        //  testing constructor price validation
        poultry = new Poultry(-100, "Rooster", PoultryType.CHICKEN);
        poultry.showDetails();                                                                      //  Price 100 as expected

        //  testing edge case 0
        poultry = new Poultry(0, "Park Goose", PoultryType.GOOSE);
        poultry.showDetails();                                                                      //  Price 100 as expected




        

        ProductForSale chicken = Poultry.newPoultry(PoultryType.CHICKEN, 5, "Chicken");
        ProductForSale duck = Poultry.newPoultry(PoultryType.DUCK, 6, "Duck");
        ProductForSale goose = Poultry.newPoultry(PoultryType.GOOSE, 12, "Goose");

        ProductForSale onion = Vegetables.newVegetable(VegetableType.ONION, 0.40, "Onion");
        ProductForSale carrot = Vegetables.newVegetable(VegetableType.CARROT, 0.35, "Carrot");
        ProductForSale potato = Vegetables.newVegetable(VegetableType.POTATO, 0.25, "Potato");
        ProductForSale cabbage = Vegetables.newVegetable(VegetableType.CABBAGE, 0.75, "Cabbage");
        ProductForSale beet = Vegetables.newVegetable(VegetableType.BEET, 0.50, "Beet");
        ProductForSale turnip = Vegetables.newVegetable(VegetableType.TURNIP, 0.40, "Turnip");

        ProductForSale apple = Fruits.newFruit(FruitType.APPLE, 0.20, null);
        ProductForSale orange = Fruits.newFruit(FruitType.ORANGE, 0.40, null);
        ProductForSale peach = Fruits.newFruit(FruitType.PEACH, 0.30, null);
        ProductForSale strawberry = Fruits.newFruit(FruitType.STRAWBERRY, 0.60, null);
        ProductForSale banana = Fruits.newFruit(FruitType.BANANA, 0.50, null);
        ProductForSale cherry = Fruits.newFruit(FruitType.CHERRY, 0.25, null);

        Store store = new Store();
        store.getProductsForSale().add(chicken);
        store.getProductsForSale().add(duck);
        store.getProductsForSale().add(goose);

        store.getProductsForSale().add(onion);
        store.getProductsForSale().add(carrot);
        store.getProductsForSale().add(potato);
        store.getProductsForSale().add(cabbage);
        store.getProductsForSale().add(beet);
        store.getProductsForSale().add(turnip);

        store.getProductsForSale().add(apple);
        store.getProductsForSale().add(orange);
        store.getProductsForSale().add(peach);
        store.getProductsForSale().add(strawberry);
        store.getProductsForSale().add(banana);
        store.getProductsForSale().add(cherry);

        //  todo fix factory methods

        Order order = new Order();
        order.addItem(new OrderItem(1, chicken));
        System.out.println(order.findItem(chicken));
        order.removeItem(chicken);
        System.out.println(order.findItem(chicken));

        order.addItem(new OrderItem(1, duck));
        order.addItem(new OrderItem(3, onion));
        order.addItem(new OrderItem(2, apple));
        order.printOrder();


    }

}
