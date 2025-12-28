package section8.Polymorphism;

public class Comedy extends Movie {



    public void watchMovie() {
        super.watchMovie();
        //  this will print out the 3 arguments in sequence;
        System.out.printf("... %s%n".repeat(3),
                "Something funny happens",
                "Something even funnier happens",
                "Comedic Ending");
    }


    public Comedy(String title) {
        super(title);
    }

    public void watchComedy() {
        System.out.println("Watching a Comedy!");
    }

}
