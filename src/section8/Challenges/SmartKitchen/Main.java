package section8.Challenges.SmartKitchen;
public class Main {

    public static void main(String[] args) {
        
        SmartKitchen smartKitchen = new SmartKitchen();

        // smartKitchen.getDishWasher().setHasWorkToDo(true);
        // smartKitchen.getIceBox().setHasWorkToDo(true);
        // smartKitchen.getBrewMaster().setHasWorkToDo(true);

        // smartKitchen.getDishWasher().doDishes();
        // smartKitchen.getIceBox().orderFood();
        // smartKitchen.getBrewMaster().brewCoffee();

        smartKitchen.setKitchenState(true, true, true);
        smartKitchen.addWater();
        smartKitchen.pourMilk();
        smartKitchen.loadDishwasher();
        smartKitchen.doKitchenWork();

    }

}
