package section15.Maps;

public class MapInterface {

    //  MAPS
    //  Are part of the Java Collections Framework, but does not implement Collection!
    //  Today, it replaces the obsolete Dictionary (abstract class);

    //  A language dictionary would be the classic example of a map. E.g.:
    //          Map (key): a depiction of spatial interrelationships within a space (value);

    //  As a data structure, Map stores elements with keyed references;
    //  By other words, it is composed of KEY-VALUE PAIRS:
    //          Key: reference tied to the value;
    //          Value: the element itself
    //  Because of this, Map requires 2 type args:
    //          interface Map<K, V>
    //  These types must be reference types. Cannot be primitives!

    //  In Java, Maps:
    //          cannot contain DUPLICATE keys;
    //          each key must map to a SINGLE value!
    
    //  Map is an interface. It is implemented by:
    //          SortedMap (interface);
    //          HashMap (unordered);
    //          LinkedHashMap (insertion order);
    //          TreeMap (sorted by keys);

    //  Map.Entry<K, V> is a nested interface in Map;
    //  It represents a key-value pair;

    //  Views of Map<K,V>
    //          .keySet()       ->  Set<K,V>
    //          .entrySet()     ->  Set<Map.Entry<K,V>>
    //          .values()       ->  Collection<V>
    //  the view is backed up by the map (changes in one relfect on the other);
    //  Keys can be retrieved as a Set, because they have no duplicates;
    
}
