package section8.Challenges.SmartKitchen;
public class Refrigerator {

    private boolean hasWorkToDo;

    public void orderFood() {
        if (hasWorkToDo) {
            System.out.println("Refrigerator door is still open!");
            hasWorkToDo = false;
            return;
        }
        System.out.println("Refrigerator door opens!");
        hasWorkToDo = true;
    }

    public boolean getHasWorkToDo() {
        return hasWorkToDo;
    }

    private void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

}
