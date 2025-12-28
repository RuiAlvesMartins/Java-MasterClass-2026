package section13.Challenges.BillBurgerRevisited;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    
    private class Item {

        private String name;
        private String type;
        private double price;

        // public Item(String name, String type) {
        //     //  this will set price to base price for burger item types, and 0$ otherwise;
        //     this(name, type, type.equals("burger") ? Meal.this.price : 0);
        // }

        //  Package Private
        Item(String name, String type, double price) {
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

    private class Burger extends Item {

        private enum Toppings {AVOCADO, BACON, CHEESE, KETCHUP, MAYO, MUSTARD, PICKLES;
            private double getPrice() {
                return switch (this) {
                    case AVOCADO -> 1.00;
                    case BACON, CHEESE -> 1.50;
                    default -> 0;
                };
            }
        }

        private List<Item> toppings;

        //  Package Private
        Burger(String name, double price) {
            super(name, "burger", price);
            this.toppings = new ArrayList<>();
        }

        //  Package Private
        Burger(String name) {
            this(name, Meal.this.price);
        }

        //  we need this getter 
        public double getPrice() {
            return super.price;
        }

        // private void addTopping(Item topping) {
        //     if (topping.type.equals("topping")) {
        //         toppings.add(topping);
        //     }
        // }

        private void addToppings(String... toppingsToAdd) {
            for (String t : toppingsToAdd) {
                try {
                    Toppings topping = Toppings.valueOf(t.toUpperCase());
                    toppings.add(new Item(topping.name().toLowerCase(), "topping", topping.getPrice()));
                } catch (IllegalArgumentException ia) {
                    System.out.println("Topping " + t + " not found!");
                }
            }
        }

        @Override
        public String toString() {
            String stringBurger = super.toString();
            for (Item topping : toppings) {
                stringBurger += "%n%s".formatted(topping.toString());
            }
            return stringBurger;
        }

    }

    // //  Package Private
    // class Topping extends Item {
    //     //  Package Private
    //     Topping(String name, double price) {
    //         super(name, "topping", price);
    //     }
    //     //  Package Private
    //     Topping(String name) {
    //         super(name, "topping", 0);
    //     }
    // }



    private Burger burger;
    private Item drink;
    private Item side;
    private double price = 5.0;
    private double conversionRate;

    public Meal() {
        this(1.0);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        this.burger = new Burger("regular");
        this.drink = new Item("coke", "drink", 1.5);
        this.side = new Item("fries", "side", 2.0);
        // System.out.println(this.toString());
    }

    public double getTotal() {
        double total = burger.getPrice() + drink.price + side.price;
        for (Item topping : burger.toppings) {
            total += topping.price;
        }
        //  although we are inside the outer class;
        //  we access the static method inside inner class by calling the inner class name;
        return Item.getPrice(total, conversionRate);
    }

    // public void addToppings(Topping... items) {
    //     for (Item i : items) {
    //         if (i.type.equals("topping")) {
    //             burger.toppings.add(i);
    //         }
    //     }
    // }

    public void addToppings(String... toppings) {
        burger.addToppings(toppings);
    }

    // public Topping newTopping(String name, double price) {
    //     return this.new Topping(name, price);
    // }

    // public Topping newTopping(String name) {
    //     return this.new Topping(name, 0);
    // }

    @Override
    public String toString() {
        return "Meal: %n%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side, "Total due: ", getTotal());
    }

}
