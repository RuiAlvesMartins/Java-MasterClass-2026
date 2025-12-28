package section10.BigONotation;

public class BigONotation {

    //  BIG O NOTATION
    //  https://www.youtube.com/watch?v=g2o22C3CRfU
    //  https://www.youtube.com/shorts/WbF2bLbAUik
    //  https://www.youtube.com/watch?v=BgLTDT03QtU

    //  Big O Notation: O(n), or, how the costs of an operation (O) increase as the number of elements (n) grow towards infinity;
    //  Time Cost;
    //  Space Cost (or Memory Cost);
    //  These costs can scale: 
    //          linearly O(n);
    //          logarithmically O(log n);
    //          exponentially O(n2);
    //          or ideally stay the same O(1) (constant time);

    //  Constant Amortized Time Cost: O(n)*
    //  In the majority of cases, cost is close to O(1) (constant time)



    //  How does Java store information in memory for Arrays, ArrayLists and LinkedLists?
    //  (for a clearer understanding, refer to Tim Buchalka's video on Big O Notation, section 10)

    //  In an array of primitive types, elements are alocated space in memory contiguously;
    //  Contiguously means Java can easily get the element by looking at it's index and multiplying it by the size of the data type (e.g. int is 4 bytes);

    //  For reference types (anything other than a primitive) stored in an array, the array element's aren't the values (i.e. objects/instances) themselves, but their addresses/references;
    //  This means that objects are not stored contiguously in memory;
    //  But their references are stored contiguously;
    //  Knowing these facts about contiguity of memory storage, allow us to design efficient ways to look up elements in data structures;

    //  To remove an element, referenced addresses have to be re-indexed;
    //  To add an element, the array might be too small, and reference addresses need to be reallocated to a new one;
    //  These operations can be time-intensive (i.e. expensive) if the number of elements is sufficiently large;

    //  For ArrayLists, there is an Array behind the scenes with a contiguous list of references;
    //  When an ArrayList needs more capacity, sometimes the array with the references needs to be rellocated to a new bigger array;
    //  The cost of these operations is expected to be O(n)*, as per java documentation;

    //  Linked List is data structure of the Doubly Linked List type, or QUEUE;
    //  LinkedList differs from ArrayList because it has no Array working in the back with stored references;
    //  LinkedList is NOT INDEXED, whilst ArrayList is;
    //  Each element forms a CHAIN, with an associated PREVIOUS and NEXT element;
    //  The first element being the HEADER, and the last being the TAIL;

    //  Because it is not indexed, you can't retrieve or set a value through the index;
    //  You have to start from the head or from the tail, even if you know the position of the element in question;
    //  However, inserting or removing items is much less taxing on computational resources;
    //  Break two links in the chain, and re-establish two new links and it's done;
    //  No new array needs to be created;
    //  No elements need to be shifted to different positions, no memory reallocation necessary;

    //  ArrayList is cheaper to access (.get()) and manipulate (.set()) existing elements;
    //  LinkedList is cheaper for adding or removing elements;
    //  If you know the maximum number of possible items, then it is better to use an ArrayList with defined capacity;
    // ArrayList<String> stringArray = new ArrayList<>(Integer.MAX_VALUE);
    //  If you don't know how maximum number of possible items, or if said value exceeds Integer.MAX_VALUE (arrays index are of int data type), use LinkedList;    


    public static void main(String[] args) {
        


    }

}
