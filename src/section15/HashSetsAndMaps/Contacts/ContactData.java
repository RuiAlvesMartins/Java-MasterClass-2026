package section15.HashSetsAndMaps.Contacts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ContactData {
    
    // private static Scanner consoleScan = new Scanner(System.in);

    public static List<Contact> getData(String contactData) {

        List<Contact> contacts = new ArrayList<>();

        //  \\s* trims extra spaces;
        //  \\R divides elements by line break;
        Scanner inputScan = new Scanner(contactData).useDelimiter("\\s*\\R\\s*");

        while (inputScan.hasNext()) {
            String[] output = inputScan.next().split(",");

            String name = output[0].trim();
            String email = "";
            String phone = ""; 

            for(int i=1; i<output.length; i++) {
                int digitCount = 0;

                for (int j=0; j<output[i].length(); j++) {
                    if (Character.isDigit(output[i].charAt(j))) {
                        digitCount++;
                    }
                    if (output[i].charAt(j) == '@') {
                        email = output[i].trim();
                    }
                }

                if (digitCount == 10) {
                    phone = output[i].trim();
                }

            }

            if (!name.isBlank()) {
                Contact c;
                if (email.isEmpty() && phone.isEmpty()) {
                    c = new Contact(name);
                } 
                else if (email.isEmpty()) {
                    c = new Contact(name, Long.parseLong(phone));
                }
                else if (phone.isEmpty()) {
                    c = new Contact(name, email);
                }
                else {
                    c = new Contact(name, email, Long.parseLong(phone));
                }
                contacts.add(c);
            }
        }
        inputScan.close();
        return contacts;

    }

    public static List<Contact> mergeContactData(List<Contact> contacts) {
        List<Contact> mergedContacts = new ArrayList<>();
        List<Contact> duplicates = new ArrayList<>();

        //  populates a list of contacts with unique names;
        //  populates a list of contacts with duplicate names;
        for (Contact c1 : contacts) {
            Boolean isDuplicate = false;
            for (Contact c2 : mergedContacts) {
                if (c1.getName().equals(c2.getName())) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                duplicates.add(c1);
            } 
            else {
                mergedContacts.add(c1);
            }
        }

        // ContactData.printData("uniques", mergedContacts);
        // ContactData.printData("duplicates", duplicates);

        //  updates mergedContacts with data from duplicates;
        for(int i=0; i<mergedContacts.size(); i++) {
            Contact unique = mergedContacts.get(i);
            for(int j=0; j<duplicates.size(); j++) {
                Contact duplicate = duplicates.get(j);
                if (duplicate.getName().equals(unique.getName())) {
                    // mergedContacts.set(i, unique.mergeContactData(duplicate));
                    unique = unique.mergeContactData(duplicate);
                }
            }
            mergedContacts.set(i, unique);
        }

        // ContactData.printData("merged", mergedContacts);

        return mergedContacts;
    }

    public static List<Contact> mergeContactData(List<Contact> list1, List<Contact> list2) {

        //  removes duplicates from list1;
        List<Contact> mergedList = new ArrayList<>(ContactData.mergeContactData(list1));

        //  merges list1 with list2;
        //  list2 may have duplicates;
        for(int i=0; i<list2.size(); i++) {
            Contact c2 = list2.get(i); 
            boolean isDuplicate = false;
            for(int j=0; j<mergedList.size(); j++) {
                Contact c1 = mergedList.get(j);
                if (c2.getName().equals(c1.getName())) {
                    mergedList.set(j, c1.mergeContactData(c2));
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                mergedList.add(c2);
            }
        }

        return mergedList;
    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("-".repeat(30));
        System.out.println(header);
        System.out.println("-".repeat(30));
        contacts.forEach(System.out::println);
    }



    public static void main(String[] args) {
        
        Contact johnDoe = new Contact("John Doe", 123_456_7890l);
        johnDoe.phones.add("(321)654-0987");
        System.out.println(johnDoe);

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

        System.out.println();
        List<Contact> phonesList = ContactData.getData(input1);
        List<Contact> emailsList = ContactData.getData(input2);

        ContactData.printData("Phones List", phonesList);
        ContactData.printData("Emails List", emailsList);
        ContactData.printData("Phones List No Duplicates", ContactData.mergeContactData(phonesList));
        ContactData.printData("Emails List No Duplicates", ContactData.mergeContactData(emailsList));
        ContactData.printData("Data Merged", ContactData.mergeContactData(phonesList, emailsList));

    }


}
