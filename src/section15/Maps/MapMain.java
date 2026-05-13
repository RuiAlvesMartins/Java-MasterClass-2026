package section15.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import section15.Sets.Contacts.Contact;
import section15.Sets.Contacts.ContactData;

public class MapMain {
    
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

        List<Contact> phones = ContactData.getData(input1);
        List<Contact> emails = ContactData.getData(input2);

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-".repeat(30));



        //  Map Interface Methods

        Map<String, Contact> contacts = new HashMap<>();
        //  .put(k, v)
        //  inserts a key-value pair;
        //  returns the previous value associated with the key;
        //  unlike lists and sets, not method exists for adding a group of elements to a map at once;
        for (Contact c : fullList) {
            contacts.put(c.getName(), c);            
        }
        //  Maps cannot hold DUPLICATE keys!
        //  .put() always adds the key value pair!
        //  If key already exists, the existing associated value is SWAPPED for the new one!
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));
        //  e.g. from all the Mickey Mouse contacts, the last one gets stored as the final value;

        //  .get(k)
        //  allows for retrival of a value associated with the provided key;
        System.out.println("-".repeat(30));
        System.out.println(contacts.get("Charlie Brown"));
        //  returns null if value is null, or key is not found;
        System.out.println(contacts.get("Chuck Brown"));

        //  .getOrDefault(k, v)
        //  returns a default value if the provided key was not found; 
        Contact defaultContact = new Contact("Chuck Brown");
        System.out.println(contacts.getOrDefault("Chuck Brown", defaultContact));

        System.out.println("-".repeat(30));
        //  .clear()
        //  removes all pairs from the map;
        contacts.clear();
        for (Contact contact : fullList) {
            //  Remember! .put(k, v) returns previous v!
            //  this makes merging values a lot easier!
            Contact duplicate = contacts.put(contact.getName(), contact);
            if (duplicate != null) {
                // System.out.println("duplicate = " + duplicate);
                // System.out.println("current = " + contact);

                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

        //  .putIfAbsent(k, v)
        //  if the provided key is not mapped to any value (or to null), it is mapped to the provided value, and returns null;
        //  else returns current value;
        System.out.println("-".repeat(30));
        contacts.clear();
        for (Contact c : fullList) {
            contacts.putIfAbsent(c.getName(), c);            
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

        System.out.println("-".repeat(30));
        contacts.clear();
        //  .putIfAbsent() can also be useful for merging values;
        for (Contact c : fullList) {
            Contact duplicate = contacts.putIfAbsent(c.getName(), c);     
            if (duplicate != null) {
                contacts.put(c.getName(), c.mergeContactData(duplicate));
            }     
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

        //   .merge(k, v, biFunction)     
        System.out.println("-".repeat(30));
        contacts.clear();
        fullList.forEach(c -> contacts.merge(c.getName(), c,
            //  this could also be replaced by a method reference:
            // Contact::mergeContactData 
            (previous, current) -> {
                // System.out.println("prev: " + previous + " : current " + current);
                Contact merged = previous.mergeContactData(current);
                // System.out.println("merged: " + merged);
                return merged;
            }
        ));
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));



        //  Compute methods

        //  .compute(k, biFunction)
        //  attempts to compute a mapping with biFunction, for the given key;
        //  overwrites existing values;
        System.out.println("-".repeat(30));
        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
            contacts.compute(contactName, (k, v) -> new Contact(k));
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

        //  .computeIfAbsent(k, Function)
        //  attempts to compute a mapping with biFunction, for the given key;
        //  does NOT overwrite existing values;
        System.out.println("-".repeat(30));
        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
            contacts.computeIfAbsent(contactName, k -> new Contact(k));
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

        //  .computeIfPresent(k, biFunction)
        //  attempts to compute a mapping with biFunction, for the given key;
        //  only if the value is NON NULL!
        //  overwrites existing values;
        System.out.println("-".repeat(30));
        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
            contacts.computeIfPresent(contactName, (k, v) -> {
                v.addEmail("Fun Place");
                return v;
            });
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));



        //  Replace methods

        //  .replaceAll(biFunction)
        //  replaces all entries with the result of biFunction;
        System.out.println("-".repeat(30));
        contacts.replaceAll((k, v) -> {
            String newEmail = k.replaceAll(" ", "") + "@funplace.com";
            v.replaceEmailIfExists("DDuck@funplace.com", newEmail);
            return v;
        });
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

        //  .replace(k, v)
        //  replaces the value for the provided key, if no value was previously mapped (or a null);
        //  returns previous value, or null;
        System.out.println("-".repeat(30));
        Contact daisy = new Contact("Daisy Jane Duck", "daisyj@duck.com");
        Contact replacedContact = contacts.replace("Daisy Duck", daisy);
        System.out.println("daisy = " + daisy);
        System.out.println("replacedContact = " + replacedContact);
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

        //  .replace(k, old v, new v)
        //  replaces the old value for the new value on the provided key;
        //  returns boolean;
        System.out.println("-".repeat(30));
        Contact updatedDaisy = replacedContact.mergeContactData(daisy);
        System.out.println("updatedDaisy = " + updatedDaisy);
        boolean success = contacts.replace("Daisy Duck", replacedContact, updatedDaisy);
        if (success) {
            System.out.println("Successfully replaced element");
        }
        else {
            System.out.printf("Did not match on both key: %s and value: %s %n", "Daisy Duck", replacedContact);
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));



        //  Remove methods

        //  .remove(k, v)
        //  removes key-value pair only if value matches key; 
        //  and if the key is found;
        //  returns boolean;
        System.out.println("-".repeat(30));
        success = contacts.remove("Daisy Duck", daisy);
        if (success) {
            System.out.println("Successfully removed element");
        }
        else {
            System.out.printf("Did not match on both key: %s and value: %s %n", "Daisy Duck", daisy);
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

        //  .remove(k)
        //  removes the value for the provided key;
        //  returns the previous value, or otherwise null;

    }

}
