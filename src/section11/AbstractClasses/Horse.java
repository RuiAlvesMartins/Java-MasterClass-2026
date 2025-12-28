package section11.AbstractClasses;

public class Horse extends Mammal {

    public Horse(String type, String size, double weight) {
        super(type, size, weight);
        //TODO Auto-generated constructor stub
    }

    //  implements shedHair() from Mammal;
    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " sheds in the spring");
    }

    //  implements makeNoise() from Animal;
    @Override
    public void makeNoise() {

    }


}
