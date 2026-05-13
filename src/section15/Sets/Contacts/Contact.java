package section15.Sets.Contacts;

import java.util.HashSet;
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

    public String getNameLastFirst() {
        return name.substring(name.indexOf(" ") +1)
                + ", "
                + name.substring(0, name.indexOf(" "));
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

    // //  an alternative .equals()
    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj) return true;
    //     if (obj == null || getClass() != obj.getClass()) return false;

    //     //  Since obj has been confirmed to be of type Contact and not be null;
    //     //  it can safely be cast to Contact;
    //     Contact that = (Contact) obj;

    //     return this.getName().equals(that.getName()) && 
    //         Objects.equals(this.emails, that.emails) && 
    //         Objects.equals(this.phones, that.phones);
    // }

    // //  an alternative .hashCode()
    // @Override
    // public int hashCode() {
    //     //  Objects is a CLASS with auxiliary methods, like Collections;
    //     return Objects.hash(this.getName(), this.emails, this.phones);
    // }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        //  Since obj has been confirmed to be of type Contact and not be null;
        //  it can safely be cast to Contact;
        Contact that = (Contact) obj;

        return this.getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return 33 * this.getName().hashCode();
    }



    public void addEmail(String companyName) {

        String[] names = name.split(" ");
        String email = "%c%s@%s.com".formatted(name.charAt(0), names[names.length-1], companyName.replaceAll(" ", "").toLowerCase());
        if (!emails.add(email)) {
            System.out.println(name + " already has " + email + " as an email!");
        } else {
            System.out.println(name + " now has " + email + " as an email.");
        }

    }

    public void replaceEmailIfExists(String oldEmail, String newEmail) {

        if (emails.contains(oldEmail)) {
            emails.remove(oldEmail);
            emails.add(newEmail);
        }

    }

    public Contact mergeContactData(Contact contact) {
        Contact newContact = new Contact(this.name);
        newContact.emails = new HashSet<>(this.emails);
        newContact.phones = new HashSet<>(this.phones);

        if (newContact.getName().equals(contact.getName())) {
            for (String email : contact.emails) {
                newContact.emails.add(email);
            }
            for (String phone : contact.phones) {
                newContact.phones.add(phone);
            }
        }

        return newContact;
    }

}
