package section8.Polymorphism;

import java.util.Scanner;

public class Main {

    //  POLYMORPHISM
    //  Polymorphism means many forms;
    //  In Java, Polymorphism allows code to call a method, but the actual method being executed may be different for different objects at runtime;
    //  I.e. the behaviour during program execution depends on the runtime type of the object, which CAN differ from it's declared type in code;
    //  Polymorphism only works if the declared type has a relationship with the runtime type; This can be achieved through INHERITANCE;

    public static void main(String[] args) {
        
        // Movie theMovie = new Movie("Star Wars");
        // theMovie.watchMovie();

        //  EXAMPLE #1
        //  reference is declared with the super class data type;
        //  but the actual instance is of the sub class data type;
        //  this is allowed by INHERITANCE;
        Movie theMovie = new Adventure("Star Wars");
        //  EXAMPLE #2
        //  theMovie is of Movie data type;
        //  but the actual watchMovie() being called is the overridden one in Adventure.java;
        //  this is allowed by METHOD OVERRIDING;
        theMovie.watchMovie();



        //  getMovie() is a FACTORY METHOD;
        //  it instantiates objects from code inside the class;
        //  unlike creating them from running code (main method) like we did so far;
        //  when calling this method, running code doesn't need to know anything about our subclasses;
        Movie spaceBalls = Movie.getMovie("Comedy", "Space Balls");
        spaceBalls.watchMovie();

        Movie spaceOdyssey = Movie.getMovie("Science", "2001: A Space Odyssey");
        spaceOdyssey.watchMovie();



        //  User inputs movie data;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter Type (A for Adventure, C for Comedy, " + 
                            "S for Science Fiction, or Q to quit): ");
            String type = scanner.nextLine();
            //  if user inputs 'Q' or 'q', the code will break out of the loop;
            if ("Qq".contains(type)) {
                break;
            }
            System.out.println("Enter Movie Title: ");
            String title = scanner.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
        }
        //  despite not knowing anything about subclasses,
        //  this code is calling the OVERRIDEN watchMovie() for each type of movie;
        //  this is thanks to the SWITCH in the FACTORY method on Movie SUPER class;



        //  CASTING SUBCLASSES
        //  this line won't work, because not all movies are adventure movies;
        // Adventure jaws = Movie.getMovie("Adventure", "Jaws");

        //  when assigning references of SUB class type to a method in the SUPER class, 
        //  even if said method returns the correct sub class type, there will still be a COMPILER ERROR,
        //  because java can only know that the correct data type will be returned at RUNTIME;
        //  to get around this, you must CAST the sub class data type;
        Adventure jaws = (Adventure) Movie.getMovie("Adventure", "Jaws");
        jaws.watchMovie();

        //  keep in mind that the SUPER class method MUST return the correct data type for the casting to work;
        //  the next line will throw an exception;
        // Comedy theRoom = (Comedy) Movie.getMovie("Drama", "The Room");

        //  The compiler won't use the method return type to figure out what adventure really is, after you make this assignment.
        //  It just assumes it's an object, and this variable only has access to object's functionality.
        //  This is because, at any time in the code, an instance of object itself could be assigned to this variable.
        //  And the code has to work for whatever object get assigned to this variable.
        //  TLDR: you will get an error because compiler can't find watchMovie() on Object class.
        Object zoneOsobogoBnimaniya = Movie.getMovie("Adventure", "In the Zone of Special Attention");
        // zoneOsobogoBnimaniya.watchMovie();

        //  To get around this, again, you need to cast;
        Movie zoneSpecialAttentionMovie = (Movie) zoneOsobogoBnimaniya;
        zoneSpecialAttentionMovie.watchMovie();
        //  this line won't compile because watchAdventure() is not part of Movie class;
        // zoneSpecialAttentionMovie.watchAdventure();
        Adventure zoneSpecialAttentionAdventure = (Adventure) zoneOsobogoBnimaniya;
        zoneSpecialAttentionAdventure.watchAdventure();

        //  TLDR: if you use generic references (like Object), you will be doing a lot of CASTING!



        //  LOCAL VARIABLE TYPE INFERENCE (LVTI)
        //  VAR is a special contextual keyword in Java that lets our code take advantage of LVTI;
        //  By using var, Java will figure out the compile-time type for us;
        //  You can think of COMPILE TIME type as the DECLARED type;
        //  The RUNTIME type gets infered by the compiler;
        //  Compile time types can differ from Runtime types because of POLYMORPHISM;
        //  LVTI was introduced in Java 10; 
        //  LVTI can't be used:
        //      in field declarations in classes;
        //      in method signatures (either as parameter or as return type);
        //      without an assignment, or be assigned to a NULL literal (type can't be infered);
        var modernTimes = Movie.getMovie("Comedy", "Modern Times");
        modernTimes.watchMovie();
        // LVTI is able to infer that object is a Movie, but not which type of movie, i.e. whcih subclass;
        // modernTimes.watchComedy();



        //  RUNTIME INSPECTION
        //  How can we test the atual runtime type of a variable of different declared type?
        Object unknownObject = Movie.getMovie("Science Fiction", "The Holy Mountain");
        
        if (unknownObject.getClass().getSimpleName().equals("ScienceFiction")) {
            ScienceFiction sf = (ScienceFiction) unknownObject;
            sf.watchScienceFiction();            
        }

        //  INSTANCEOF returns true if object (left) is of the test type (right);
        //  no need to assign the result of the cast to a local variable;
        if (unknownObject instanceof ScienceFiction) {
            ((ScienceFiction) unknownObject).watchScienceFiction();
        }

        //  PATTERN MATCHING for the instanceof operator;
        //  if instanceof returns true, object will be implicitly cast into test data type;
        if (unknownObject instanceof ScienceFiction scifi) {
            scifi.watchScienceFiction();
        }

    }

}
