package section15.Maps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import section15.Sets.Contacts.Contact;
import section15.Sets.Contacts.ContactData;

public class MapViewsMain {
    
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

        // List<Contact> phones = ContactData.getData(input1);
        // List<Contact> emails = ContactData.getData(input2);

        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData(input1).forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData(input2).forEach(c -> contacts.put(c.getName(), c));



        //  VIEW Collections for Maps:
        //          Map.keySet()
        //          Map.values()
        //          Map.entrySet()



        //  Map.keySet()
        //  returns a Set<T> (view) with the maps keys;
        //  the view is backed up by the map (changes in one relfect on the other);
        Set<String> keysView = contacts.keySet();
        //  output is not ordered because set is not ordered;
        System.out.println(keysView);

        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        //  output is ordered because treeSet is ordered;
        System.out.println(copyOfKeys);

        //  Map.containsKey()
        //  returns true if key found;
        if (contacts.containsKey("Linus Van Pelt")) {
            System.out.println("Linus and I go way back, so of course I have info");
        }

        //  Map.remove()
        //  removes kv pair if the provided key is found;
        //  returns boolean;
        keysView.remove("Daffy Duck");
        System.out.println(keysView);
        //  keysView is the product of Map.keySet();
        //  it is backed by the Map (contacts);
        //  changes on one affect the other!
        contacts.forEach((k, v) -> System.out.println(v));

        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(copyOfKeys);
        //  copyOfKeys is a TreeSet copy of the product of Map.keySet();
        //  it is NOT backed by the Map (contacts);
        //  changes on copyOfKeys do NOT affect the map!
        contacts.forEach((k, v) -> System.out.println(v));

        //  Set.retainAll()
        //  keeps only the elements provided in the collection arg;
        //  removes all others from the set;
        //  returns true if set has changed;
        keysView.retainAll(List.of("Linus Van Pelt", 
                "Charlie Brown", "Robin Hood", "Mickey Mouse"));
        System.out.println(keysView);
        //  contacts (map) will be affected by changes in keysView (view) !
        contacts.forEach((k, v) -> System.out.println(v));

        //  The VIEW returned in Map.keySet() returns a set, but with restricted funcionality: 
        //          supports .remove(), .removeAll(), .retainAll(), .clear()
        //          does not support .add() or .addAll()
        //  If you add a new element to the .keySet() view, it will be added as a new key on the map backing it;
        //  And it makes no sense to add a key without adding a value!   



        //  Set.clear()
        keysView.clear();
        System.out.println(contacts);
        // keysView.add("Daffy Duck");                                 //  runtime error!
        //  UnsupportedOperationException!
        // System.out.println(contacts);

        ContactData.getData(input1).forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData(input2).forEach(c -> contacts.put(c.getName(), c));
        //  Changes on the map are reflected on the view!
        System.out.println(keysView);



        //  Map.values()
        //  returns a Collection<T> (view) with the values;
        //  the view is backed up by the map (changes in one relfect on the other);
        var values = contacts.values();
        values.forEach(System.out::println);

        //  Collection.retainAll()
        System.out.println("_".repeat(60));
        values.retainAll(ContactData.getData(input2));
        //  changes in view (values) affect backing map (contacts);
        //  changes in backing map affect view (keysView);
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

        System.out.println("_".repeat(60));
        List<Contact> list = new ArrayList<>(values);
        // list.sort(Comparator.comparing(c -> c.getNameLastFirst()));
        list.sort(Comparator.comparing(Contact::getNameLastFirst));
        list.forEach(c -> System.out.println(c.getNameLastFirst() + ": " + c));

        System.out.println("_".repeat(60));
        //  Contact first = "Daffy Duck"
        Contact first = list.get(0);
        //  k="Duck, Daffy" v=first
        contacts.put(first.getNameLastFirst(), first);
        //  this will print 2 equal contacts, because the keys are different:
        //          "Daffy Duck" != "Duck, Daffy"
        values.forEach(System.out::println);
        keysView.forEach(System.out::println);

        //  the new hashSet will be a copy of values, but without duplicates;
        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);
        if (set.size() < contacts.keySet().size()) {
            System.out.println("Duplicate Values are in my Map!");
        }



        //  Map.entrySet()
        //  returns a set (view) of k-v pairs (Map.Entry(K, V));
        //  in other words, returns a set with all the k-v pairs as elements; 
        //  the view is backed up by the map (changes in one relfect on the other);
        System.out.println("_".repeat(60));
        var nodeSet = contacts.entrySet();
        System.out.println(nodeSet.getClass().getName());           //  java.util.HashMap$EntrySet
        for (var node : nodeSet) {
            if (!node.getKey().equals(node.getValue().getName())) {
                System.out.println("Key doesn't match name: " + 
                        node.getKey() + ": " +
                        node.getValue()
                );
                System.out.println(node.getClass().getName());      //  java.util.HashMap$Node
            }
        }

    }

}
