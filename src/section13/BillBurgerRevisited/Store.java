package section13.BillBurgerRevisited;

public class Store {

    public static void main(String[] args) {
        
        Meal meal = new Meal();
        System.out.println(meal);
        // System.out.println(meal.getTotal());

        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);


    }

}
