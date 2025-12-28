package section8.Challenges.SmartKitchen;
public class SmartKitchen {

    private CoffeeMaker brewMaster;
    private DishWasher dishWasher;
    private Refrigerator iceBox;

    //  constructor
    public SmartKitchen() {
        this.brewMaster = new CoffeeMaker();
        this.dishWasher = new DishWasher();
        this.iceBox = new Refrigerator();
    }

    public void addWater() {
        this.brewMaster.brewCoffee();
    } 

    public void pourMilk() {
        this.iceBox.orderFood();
    }

    public void loadDishwasher() {
        this.dishWasher.doDishes();
    }

    public void setKitchenState(boolean brewMasterHasWorkToDo, boolean dishWasherHasWorkToDo, boolean iceBoxHasWorkToDo) {
        if (this.brewMaster.getHasWorkToDo() != brewMasterHasWorkToDo) {this.brewMaster.brewCoffee();}
        if (this.iceBox.getHasWorkToDo() != iceBoxHasWorkToDo) {this.iceBox.orderFood();}
        if (this.dishWasher.getHasWorkToDo() != dishWasherHasWorkToDo) {this.dishWasher.doDishes();}      
    }

    public void doKitchenWork() {
        addWater();
        pourMilk();
        loadDishwasher();
    }

    public CoffeeMaker getBrewMaster() {
        return brewMaster;
    }

    public DishWasher getDishWasher() {
        return dishWasher;
    }

    public Refrigerator getIceBox() {
        return iceBox;
    }

    

}
