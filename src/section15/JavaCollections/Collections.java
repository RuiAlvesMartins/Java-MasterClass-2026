package section15.JavaCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Collections {
    
    //  COLLECTIONS
    //  A Collection is an object that represents a GROUP of RELATED objects, by common purpose or relationship;
    //  Collections may differ on how:
    //          they store objects in memory;
    //          objects are retrieved and ordered;
    //          allow null values and duplicate entries;

    //  JAVA COLLECTIONS FRAMEWORK
    //          "A unified architecture for representing and manipulating collections, ...
    //          ... enabling collections to be manipulated independently of implementation details."
    //  As per Oracle documentation: https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html
    //
    //  The Collections Framework is the foundation of the COLLECTIONS HIERARCHY in Java;
    //  An object is part of the framework if it implements the Collections INTERFACE;   
    //  Some Data Structures don't implement said interface, and are exceptions to the framework:
    //          Arrays and it's utilities (java.util.Arrays);
    //          Maps (considered part of the framework but don't implement the interface); 
    //     

    public static void main(String[] args) {
        
        List<String> list = new ArrayList<>();

        //  All of following methods are defined on the Collection Interface;
        //  Here they are  executed on a specific implementation (ArrayList);
        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        list.addAll(Arrays.asList(names));
        System.out.println(list);

        list.add("Fred");
        list.addAll(Arrays.asList("George", "Garry", "Grace"));
        System.out.println(list);
        System.out.println("Garry in the list? " + list.contains("Garry"));

        list.removeIf(s -> s.charAt(0) == 'G');
        System.out.println(list);
        System.out.println("Garry in the list? " + list.contains("Garry"));



        //  The reference variable List<String> can be abstracted further:
        // Collection<String> collectionList = new ArrayList<>();

        //  We can also try out different instance types:
        //  TREESET
        // Collection<String> collectionList = new TreeSet<>();
        //  Output is the same as ArrayList;

        //  HASHSET
        Collection<String> collectionList = new HashSet<>();
        //  Output is not the same; ORDER is different;
        //  Not all Collections are implicitly ordered by INSERTION order, like Lists are;

        System.out.printf("%n%n%n");
        collectionList.addAll(Arrays.asList(names));
        System.out.println(collectionList);

        collectionList.add("Fred");
        collectionList.addAll(Arrays.asList("George", "Garry", "Grace"));
        System.out.println(collectionList);
        System.out.println("Garry in the list? " + collectionList.contains("Garry"));

        collectionList.removeIf(s -> s.charAt(0) == 'G');
        System.out.println(collectionList);
        System.out.println("Garry in the list? " + collectionList.contains("Garry"));



        //  We can call .sort() on a List object, but not on a Collection;
        // collectionList.sort();                                   //  Compiler Error!
        //  List is an interface that extends Collection;
        //  Collection is a more abstrac interface than list, and has no .sort()!

    }

}
