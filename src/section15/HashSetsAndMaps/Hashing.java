package section15.HashSetsAndMaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hashing {
    
    //  The importance of HASHES in DATA STRUCTURES

    //  SETS are designed to ensure uniqueness of elements, i.e. not allowing DUPLICATES;
    //  this requires checking if an element is not already present in the set before adding it;
    //  such an operation means iterating through all elements of the set to check for equality;
    //  this takes potentially O(n) time, i.e. a big problem in large datasets;

    //  HASHING (in Java)
    //  Hashing is a technique that can reduce the time cost of operations
    //  TODO what is hashing?


    //  EQUALITY of objects in java
    //  Two methods test for eaquality:
    //
    //          public boolean equals(Object obj) {
    //              return (this == obj);
    //          }
    //
    //          public int hashCode() 
    //
    //  .hashCode() is a NATIVE method on Object class;
    //  What does == mean?
    //  It means two variables have the same reference to a single object in memory!



    public static void main(String[] args) {
        
        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        List<String> hellos = Arrays.asList(aText, bText, cText, dText, eText);
        hellos.forEach(s -> System.out.println(s + ": " + s.hashCode()));
        //  Output: only eText "hello" has a different hashcode!

        Set<String> mySet = new HashSet<>(hellos);
        System.out.println("mySet = " + mySet);
        System.out.println("# of elements = " + mySet.size());
        //  Output: mySet = [Hello, hello]

        for (String setValue : mySet) {
            System.out.print(setValue + ": ");
            for(int i=0; i<hellos.size(); i++) {
                if (setValue == hellos.get(i)) {
                    System.out.print(i + ", ");
                }
            }
            System.out.println(" ");
        }
        //  Output: Hello: 0, 1,  
        //  Output: hello: 4, 



        System.out.println();
        System.out.println("-".repeat(30));
        System.out.println();

        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");

        List<PlayingCard> cards = Arrays.asList(aceHearts, kingClubs, queenSpades);
        cards.forEach(c -> System.out.println(c + ": " + c.hashCode()));
        //  Output: each card has a unique hashcode;

        Set<PlayingCard> deck = new HashSet<>();
        for (PlayingCard c : cards) {
            if (!deck.add(c)) {
                System.out.println("Found duplicate for " + c);
            }
        }
        System.out.println(deck);


        //  TODO organize this info a bit better
        //  The HashSet will only add new references to it's collection if it doesn't find a match in it's collection,
        //  first using the .hashCode() and then .equals();
        //  It uses the hashCode to create a bucket identifier to store the new reference;

        //  An indexed bucket is created as an algorithm dependent on the hash code;
        //  If hash codes are different, then unique elements are distributed across algorithmically identified buckets;
        //  If hash codes are the same, the equals method is used to determine if elements in the bucket are equal or duplicates;

        //  The only time the .equals() method is called, when adding elements to the hashset,
        //  is when the hashcode algorithm returns the same bucket identifier
        //  this is true here, as our hashcode for all 3 cards equals 1;

    }

    //  If you are using your classes in hashed collections, you SHOULD OVERRIDE both .equals() and .hashCode()!
    //  When overriding .equals() and .hashCode(), your code should:
    //          Be very fast to compute;
    //          Produce a consistent result each time it's called;
    //          Objects that are considered equal should produce the same hashCode;
    //          Values used in the calculation should not be mutable;
    //  A small PRIME NUMBER is used as a multiplier when overriding .hashCode():
    //          This helps spread out hash codes more evenly, reducing the chance that different objects end up with the same hash code;
    //          Very useful if the data might naturally cluster or follow patterns;
    //          Very large prime numbers are ineficcient;
    //          Very small primes (2, 3, 5, 7) run the risk of less effective distribution, as many numbers are divisible by them;
    //          31, 29, 37, 43, or even non-primes like 33 do just fine;

}
