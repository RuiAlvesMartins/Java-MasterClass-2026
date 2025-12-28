package section10.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lists {
    
    //  LIST
    //  An INTERFACE that List classes implement;
    //  https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html#method-summary

    //  Unlike ARRAYLISTS, LISTS are IMMUTABLE, just like ARRAYS!
    
    public static void main(String[] args) {
        
        String[] items = {"apples", "bananas", "milk", "eggs"};

        //  .of(Array) is a FACTORY method of List;
        List<String> list = List.of(items);
        //  you can PRINT List directly from sout!
        System.out.println(list);

        //  proof that LISTS are IMMUTABLE;
        System.out.println(list.getClass().getName());
        //  further proof (running next line will throw exception);
        // list.add("yogurt");

        //  new ArrayList<>(List) will populate new ArrayList with the already instantiated List object;
        ArrayList<String> groceries = new ArrayList<>(list);
        //  ArrayLists are mutable;
        groceries.add("yogurt");
        System.out.println(groceries);

        //  new ArrayList<> (List.of(Array));
        //  another easy way of populating an ArrayList!
        ArrayList<String> nextList = new ArrayList<>(
            List.of("pickles", "mustard", "cheese")
        );
        System.out.println(nextList);

        //  .addAll()
        //  adds all elements of an ArrayList to another ArrayList;
        groceries.addAll(nextList);
        System.out.println(groceries);



        //  Arrays.asList()
        //  will return a List<String> from an array;
        //  but a List created in this manner is not resizeable, just like an Array!
        String[] originalArray = new String[] {"First", "Second", "Third"};
        var originalList = Arrays.asList(originalArray);

        //  list is mutable!
        originalList.set(0, "one");
        //  change affects both list and array!
        //  both references point to the same object!
        System.out.println("list: " + originalList);                        //  output: list: [one, Second, Third]
        System.out.println("array: " + Arrays.toString(originalArray));     //  output: array: [one, Second, Third]

        //  cannot remove nor add new elements!
        // originalList.remove(0);
        // originalList.add("fourth");

        //  however, we can take advantage of Arrays.asList() to use it's functionalities on an Array;
        originalList.sort(Comparator.naturalOrder());
        System.out.println("array: " + Arrays.toString(originalArray));     //  the array will be sorted;

        //  we can also initialize a list from an array;
        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");
        System.out.println(newList);
        //  it will still be non-resizeable!
        // newList.add("Wednesday");



        //  List.of()
        //  will return a List<String> from an array;
        //  but it will be both non-resizeable and immutable!
        var listOne = List.of("Sunday", "Monday", "Tuesday");

        String[] daysArray = new String[] {"Sunday", "Monday", "Tuesday"};
        List<String> listTwo = List.of(daysArray);

        //  immutable!
        listOne.set(0, "Saturday");

    }

}
