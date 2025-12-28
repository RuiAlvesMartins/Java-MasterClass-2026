package section8.Polymorphism;

public class ScienceFiction extends Movie {



    public void watchMovie() {
        super.watchMovie();
        //  this will print out the 3 arguments in sequence;
        System.out.printf("... %s%n".repeat(3),
                "Aliens spoted",
                "Cows are abducted",
                "Planet blows up");
    }

    public ScienceFiction(String title) {
        super(title);
    }

    public void watchScienceFiction() {
        System.out.println("Watching a Science Fiction film!");
    }

}
