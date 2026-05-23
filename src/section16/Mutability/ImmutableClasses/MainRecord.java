package section16.Mutability.ImmutableClasses;

public class MainRecord {
    
    public static void main(String[] args) {
        
        PersonRecord jane = new PersonRecord("Jane", "01/01/1930");
        PersonRecord jim = new PersonRecord("Jim", "02/02/1932");
        PersonRecord joe = new PersonRecord("Joe", "03/03/1934");

        PersonRecord[] johnsKids = {jane, jim, joe};
        PersonRecord john = new PersonRecord("John", "05/05/1900", johnsKids);
        System.out.println(john);

        //  kids array is initialized with 20 slots by default on constructor;
        PersonRecord johnCopy = new PersonRecord("John", "05/05/1900");
        System.out.println(johnCopy);

        //  RECORDS are IMMUTABLE   (remember?)
        //  but
        //  you cannot guarantee immutability on collections, e.g. kids array;
        //  now John has two kids, where he once had none;
        PersonRecord[] kids = johnCopy.kids();
        kids[0] = jim;
        kids[1] = new PersonRecord("Ann", "04/04/1936");
        System.out.println(johnCopy);
        //  Solution: defensive getter      (go on PersonRecord and uncomment it)
        //  changes will be performed on a copy returned by the getter, and not the original instance associated to the field;

        johnsKids[0] = new PersonRecord("Ann", "04/04/1936");
        System.out.println(john);
        //  this still mutates the STATE though;
        //  Solution?       see PersonImmutable.java



        //  RECORDS are IMMUTABLE in theory
        //  but not guaranteed in practice

    }

}
