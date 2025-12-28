package section10.Lists;

import java.util.LinkedList;
import java.util.ListIterator;

public class Iterators {

    //  ITERATORS

    //  What is an Iterator?
    //  Is a special way of navigating through LinkedLists and other Queue Collections;
    //  You move one element at a time, either forwards .next() or backwards .previous();
    //  Check for adjacent elements with .hasNext() and .hasPrevious();
    //  Iterators need to be instantiated!

    //  Iterator can only go forwards!
            //  .next()
            //  .hasNext()
            //  .remove()
    //  ListIterator can go forwards and backwards;
            //  .previous()
            //  .hasPrevious()
            //  .add()
            //  .set()


    public static void main(String[] args) {
        var placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Camberra");
        placesToVisit.addFirst("Darwin");
        placesToVisit.addLast("Hobart");
        placesToVisit.offer("Melbourne");
        placesToVisit.offerFirst("Brisbane");
        placesToVisit.offerLast("Toowoomba");
        placesToVisit.push("Alice Springs");

        printItenerary(placesToVisit);
        iteratorPrint(placesToVisit);
        iteratorRemove(placesToVisit, "Brisbane");
        listIteratorAdd(placesToVisit, "Brisbane", "Alice Springs");
        System.out.println();



        //  The Iterator CURSOR is always BETWEEN elements!

        //  .listIterator(Index)
        //  will return element at Index position;
        var iterator = placesToVisit.listIterator(3);
        //  cursor is between index 2 and 3;
        System.out.println(iterator.next());                    //  returns index 3 element;
        //  cursor is between index 3 and 4;
        System.out.println(iterator.previous());                //  returns index 3 element;
        iterator = placesToVisit.listIterator(0);
        //  cursor is behind index 0;
        System.out.println(iterator.next());                    //  returns index 0 element;
        //  cursor is between index 0 and 1;
        iterator.previous();                                    //  returns index 0 element;
        // iterator.previous();                                 //  indexOutOfBoundsException;
        iterator = placesToVisit.listIterator(placesToVisit.size() - 1);
        //  cursor is between index n - 2 and n - 1;
        System.out.println(iterator.next());                    //  returns index n - 1;
        // iterator.next();                                     //  indexOutOfBoundsException;

    }

    public static void printItenerary(LinkedList<String> list) {
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

    private static void iteratorPrint(LinkedList<String> list) {

        var iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(list);

    }

    private static void iteratorRemove(LinkedList<String> list, String key) {

        var iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(key)) {
                //  must call .remove() on the iterator instance!
                iterator.remove();
            }
        }
        System.out.println(list);

    }

    private static void listIteratorAdd(LinkedList<String> list, String add, String after) {

        var iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(after)) {
                //  must call .add() on the iterator instance!
                iterator.add(add);
            }
        }

        //  after exciting first while loop, iterator.hasNext() has been set to false;
        //  because iterator is at the end of the list;
        //  so this if will never trigger;
        if (iterator.hasNext()) {
            System.out.println("flag1");
        }

        //  we need to move iterator to the begining of the list;
        while (iterator.hasPrevious()) {
            iterator.previous();
        }

        //  so that .hasNext() is true again;
        if (iterator.hasNext()) {
            System.out.println("flag2");
        }

        System.out.println(list);

    }

}
