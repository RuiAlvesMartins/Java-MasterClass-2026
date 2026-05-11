package section15.Sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import section15.Sets.Contacts.Contact;
import section15.Sets.Contacts.ContactData;

public class TreeSetMain {
    
    //  TREESET
    //  TreeSet has several built-in functionalities that can be advantageous compared to HashSet;
    //  But it pays for it with lower performance;

    //  It is a potential alternative to ArrayList in some cases;

    public static void main(String[] args) {
    
        String input1 = """
                Charlie Brown, 3334445555
                Maid Marion, 1234567890
                Mickey Mouse, 9998887777
                Mickey Mouse, 1247489758
                Minnie Mouse, 4567805666
                Robin Hood, 5647893000
                Robin Hood, 7899028222
                Lucy Van Pelt, 5642086852
                Mickey Mouse, 9998887777
                """;

        String input2 = """
                Mickey Mouse, mckmouse@gmail.com
                Mickey Mouse, micky1@aws.com
                Minnie Mouse, minnie@verizon.net
                Robin Hood, rhood@gmail.com
                Linus Van Pelt, lpvelt2015@gmail.com
                Daffy Duck, daffy@google.com
                """;

        List<Contact> phonesList = ContactData.getData(input1);
        List<Contact> emailsList = ContactData.getData(input2);



        //  TREESET

        //  Runtime ERROR: elements passed to TreeSet must implement Comparable!
        // NavigableSet<Contact> sorted = new TreeSet<>(phonesList);
        //  Or else pass a Comparator;
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phonesList);
        sorted.forEach(System.out::println);

        //  String implements Comparable, it can be passed without issue;
        NavigableSet<String> justNames = new TreeSet<>();
        phonesList.forEach(c -> justNames.add(c.getName()));
        System.out.println(justNames);

        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emailsList);
        fullSet.forEach(System.out::println); 

        List<Contact> fullList = new ArrayList<>(phonesList);
        fullList.addAll(emailsList);
        //  You can call the .comparator() on a NavigableSet and sort a List!
        fullList.sort(sorted.comparator());
        System.out.println("_".repeat(30));
        fullList.forEach(System.out::println);

        //  Compile ERROR!
        //  Contact must implement Comparable for .min() and .max() to work;
        // Contact min = Collections.min(fullSet);
        // Contact max = Collections.max(fullSet);
        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());

        //  .first() returns the first element in the set;
        Contact first = fullSet.first();
        //  .last() returns the last element in the set;
        Contact last = fullSet.last();

        System.out.println("_".repeat(30));
        System.out.printf("min = %s, first=%s %n", min.getName(), first.getName());
        System.out.printf("max = %s, last=%s %n", max.getName(), last.getName());
        System.out.println("_".repeat(30));

        //  .pollFirst() and .pollLast() have similar function, but they also REMOVE the element from the set!
        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("First element = " + copiedSet.pollFirst());
        System.out.println("Last element = " + copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        System.out.println("_".repeat(30));

        //  Closest match methods;

        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        for (Contact c : List.of(daffy, daisy, last, snoopy)) {
            //  .ceiling()
            //  returns the smalest element in the set, greater or equal than match value argument;
            System.out.printf("ceiling(%s)=%s%n", c.getName(), fullSet.ceiling(c));
            //  .higher()
            //  returns the smalest element in the set, greater than match value argument;
            System.out.printf("higher(%s)=%s%n", c.getName(), fullSet.higher(c));
        }
        System.out.println("_".repeat(30));

        for (Contact c : List.of(daffy, daisy, first, archie)) {
            //  .floor()
            //  returns the highest element in the set, smaller or equal than match value argument;
            System.out.printf("floor(%s)=%s%n", c.getName(), fullSet.floor(c));
            //  .lower()
            //  returns the highest element in the set, smaller than match value argument;
            System.out.printf("lower(%s)=%s%n", c.getName(), fullSet.lower(c));
        }
        System.out.println("_".repeat(30));

        //  Reversing order;

        //  .descendingSet()
        //  returns a reversed order of the set;
        NavigableSet<Contact> descendingSet = fullSet.descendingSet();
        descendingSet.forEach(System.out::println);
        System.out.println("_".repeat(30));

        Contact lastContact = descendingSet.pollLast();
        System.out.println("Removed " + lastContact);
        descendingSet.forEach(System.out::println);
        System.out.println("_".repeat(30));
        //  .descendingSet() has the original set backing it up, so changes made on one will be reflected on the other!
        fullSet.forEach(System.out::println);
        System.out.println("_".repeat(30));

        //  Subset methods;

        //  .headSet()
        //  returns all elements that are less than the match value argument;
        //  exclusive by default (can ommit the boolean argument);
        Contact marion = new Contact("Maid Marion");
        var headSet = fullSet.headSet(marion);
        // var headSet = fullSet.headSet(marion, false);
        headSet.forEach(System.out::println);
        System.out.println("_".repeat(30));

        //  .tailSet()
        //  returns all elements that are greater than the match value argument;
        //  inclusive by default (can ommit the boolean argument);
        var tailSet = fullSet.tailSet(marion);
        // var tailSet = fullSet.tailSet(marion, true);
        tailSet.forEach(System.out::println);
        System.out.println("_".repeat(30));

        //  .subSet()
        //  returns a subset ranging from 1st arg (inclusive) to 2nd arg (exclusive);
        Contact linus = new Contact("Linus Van Pelt");
        var subset = fullSet.subSet(linus, marion);
        // var subset = fullSet.subSet(linus, false, marion, true);
        subset.forEach(System.out::println);
        
    }

}
