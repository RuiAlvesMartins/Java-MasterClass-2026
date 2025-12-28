package section7.StaticVsInstance;

public class Dog {

    //  this is a STATIC variable;
    private static String genus;
    //  this is an INSTANCE variable;
    private String breed;



    public static void dogBark() {
        System.out.println("Wof!");
    }

    public void printDog() {
        System.out.println(breed + " is of " + genus + " genus");
    }



    public Dog(String genus, String breed) {
        this.genus = genus;
        this.breed = breed;
    }

    public Dog(String breed) {
        this.breed = breed;
    }

    public Dog() {
        this.breed = null;
    }

    public static String getGenus() {
        return genus;
    }
    public static void setGenus(String genus) {
        Dog.genus = genus;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }

    

}
