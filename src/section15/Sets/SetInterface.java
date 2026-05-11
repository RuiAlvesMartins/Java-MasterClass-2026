package section15.Sets;

public class SetInterface {

    //  SETS
    //  Set is an interface. It is implemented by:
    //          HashSet;
    //          HashMap;
    //          HashTable;
    //          LinkedHashSet;
    //          LinkedHashMap;

    //  A Set:
    //          is NOT implicitly ORDERED;
    //          contains NO DUPLICATES;
    //          may contain a single NULL;
    //          operations on them are very fast;

    //  Basic Set methods:
    //          .add()
    //          .remove()
    //          .clear()
    //          .contains()
    //          .size()
    //  There is no .get() to retrieve an element from a set!   
    //  There is also no .replace() nor .replaceAll()! 
    
    

    //  HASHSET
    //  HashSets are the BEST-performing implementation of Set;
    //  It uses HASHING mechanisms to store items;
    //  .hashCode() is used to support even distributions of objects in the set;
    //  Oracle asserts O(1) (constant time) performance for basic operations .add(); .remove(); .contains(); .size();
    //  (assuming hash function disperses elements evenly across the set);
    //  As of JDK8, HashSet uses a HASHMAP in it's implementation;
    //  TODO: expand this



    //  Set MATH OPERATIONS
    //  Union;
    //  Intersection;
    //  Difference;
    //  Symmetric Difference;



    //  LINKED HASHSET
    //  Extends HashSet;
    //  Is ORDERED (insertion order); 

    //  TREESET
    //  Uses a Red Black Tree data structure, a derivative of a Binary Search Tree;
    //  Is ORDERED (natural order or by specifiing the sort on the creation);
    //  O(log(n)) for .add(), .remove(), .contains();
    //  Implements NavigableSet -> SortedSet -> Set -> Collection;
    //  SortedSet has .first(), .last(), .headSet(), .tailSet(), .comparator();
    //  NavigableSet has .ceiling(), .floor(), .higher(), .lower(), .descendingSet(), etc...
    //  Elements that don't implement Comparable can be passed to a TreeSet, but a Comparator must also be provided;
    //  This is an ordered structure after all;
    //  Primitives or other elements with a natural order are exempt from this rule;

}
