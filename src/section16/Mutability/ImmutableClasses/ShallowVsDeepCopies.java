package section16.Mutability.ImmutableClasses;

import java.util.Arrays;

record PersonDemo(String name, String dob, PersonDemo[] kids) {

    public PersonDemo(PersonDemo p) {
        this(p.name, p.dob, p.kids == null ? null : Arrays.copyOf(p.kids, p.kids.length));
    }

    @Override
    public String toString() {
        String s = "%s %s %s".formatted(name, dob, Arrays.toString(kids));
        return s;
    }
    
}

public class ShallowVsDeepCopies {
    
    //  DEFENSIVE COPY as INPUT
    //  When passing mutable types (e.g. collections) to an immutable object;
    //  a defensive copy should be made, and then assigned to the field;
    //  Example: initializing collection fields on CONSTRUCTORS;

    //  DEFENSIVE COPY as OUTPUT
    //  When retrieving data from an immutable object;
    //  a defensive copy should be made, and then passed on to the calling code;
    //  Example: defensive GETTERS;



    //  SHALLOW COPY
    //  Makes copy of the STRUCTURE of a collection;
    //  Copy methods on interfaces and helper classes will likely be a shalow copy;
    //  It instantiates the array first, with the same number of indexed positions;
    //  Then assigns the same values as elements;

    //  DEEP COPY
    //  Makes copy of both the STRUCTURE and ELEMENTS of a collection;
    //  Usually have to be manually implemented;
    //  Needed to ensure IMMUTABILITY;



    public static void main(String[] args) {
        
        PersonDemo joe = new PersonDemo("Joe", "01/01/1961", null);
        PersonDemo jim = new PersonDemo("Jim", "02/02/1962", null);
        PersonDemo jack = new PersonDemo("Jack", "03/03/1963", new PersonDemo[]{joe, jim});
        PersonDemo jane = new PersonDemo("Jane", "04/04/1964", null);
        PersonDemo jill = new PersonDemo("Jill", "05/05/1965", new PersonDemo[]{joe, jim});

        PersonDemo[] persons = {joe, jim, jack, jane, jill};
        //  Arrays.copyOf()     makes a SHALLOW copy;  
        //  but because there is no way to mutate fields on Person record;
        //  there is also no need for a deep copy;
        PersonDemo[] personsCopy = Arrays.copyOf(persons, persons.length);

        //  this will mutate the code;
        //  because persons and personsCopy are backed by the same elements!
        //  (the latter is a shallow copy of the former)
        var jillsKids = personsCopy[4].kids();
        jillsKids[1] = jane;

        for (int i=0; i<persons.length; i++) {
            //  == tests if the references are equal, i.e., if they point to the same object in memory;
            //  (does not necessarily mean the two objects are exactly equal)
            if (persons[i] == personsCopy[i]) {
                System.out.println("Equal References " + persons[i]);
            }
        }

        System.out.println("-".repeat(60));
        System.out.println(persons[4]);
        //  OUTPUT:     Jill 05/05/1965 [Joe 01/01/1961 null, Jane 04/04/1964 null]                    
        System.out.println(personsCopy[4]);
        //  OUTPUT:     Jill 05/05/1965 [Joe 01/01/1961 null, Jane 04/04/1964 null]
        //  Original array IS affected by changes made on shallow copy!



        System.out.println("-".repeat(60));
        //  this is needed to reset changes;
        jillsKids[1] = jim; 
        //  this will instantiate a new array, to test deep copy;
        personsCopy = new PersonDemo[5];

        //  populating the deep copy;
        for (int i=0; i<persons.length; i++) {
            PersonDemo current = persons[i];
            //  this will make only a shallow copy of the kids array;
            //  but it is fine for our purposes right now;
            var kids = current.kids() == null ? null : 
                    Arrays.copyOf(current.kids(), current.kids().length);
            //  a deep copy instantiates copies of the original elements!
            personsCopy[i] = new PersonDemo(current.name(), current.dob(), kids);
        }
        //  alternatively, it is possible to populate the deep copy array with the overloaded constructor returning a copy of Person:
        // Arrays.setAll(personsCopy, i -> new Person(persons[i]));
        //  Array.clone()       only makes a shallow copy!
        // personsCopy = persons.clone();

        //  we now make changes to the deep copy;
        jillsKids = personsCopy[4].kids();
        jillsKids[1] = jane;

        for (int i=0; i<persons.length; i++) {
            if (persons[i] == personsCopy[i]) {
                System.out.println("Equal References " + persons[i]);
            }
        }
        //  nothing is printed, because personsCopy is a DEEP copy!
        //  it's elements are different from those on the original array!

        System.out.println(persons[4]);
        //  OUTPUT:     Jill 05/05/1965 [Joe 01/01/1961 null, Jim 02/02/1962 null]                    
        System.out.println(personsCopy[4]);
        //  OUTPUT:     Jill 05/05/1965 [Joe 01/01/1961 null, Jane 04/04/1964 null]
        //  Original array is NOT affected by changes made on deep copy!

    }

}
