package section16.ImmutableClasses;

public class Main {
    
    public static void main(String[] args) {
        
        // Person jane = new Person();
        // jane.setName("Jane");
        // Person jim = new Person();
        // jim.setName("Jim");
        // Person joe = new Person();
        // joe.setName("Joe");
        // Person john = new Person();
        // john.setName("John");
        // john.setDob("05/05/1900");
        // john.setKids(new Person[]{jane, jim, joe});
        // System.out.println(john);

        // //  John is not immutable:
        // john.setName("Jacob");
        // john.setKids(new Person[] {new Person(), new Person()});
        // System.out.println(john);



        //  .setName() and .setDob() are now commented on Person.java;
        //  constructor methods have now been set up;

        Person jane = new Person("Jane", "01/01/1930");
        Person jim = new Person("Jim", "02/02/1932");
        Person joe = new Person("Joe", "03/03/1934");

        Person[] johnsKids = {jane, jim, joe};
        Person john = new Person("John", "05/05/1900", johnsKids);
        System.out.println(john);

        john.setKids(new Person[] {new Person("Ann", "04/04/1930")});
        System.out.println(john);

        Person[] kids = john.getKids();
        kids[0] = jim;
        System.out.println(john);

        //  setting the kids array to null has no effect on John;
        //  because the reference is only being reassigned to a new instance null;
        //  the original instance remains part of john object's state;  
        kids = null;
        System.out.println(john);

        //  now john has no kids :(
        john.setKids(kids);
        System.out.println(john);

    }

}
