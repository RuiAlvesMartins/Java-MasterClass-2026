package section15;

public class View {
    
    //  What is a VIEW ?

    //  Called View Collection in Java documentation;
    //  A view doesn't store elements directly, but depends on a BACKING collection to store said elements;

    //  Example: a List backed by an Array
    //  Using Arrays.asList() gives us a view, or an array in the form of a list;
    //  Changes made to the list reflect on the array; and vice-versa;
    //  The functionality available on the list view is limited to features supported by the backing storage;
    //  For an array backed list, this means we can't add or remove elements (as arrays are immutable);

    //  Other examples of Views:
    //          SortedSet.headSet()
    //          SortedSet.tailSet()
    //          SortedSet.subSet()
    //          Map.keySet()
    //          Map.values()
    //          Map.entrySet()

    //  In DATABASES, views hide the details of the underlying data structures;
    //  to make it easier for clients to use the data;
    //  The Java View Collection serves a similar purpose;



    //  VIEW COLLECTION
    
    //  Purpose: allow manipulation of collections, without the need to know the details of data storage;

}
