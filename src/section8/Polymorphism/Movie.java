package section8.Polymorphism;

public class Movie {

    private String title;

    public void watchMovie() {

        //  getClass() returns the class of the object/instance;
        //  getSimpleName() chained to getClass() returns the object's class name;
        String instanceType = this.getClass().getSimpleName();
        System.out.println(title + " is a " + instanceType + " film");

    }

    public Movie(String title) {
        this.title = title;
    }

    //  FACTORY METHOD
    //  it instantiates objects from code inside the class;
    //  Factory methods allow us to instantiate an object, whithout having to know the details of how to create one;
    //  when calling this method, running code doesn't need to know anything about our subclasses;
    public static Movie getMovie(String type, String title) {

        return switch (type.toUpperCase().charAt(0)) {
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title);
            case 'S' -> new ScienceFiction(title);
            default -> new Movie(title);
        };

    }
   
}
