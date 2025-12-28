package section7.Inheritance;

public class Main {

    //  INHERITANCE is a war to organize classes into a hierarchy;
    //  Lower SUB/CHILD classes EXTEND higher SUPER/PARENT classes;
    //  Extend allows them to INHERIT the fields and methods of the higher class;
    //  SUB classes have a IS A RELATIONSHIP with SUPER class;
    //  They can at the same time implement their own fields and methods, for a more specialized state and behaviour;

    public static void main(String[] args) {
        
        Animal animal = new Animal("Generic Animal", "Huge", 400);
        doAnimalStuff(animal, "slow");

        //  child classes can replace their parent class as arguments
        Dog dog = new Dog();
        doAnimalStuff(dog, "fast");

        Dog yorkie = new Dog("Yorkie", 15);
        doAnimalStuff(yorkie, "fast");
        Dog retriever = new Dog("Labrdor Retriever", 65, "Floppy", "Swimmer");
        doAnimalStuff(retriever, "slow");

        Dog wolf = new Dog("Wolf", 40);
        doAnimalStuff(wolf, "slow");

        Fish goldie = new Fish("Goldfish", 0.25, 2, 3);
        doAnimalStuff(goldie, "fast");

    }

    public static void doAnimalStuff(Animal animal, String speed) {
        animal.makeNoise();
        animal.move(speed);
        //  METHOD OVERRIDE
        //  if a child class is passed as argument, the code will run the toString on the child class
        System.out.println(animal);
        System.out.println("_ _ _ _");
    }

}
