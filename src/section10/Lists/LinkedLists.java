package section10.Lists;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedLists {
    
    //  LINKEDLIST

    //  (refer to the discussion on Big O Notations)
    //  Linked List is data structure of the Doubly Linked List type, or QUEUE;
    //  LinkedList differs from ArrayList because it has no Array working in the back with stored references;
    //  LinkedList is NOT INDEXED, whilst ArrayList is;
    //  Each element forms a CHAIN, with an associated PREVIOUS and NEXT element;
    //  The first element being the HEADER, and the last being the TAIL;

    //  ArrayList is cheaper to access (.get()) and manipulate (.set()) existing elements;
    //  LinkedList is cheaper for adding or removing elements;
    //  If you know the maximum number of possible items, then it is better to use an ArrayList with defined capacity;
    // ArrayList<String> stringArray = new ArrayList<>(Integer.MAX_VALUE);
    //  If you don't know how maximum number of possible items, or if said value exceeds Integer.MAX_VALUE (arrays index are of int data type), use LinkedList;    


    //  QUEUE
    //  A Queue is a FIRST-IN, FIRST-OUT (FIFO) Data COLLECTION;
    //  SINGLE-ENDED Queues always process elements from the START of the Queue;
    //  DOUBLE-ENDED Queues allows access to both START and END of the Queue;

    //  LinkedList is a double-ended queue;
    //  Both LinkedList and ArrayList implement all of Lists methods, but LinkedList implements QUEUE and STACK methods too;



    //  STACK
    //  A Stack is a LAST-IN, FIRST-OUT (LIFO) Data COLLECTION;


    public static void main(String[] args) {
        
        //  Declaration and Initialization
        LinkedList<String> countriesToVisit = new LinkedList<>();

        //  when declaring with the VAR type, you need to specify data type on initialization!
        var placesToVisit = new LinkedList<String>();

        //  .add(Object)
        placesToVisit.add("Sydney");
        //  .add(Index, Object)
        placesToVisit.add(0, "Camberra");
        //  sout
        System.out.println(placesToVisit);

        //  .addFirst(Object)
        //  adds element to the START of the list;
        placesToVisit.addFirst("Darwin");
        //  .addLast(Object)
        //  adds element to the END of the list;
        placesToVisit.addLast("Hobart");
        System.out.println(placesToVisit);
        //  QUEUE methods;
        //  .offer(Object)
        //  adds element to the END of the list;
        placesToVisit.offer("Melbourne");
        //  .offerFirst(Object)
        //  adds element to the START of the list;
        placesToVisit.offerFirst("Brisbane");
        //  .offerLast(Object)
        //  adds element to the END of the list;
        placesToVisit.offerLast("Toowoomba");
        System.out.println(placesToVisit);
        //  STACK methods
        //  .push(Object)
        //  adds element to the START of the list;
        placesToVisit.push("Alice Springs");
        System.out.println(placesToVisit);

        //  .remove(Index)
        placesToVisit.remove(4);
        //  .remove(Object)
        placesToVisit.remove("Brisbane");
        System.out.println(placesToVisit);
        //  .remove(no args)
        //  removes first element, and returns it;
        System.out.println(placesToVisit.remove());
        //  .removeFirst()
        //  removes first element, and returns it;
        System.out.println(placesToVisit.removeFirst());
        //  .removeLast()
        //  removes last element, and returns it;
        System.out.println(placesToVisit.removeLast());
        //  QUEUE methods
        //  .poll(no args)
        //  removes first element, and returns it;
        System.out.println(placesToVisit.poll());
        //  .pollFirst()
        //  removes first element, and returns it;
        System.out.println(placesToVisit.pollFirst());
        //  .pollLast()
        //  removes last element, and returns it;
        System.out.println(placesToVisit.pollLast());
        //  STACK methods
        placesToVisit.push("Sydney");
        placesToVisit.push("Brisbane");
        placesToVisit.push("Canberra");
        System.out.println(placesToVisit);
        //  .pop(no args)
        //  removes first element, and returns it;
        System.out.println(placesToVisit.pop());

        //  #########################################
        //  Repopulating LinkedList
        //  #########################################

        placesToVisit.pop();
        placesToVisit.pop();
        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Camberra");
        placesToVisit.addFirst("Darwin");
        placesToVisit.addLast("Hobart");
        placesToVisit.offer("Melbourne");
        placesToVisit.offerFirst("Brisbane");
        placesToVisit.offerLast("Toowoomba");
        placesToVisit.push("Alice Springs");
        System.out.println(placesToVisit);

        //  #########################################

        //  .get(Index)
        System.out.println(placesToVisit.get(4));
        //  .getFirst()
        //  returns the FIRST element;
        System.out.println(placesToVisit.getFirst());
        //  .getLast()
        //  returns the LAST element;
        System.out.println(placesToVisit.getLast());
        //  .indexOf(Object)
        //  returns the index of object, but counting from the HEADER;
        System.out.println(placesToVisit.indexOf("Darwin"));
        //  .lastIndexOf(Object)
        //  returns the index of object, but counting from the TAIL;
        System.out.println(placesToVisit.lastIndexOf("Melbourne"));
        //  QUEUE methods
        //  .element()
        //  returns FIRST element;
        System.out.println(placesToVisit.element());
        //  STACK methods
        //  .peek()
        //  returns FIRST element;
        System.out.println(placesToVisit.peek());
        //  .peekFirst()
        //  returns FIRST element;
        System.out.println(placesToVisit.peekFirst());
        //  .peekLast()
        //  returns LAST element;
        System.out.println(placesToVisit.peekLast());

        printItenerary(placesToVisit);
        printItenerary2(placesToVisit);
        printItenerary3(placesToVisit);

    }

    public static void printItenerary(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        for (int i = 1; i < list.size(); i++) {
            System.out.println("--> From: " + list.get(i - 1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItenerary2(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        for (String town : list) {
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItenerary3(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasNext()) {
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

}
