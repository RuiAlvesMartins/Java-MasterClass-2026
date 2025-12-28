package section8.Challenges.SmartKitchen;
public class CoffeeMaker {

    private boolean hasWorkToDo;

    public void brewCoffee() {
        if (hasWorkToDo) {
            System.out.println("Coffee maker is still working!");
            hasWorkToDo = false;
            return;
        }
        System.out.println("Coffee maker starts brewing coffee!");
        hasWorkToDo = true;
    }

    public boolean getHasWorkToDo() {
        return hasWorkToDo;
    }

    private void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

}
