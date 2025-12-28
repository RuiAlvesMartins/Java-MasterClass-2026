package section8.Challenges.SmartKitchen;
public class DishWasher {

    private boolean hasWorkToDo;

    public void doDishes() {
        if (hasWorkToDo) {
            System.out.println("Dishwasher is still working!");
            hasWorkToDo = false;
            return;
        }
        System.out.println("Dishwasher starts cleaning dishes!");
        hasWorkToDo = true;
    }

    public boolean getHasWorkToDo() {
        return hasWorkToDo;
    }

    private void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

}
