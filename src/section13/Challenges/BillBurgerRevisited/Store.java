package section13.Challenges.BillBurgerRevisited;

public class Store {

    public static void main(String[] args) {
        
        Meal meal = new Meal();
        // System.out.println(meal.getTotal());

        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);

        meal.addToppings("ketchup", "mayo", "pickles", "cheese", "bacon", "baloney");

        System.out.println(meal);

    }

}
