package section8.Challenges.Restaurant;

import java.util.Objects;

public class Main {
    
    //  melhorias: melhorar o printItemList();

    public static void main(String[] args) {
        
        Hamburger burgerBig = Hamburger.getHamburger("Big Burger", 6.50D);
        System.out.println(burgerBig);
        Hamburger classic = Hamburger.getHamburger();
        System.out.println(classic);
        Hamburger deluxe = Hamburger.getHamburger("Deluxe Burger", 9D, true);
        System.out.println(deluxe);

        Drink dietCoke = Drink.getDrink("Diet Coke", 1D);
        System.out.println(dietCoke);
        Drink classicCoke = Drink.getDrink();
        System.out.println(classicCoke);

        SideItem caesarSalad = SideItem.getSideItem("Caesar Salad", 2D);
        System.out.println(caesarSalad);
        SideItem classicFries =SideItem.getSideItem();
        System.out.println(classicFries);

        MealOrder firstOrder = MealOrder.getOrder();
        System.out.println(firstOrder);

        Topping extraCheese = Topping.getTopping("Extra Cheese", 1D);
        System.out.println(extraCheese);

        System.out.println("______________________________");
        firstOrder.addTopping(extraCheese);
        firstOrder.addTopping(extraCheese);
        firstOrder.addTopping(extraCheese);
        //  this will print: Cannot add more toppings!
        firstOrder.addTopping(extraCheese);
        System.out.println(firstOrder.getHamburger().getToppingOne());
        System.out.println(firstOrder.getHamburger().getToppingTwo());
        System.out.println(firstOrder.getHamburger().getToppingThree());
        // System.out.println(((HamburgerDeluxe) firstOrder.getHamburger()).getToppingFour());

        System.out.println("______________________________");
        MealOrder secondOrder = MealOrder.getOrder(deluxe, dietCoke, caesarSalad);
        secondOrder.addTopping(extraCheese);
        secondOrder.addTopping(extraCheese);
        secondOrder.addTopping(extraCheese);
        secondOrder.addTopping(extraCheese);
        secondOrder.addTopping(extraCheese);
        //  this will print: Cannot add more toppings!
        secondOrder.addTopping(extraCheese);
        System.out.println(secondOrder.getHamburger().getToppingOne());
        System.out.println(secondOrder.getHamburger().getToppingTwo());
        System.out.println(secondOrder.getHamburger().getToppingThree());
        System.out.println(((HamburgerDeluxe) secondOrder.getHamburger()).getToppingFour());
        System.out.println(((HamburgerDeluxe) secondOrder.getHamburger()).getToppingFive());

        // //  purpose of this test is to evaluate if casting creates a new object in memory;
        // //  it doesn't;
        // HamburgerDeluxe deluxe2 = (HamburgerDeluxe) deluxe;
        // System.out.println(deluxe);
        // System.out.println(deluxe2);
        // //  why this error? because 'deluxe' reference is of type Hamburger;
        // deluxe.getToppingFour();
        // //  'deluxe2' points to same object in memory, but it is of type HamburgerDeluxe: no error;
        // deluxe2.getToppingFour();

        System.out.println("______________________________");
        System.out.println(secondOrder.getDrink().toString());
        secondOrder.changeSizeDrink(null);
        System.out.println(secondOrder.getDrink().toString());
        secondOrder.changeSizeDrink("L");
        System.out.println(secondOrder.getDrink().toString());
        secondOrder.changeSizeDrink("XL");
        System.out.println(secondOrder.getDrink().toString());
        secondOrder.changeSizeDrink("s");
        System.out.println(secondOrder.getDrink().toString());
        secondOrder.changeSizeDrink("null");
        System.out.println(secondOrder.getDrink().toString());

        System.out.println("______________________________");
        System.out.println(secondOrder.getSideItem().toString());
        secondOrder.changeSizeSideItem(null);
        System.out.println(secondOrder.getSideItem().toString());
        secondOrder.changeSizeSideItem("l");
        System.out.println(secondOrder.getSideItem().toString());
        secondOrder.changeSizeSideItem("xl");
        System.out.println(secondOrder.getSideItem().toString());
        secondOrder.changeSizeSideItem("S");
        System.out.println(secondOrder.getSideItem().toString());
        secondOrder.changeSizeSideItem("null");
        System.out.println(secondOrder.getSideItem().toString());

        Topping extraBacon = Topping.getTopping("Extra Bacon", 1D);
        Topping extraKetchup = Topping.getTopping("Extra Ketchup", 0.50D);
        Topping extraMayo = Topping.getTopping("Extra Mayo", 0.50D);
        Topping extraOnion = Topping.getTopping("Extra Onion", 0.60D);
        Topping extraPickle = Topping.getTopping("Extra Pickle", 0.80D);
        Topping extraMeatPattie = Topping.getTopping("Extra Meat Pattie", 2D);

        System.out.println("_".repeat(36));
        System.out.println("_".repeat(36));
        System.out.println("_".repeat(36));
        // //  default meal no args
        // MealOrder thirdOrder = MealOrder.getOrder();
        // thirdOrder.printItemList();
        // thirdOrder.addTopping(extraCheese);
        // thirdOrder.printItemList();
        // thirdOrder.addTopping(extraKetchup);
        // thirdOrder.addTopping(extraMayo);
        // thirdOrder.addTopping(extraBacon);
        // thirdOrder.printItemList();
        // thirdOrder.changeSizeDrink("L");
        // thirdOrder.printItemList();
        // thirdOrder.changeSizeSideItem("s");
        // thirdOrder.printItemList();

        System.out.println("_".repeat(36));
        System.out.println("_".repeat(36));
        System.out.println("_".repeat(36));
        // //  normal burger
        // Hamburger cheeseBaconBurger = Hamburger.getHamburger("CheeseBacon Burger", 6.00);
        // Drink iceTea = Drink.getDrink("Ice Tea", 1.20);
        // SideItem soup = SideItem.getSideItem("Soup", 1.50);
        // MealOrder fourthOrder = MealOrder.getOrder(cheeseBaconBurger, iceTea, soup);
        // fourthOrder.printItemList();
        // fourthOrder.addTopping(extraCheese);
        // fourthOrder.printItemList();
        // fourthOrder.addTopping(extraBacon);
        // fourthOrder.addTopping(extraOnion);
        // fourthOrder.addTopping(extraPickle);
        // fourthOrder.printItemList();
        // fourthOrder.changeSizeDrink("s");
        // fourthOrder.printItemList();
        // fourthOrder.changeSizeSideItem("xl");
        // fourthOrder.printItemList();

        System.out.println("_".repeat(36));
        System.out.println("_".repeat(36));
        System.out.println("_".repeat(36));
        //  deluxe burger
        Hamburger heartAttacker = Hamburger.getHamburger("Heart Attacker", 10.00, true);
        Drink pepsi = Drink.getDrink("Pepsi", 0.90);
        SideItem cheddarFries = SideItem.getSideItem("Cheddar Fries", 2.50);
        MealOrder fifthOrder = MealOrder.getOrder(heartAttacker, pepsi, cheddarFries);
        fifthOrder.printItemList();
        fifthOrder.addTopping(extraMayo);
        fifthOrder.printItemList();
        //  toString() on HamburgerDeluxe.java overriding as intended;
        System.out.println(fifthOrder.getHamburger().toString());
        fifthOrder.addTopping(extraKetchup);
        fifthOrder.addTopping(extraOnion);
        fifthOrder.addTopping(extraPickle);
        fifthOrder.addTopping(extraMeatPattie);
        fifthOrder.addTopping(extraCheese);
        fifthOrder.printItemList();
        fifthOrder.changeSizeDrink("XL");
        fifthOrder.changeSizeSideItem("XL");
        fifthOrder.printItemList();
        fifthOrder.changeSizeSideItem("null");
        fifthOrder.printItemList();

    }

}
