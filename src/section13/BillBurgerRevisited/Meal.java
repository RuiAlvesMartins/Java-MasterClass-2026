package section13.BillBurgerRevisited;

public class Meal {
    
    private class Item {

        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            //  this will set price to base price for burger item types, and 0$ otherwise;
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        private static double getPrice(double price, double rate) {
            return price * rate;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name, getPrice(price, conversionRate));
        }

    }

    private Item burger;
    private Item drink;
    private Item side;
    private double price = 5.0;
    private double conversionRate;

    public Meal() {
        this(1.0);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        this.burger = new Item("regular", "burger");
        this.drink = new Item("coke", "drink", 1.5);
        this.side = new Item("fries", "side", 2.0);
        // System.out.println(this.toString());
    }

    public double getTotal() {
        double total = burger.price + drink.price + side.price;
        //  although we are inside the outer class;
        //  we access the static method inside inner class by calling the inner class name;
        return Item.getPrice(total, conversionRate);
    }

    @Override
    public String toString() {
        return "Meal: %n%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side, "Total due: ", getTotal());
    }

}
