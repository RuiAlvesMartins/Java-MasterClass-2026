package section11.AbstractClasses;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        //  Cannot instantiate abstract classes!
        // Animal animal = new Animal("Wolf", "big", 100) 

        Dog dog = new Dog("Wolf", "big", 100);
        dog.makeNoise();
        doAnimalStuff(dog);

        //  This ArrayList of type Animal can hold both dogs and fish!
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Fish("Goldfish", "big", 1));
        animals.add(new Fish("Barracuda", "big", 75));
        animals.add(new Dog("Pug", "big", 20));

        animals.add(new Horse("Clydesdale", "large", 1000));
        
        for (Animal animal : animals) {
            doAnimalStuff(animal);
            if (animal instanceof Mammal curreMammal) {
                curreMammal.shedHair();
            }
        }

    }

    private static void doAnimalStuff(Animal animal) {
        animal.makeNoise();
        animal.move("slow");
    }

}
