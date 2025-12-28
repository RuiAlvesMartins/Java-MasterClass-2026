package section8.Polymorphism;

public class Adventure extends Movie {



    public void watchMovie() {
        super.watchMovie();
        //  this will print out the 3 arguments in sequence;
        System.out.printf("... %s%n".repeat(3),
                "Pleasant Scene",
                "Scary Music",
                "Something Bad Happens");
    }

    public Adventure(String title) {
        super(title);
    }

    public void watchAdventure() {
        System.out.println("Watching an Adventure!");
    }

}
