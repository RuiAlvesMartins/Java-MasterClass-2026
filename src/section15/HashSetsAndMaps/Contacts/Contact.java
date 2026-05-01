package section15.HashSetsAndMaps.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Contact {
    
    //  FIELDS
    String name;
    Set<String> emails = new HashSet<>();
    Set<String> phones = new HashSet<>();



    //  CONSTRUCTORS
    public Contact(String name, String email, long phone) {
        if (!(name == null)) {
            this.name = name;    
        }
        if (!(email == null)) {
            this.emails.add(email);    
        }
        if (phone < 10_000_000_000l && phone > 999_999_999l) {
            Long firstLong = phone/10_000_000l;
            // System.out.println("firstLong = " + firstLong);
            Long secondLong = (phone - firstLong*10_000_000l)/10_000l;
            // System.out.println("secondLong = " + secondLong);
            Long thirdLong = (phone - firstLong*10_000_000l - secondLong*10_000l);
            // System.out.println("third long = " + thirdLong);
            String phoneNumber = String.format("(%d) %d-%d", firstLong, secondLong, thirdLong);
            this.phones.add(phoneNumber);
        }
        
    }

    public Contact(String name, String email) {
        this(name, email, 0l);
    }

    public Contact(String name, long phone) {
        this(name, null, phone);
    }

    public Contact(String name) {
        this(name, null, 0l);
    }

    

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String emails = "";
        for (String email : this.emails) {
            emails = String.format("%s %s; ", emails, email).trim();
        }
        String phones = "";
        for (String phone : this.phones) {
            phones = String.format("%s %s; ", phones, phone).trim();
        }
        emails = emails.length() > 1 ? emails.substring(0, emails.length() - 1) : "";
        phones = phones.length() > 1 ? phones.substring(0, phones.length() - 1) : "";
        String contact = String.format("%-20s | Email: %-40s | Phone: %-40s", name, emails, phones);
        return contact;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Contact that = (Contact) obj;

        if (!emails.equals(that.emails)) return false;
        return phones.equals(that.phones);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + emails.hashCode();
        result = 31 * result + phones.hashCode();
        return result;
    }



    public void mergeContactData(Contact contact) {
        if (this.name.equals(contact.getName())) {
            for (String email : contact.emails) {
                this.emails.add(email);
            }
            for (String phone : contact.phones) {
                this.phones.add(phone);
            }
        }
    }



    public static void main(String[] args) {
        
        Contact johnDoe = new Contact("John Doe", 123_456_7890l);

        johnDoe.phones.add("(321)654-0987");

        // System.out.println(johnDoe);

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
        List<Contact> contactsList = ContactData.getData(input1);
        contactsList.addAll(ContactData.getData(input2));
        int i = 1;
        for (Contact contact : contactsList) {
            for (Contact c : contactsList) {
                contact.mergeContactData(c);
            }

            // System.out.println(String.format("%2s# %12s | %s", i++, contact.hashCode(), contact));
        }

        //  removing duplicates;
        contactsList = new ArrayList<>(new LinkedHashSet<>(contactsList));
        System.out.println(contactsList.getClass());

        for (Contact contact : contactsList) {
            System.out.println(String.format("%2s# %12s | %s", i++, contact.hashCode(), contact));
        }

    }

}
