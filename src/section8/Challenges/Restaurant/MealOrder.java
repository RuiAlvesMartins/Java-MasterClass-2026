package section8.Challenges.Restaurant;

import java.util.Objects;

public class MealOrder {

    private Hamburger hamburger;
    private Drink drink;
    private SideItem sideItem;
    private double orderTotal;



    protected MealOrder(Hamburger hamburger, Drink drink, SideItem sideItem) {
        this.hamburger = hamburger;
        this.drink = drink;
        this.sideItem = sideItem;
        this.orderTotal = hamburger.getPrice() + drink.getPrice() + sideItem.getPrice();
    }

    public static MealOrder getOrder(Hamburger hamburger, Drink drink, SideItem sideItem) {

        return new MealOrder(hamburger, drink, sideItem);

    }
    
    public static MealOrder getOrder() {

        return new MealOrder(Hamburger.getHamburger(), Drink.getDrink(), SideItem.getSideItem());

    }

    //  add toppings
    public void addTopping(Topping topping) {
        //  testing if burger is deluxe;
        //  deluxe burger can have 5 toppings instead of 3;
        //  .equals() is used because '==' cannot be used for comparing Strings!
        boolean isDeluxe = false;
        if (this.hamburger.getClass().getSimpleName().equals("HamburgerDeluxe")) {
            isDeluxe = true;
        }

        if (Objects.isNull(this.hamburger.getToppingOne())) {
            this.hamburger.setToppingOne(topping);
            if (!isDeluxe) {
                //  this adds the cost of the Topping to the orderTotal if burger IS NOT deluxe;
                this.orderTotal+=topping.getPrice();    
            }
            return;
        }
        if (Objects.isNull(this.hamburger.getToppingTwo())) {
            this.hamburger.setToppingTwo(topping);
            if (!isDeluxe) {
                this.orderTotal+=topping.getPrice();    
            }
            return;
        }
        if (Objects.isNull(this.hamburger.getToppingThree())) {
            this.hamburger.setToppingThree(topping);
            if (!isDeluxe) {
                this.orderTotal+=topping.getPrice();    
            }
            return;
        }

        if (isDeluxe) {
            //  new reference 'deluxeBurger' points to the same object in memory;
            //  it is created so that getToppingFour() and getToppingFive() can be called;
            HamburgerDeluxe deluxeBurger = (HamburgerDeluxe) this.hamburger;
            if (Objects.isNull(deluxeBurger.getToppingFour())) {
                deluxeBurger.setToppingFour(topping);
                //  this line is not necessary, as both refferences point to same object;
                // this.hamburger = deluxeBurger;
                //  because deluxe topings are not charged, orderTotal doesn't need to be actualized;
                return;
            }
            if (Objects.isNull(deluxeBurger.getToppingFive())) {
                deluxeBurger.setToppingFive(topping);
                // this.hamburger = deluxeBurger;
                return;
            }
        }
        System.out.println("Cannot add more toppings!");
    }

    //  change drink size
    public void changeSizeDrink(String size) {
        this.drink.setSize(size);
        //  checks if burger is deluxe, as it is not charged extra for toppings
        if (this.hamburger.getClass().getSimpleName().equals("HamburgerDeluxe")) {
            //  this will actualize the orderTotal;
            this.orderTotal = hamburger.getPrice() + drink.getPrice() + sideItem.getPrice();
            return;
        } else {
            this.orderTotal = hamburger.getPrice() + drink.getPrice() + sideItem.getPrice();
            if (this.hamburger.getToppingOne() != null) {this.orderTotal+=this.hamburger.getToppingOne().getPrice();}
            if (this.hamburger.getToppingTwo() != null) {this.orderTotal+=this.hamburger.getToppingTwo().getPrice();}
            if (this.hamburger.getToppingThree() != null) {this.orderTotal+=this.hamburger.getToppingThree().getPrice();}
        }

    }

    //  change sideItem size
    public void changeSizeSideItem(String size) {
        this.sideItem.setSize(size);
        //  checks if burger is deluxe, as it is not charged extra for toppings
        if (this.hamburger.getClass().getSimpleName().equals("HamburgerDeluxe")) {
            //  this will actualize the orderTotal;
            this.orderTotal = hamburger.getPrice() + drink.getPrice() + sideItem.getPrice();
            return;
        } else {
            this.orderTotal = hamburger.getPrice() + drink.getPrice() + sideItem.getPrice();
            if (this.hamburger.getToppingOne() != null) {this.orderTotal+=this.hamburger.getToppingOne().getPrice();}
            if (this.hamburger.getToppingTwo() != null) {this.orderTotal+=this.hamburger.getToppingTwo().getPrice();}
            if (this.hamburger.getToppingThree() != null) {this.orderTotal+=this.hamburger.getToppingThree().getPrice();}            
        }
    }

    //  print itemized list
    public void printItemList() {
        System.out.println(this.hamburger.getType() + " -> " + this.hamburger.getPrice() + "$");
        //  testing if IS NOT deluxe;
        if (!this.hamburger.getClass().getSimpleName().equals("HamburgerDeluxe")) {
            if (this.hamburger.getToppingOne() != null) {
                System.out.println(this.hamburger.getToppingOne().getType() + " -> " + this.hamburger.getToppingOne().getPrice() + "$");
            }
            if (this.hamburger.getToppingTwo() != null) {
                System.out.println(this.hamburger.getToppingTwo().getType() + " -> " + this.hamburger.getToppingTwo().getPrice() + "$");
            }
            if (this.hamburger.getToppingThree() != null) {
                System.out.println(this.hamburger.getToppingThree().getType() + " -> " + this.hamburger.getToppingThree().getPrice() + "$");
            }
        }
        //  testing if IS deluxe;
        if (this.hamburger.getClass().getSimpleName().equals("HamburgerDeluxe")) {
            if (this.hamburger.getToppingOne() != null) {
                System.out.println(this.hamburger.getToppingOne().getType() + " -> 0.00$");
            }
            if (this.hamburger.getToppingTwo() != null) {
                System.out.println(this.hamburger.getToppingTwo().getType() + " -> 0.00$");
            }
            if (this.hamburger.getToppingThree() != null) {
                System.out.println(this.hamburger.getToppingThree().getType() + " -> 0.00$");
            }
            if (((HamburgerDeluxe) this.hamburger).getToppingFour() != null) {
                System.out.println(((HamburgerDeluxe) this.hamburger).getToppingFour().getType() + " -> 0.00$");
            }
            if (((HamburgerDeluxe) this.hamburger).getToppingFive() != null) {
                System.out.println(((HamburgerDeluxe) this.hamburger).getToppingFive().getType() + " -> 0.00$");
            }
        }

        System.out.println(this.drink.getType() + " " + this.drink.getSize().toUpperCase() + " -> " + this.drink.getPrice() + "$");
        System.out.println(this.sideItem.getType() + " " + this.sideItem.getSize().toUpperCase() + " -> " + this.sideItem.getPrice() + "$");

        printOrderTotal();

        System.out.println("_".repeat(36));

    }

    //  print total due amount
    public void printOrderTotal() {
        System.out.println("Order Total : " + orderTotal + "$");
    }

    //  todo delete these getters?
    public Hamburger getHamburger() {
        return hamburger;
    }

    public Drink getDrink() {
        return drink;
    }

    public SideItem getSideItem() {
        return sideItem;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

}
