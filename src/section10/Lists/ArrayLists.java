package section10.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//  POJO created to be used as example in a grocery list;
record GroceryItem(String name, String type, int count) {

    //  besides this constructor, we will need the default constructor too;
    //  but RECORD doesn't disable it when a constructor is declared explicitly, so it still works;
    public GroceryItem(String name) {
        this(name, "DAIRY", 1);
    }

    //  review section7 for doubts on OVERRIDING and POJOs
    @Override
    public String toString() {
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }

}

public class ArrayLists {
    
    //  ARRAYLIST
    //  Implements LIST;
    //  https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html

    //  ArrayList maintains in memory a (in most cases) bigger Array than actually needed;
    //  It keeps track of the capacity, i.e., size of Array in memory;
    //  It keeps track of the elements assigned to the ArrayList;
    //  It creates a new bigger Array in memory in case ArrayList needs to grow;
    //  All this happens behind the scenes;
    //  An ArrayList is essentially a RESIZABLE Array;

    public static void main(String[] args) {
        
        //  Object[] is bad practice because there is no compile-time type checking;
        //  It is used here for educational purposes;
        Object[] groceryArray = new Object[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryArray[2] = "5 oranges";
        System.out.println(Arrays.toString(groceryArray));

        //  This is how you are supposed to do it;
        GroceryItem[] groceryArrayTwo = new GroceryItem[3];
        groceryArrayTwo[0] = new GroceryItem("milk");
        groceryArrayTwo[1] = new GroceryItem("apples", "PRODUCE", 6);
        //  Now you cannot pass a String, you must pass a GroceryItem!
        groceryArrayTwo[2] = new GroceryItem("oranges", "PRODUCE", 5);
        System.out.println(Arrays.toString(groceryArrayTwo));   



        System.out.println();
        System.out.println("###   ###   ###");
        System.out.println();

        //  RAW TYPE
        //  References to ArrayList<E> should be parameterized;
        //  i.e. you should define of what data type you want your list to be;
        //  otherwise it will be set to the default Object;
        //  and that is the bad practice discussed above!
        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");


        ArrayList<GroceryItem> groceryList = new ArrayList<GroceryItem>();
        //  It may also be initialized with the DIAMOND OPERATOR;
        // ArrayList<GroceryItem> groceryList = new ArrayList<>();
        //  You may also initialize an ArrayList with a defined CAPACITY;
        // ArrayList<GroceryItem> groceryList = new ArrayList<>(10);


        groceryList.add(new GroceryItem("Butter"));
        //  now you can't pass Strings;
        groceryList.add(new GroceryItem("Yogurt"));
        //  .add(element)
        groceryList.add(new GroceryItem("Milk"));
        groceryList.add(new GroceryItem("Oranges", "PRODUCE", 5));
        //  .add(index, element)
        //  this will move the sitting element, not overwrite it!
        groceryList.add(0, new GroceryItem("Apples", "PRODUCE", 6));
        //  you can PRINT an ArrayList directly from sout!
        System.out.println(groceryList);
        //  .remove()
        groceryList.remove(3);
        System.out.println(groceryList);



        //  POPULATING ARRAYLISTS
        //  refer to Lists.java

        //  new ArrayList<> (List.of(Array));
        ArrayList<GroceryItem> newList = new ArrayList<>(
            List.of(
                new GroceryItem("pickles", "GROCERIES", 2),
                new GroceryItem("mustard", "GROCERIES", 1),
                new GroceryItem("Cheese"))
        );
        System.out.println(newList);

        //  .addAll()
        //  adds all elements of an ArrayList to another ArrayList;
        groceryList.addAll(newList);
        System.out.println(groceryList);

        //  .get(index)
        System.out.println("Third item = " + groceryList.get(2));

        for (GroceryItem item : groceryList) {
            if (item.name().equals("mustard")) {
                System.out.println("List contains mustard");
            }
        }



        System.out.println();
        System.out.println("###   ###   ###");
        System.out.println();

        String[] items = {"apples", "bananas", "milk", "eggs"};
        List<String> list = List.of(items);

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");

        ArrayList<String> nextList = new ArrayList<>(
            List.of("pickles", "mustard", "cheese")
        );

        //  .addAll()
        //  adds all elements of an ArrayList to another ArrayList;
        groceries.addAll(nextList);
        System.out.println(groceries);

        //  .get(index)
        System.out.println("Third item = " + groceries.get(2));

        //  .contains()
        if (groceries.contains("mustard")) {
            System.out.println("List contains mustard");
        }

        groceries.add("yoghurt");
        //  .indexOf()
        //  returns first index found;
        System.out.println("first = " + groceries.indexOf("yoghurt"));
        //  .lastIndexOf()
        //  returns last index found;
        System.out.println("last = " + groceries.lastIndexOf("yoghurt"));

        System.out.println(groceries);
        //  .remove(index)
        groceries.remove(1);
        System.out.println(groceries);
        //  .remove(element)
        //  removes the FIRST element found; 
        //  only ONE element is removed;
        groceries.remove("yoghurt");
        System.out.println(groceries);

        groceries.add("apples");
        System.out.println(groceries);
        //  .removeAll(List)
        //  removes ALL elements found;
        //  can remove MULTIPLE elements;
        //  must pass a Collection<?> as argument;
        groceries.removeAll(List.of("apples", "eggs"));
        System.out.println(groceries);

        //  .retainAll(List)
        //  removes all elements not found in argument list;
        //  must pass a Collection<?> as argument;
        groceries.retainAll(List.of("apples", "milk", "mustard", "cheese"));
        System.out.println(groceries);

        //  .clear()
        //  removes all elements;
        groceries.clear();
        System.out.println(groceries);
        //  .isEmpty()
        //  retruns TRUE if list has no elements;
        System.out.println("isEmpty = " + groceries.isEmpty());

        //  .addAll(Collection<?>)
        groceries.addAll(List.of("apples", "milk", "mustard", "cheese"));
        //  Arrays.asList(String...)
        //  returns a List<String>
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));

        System.out.println(groceries);
        //  .sort() 
        //  a Comparator instance is needed;    
        //  .naturalOrder() is a static factory method of Comparator;
        //  Comparator.naturalOrder() allows data types with a natural order to be sorted ascendingly/alphabetically;
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);

        //  Comparator.reverseOrder() allows data types with a natural order to be sorted descendingly/ZtoA;
        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);

        //  ArrayList.toArray(String[])
        //  returns a String[] from an ArrayList;
        var groceriesArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceriesArray));

        //  .size()
        System.out.println("Items on groceries list = " + groceries.size());



        //  MULTIDIMENSIONAL ARRAYLIST
        ArrayList<ArrayList<String>> multiDimensionalList = new ArrayList<>();
        System.out.println(multiDimensionalList);

    }

}
