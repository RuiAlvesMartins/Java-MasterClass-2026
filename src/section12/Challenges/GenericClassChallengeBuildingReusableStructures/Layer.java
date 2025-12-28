package section12.Challenges.GenericClassChallengeBuildingReusableStructures;

import java.util.List;

public class Layer<T extends Mappable> {

    private List<T> elements;

    public Layer(List<T> elements) {
        this.elements = elements;
    }

    public void addElement(T t) {
        elements.add(t);
    }

    public void renderLayer() {
        //  loops through all elements and executes .render() on each
        for (T t : elements) {
            System.out.println(t.render());
        }
    }

}
