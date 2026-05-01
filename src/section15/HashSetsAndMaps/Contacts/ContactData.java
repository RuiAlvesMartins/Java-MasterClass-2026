package section15.HashSetsAndMaps.Contacts;

import java.util.ArrayList;
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

}
