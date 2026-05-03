package section15.Sets.Contacts;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    
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

        List<Contact> phonesList = ContactData.getData(input1);
        List<Contact> emailsList = ContactData.getData(input2);

        //  This is my attempt at parsing and merging this data 
        //  It works but is inefficient, because it makes no use of hashing, nor sets;
        printData("Phones List", phonesList);
        printData("Emails List", emailsList);
        printData("Phones List No Duplicates", ContactData.mergeContactData(phonesList));
        printData("Emails List No Duplicates", ContactData.mergeContactData(emailsList));
        printData("Data Merged", ContactData.mergeContactData(phonesList, emailsList));

        //  How Tim Buchalka does it:
        Set<Contact> phoneContacts = new HashSet<>(phonesList);
        Set<Contact> emailContacts = new HashSet<>(emailsList);
        //  Despite being assigned to a set, there are still duplicate names;
        //  This is because the other fields of the contact class are different;
        printData("Phone Contacts", phoneContacts);
        printData("Email Contacts", emailContacts);

        int index = emailsList.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emailsList.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists("RHood@sherwoodforest.com", "RHood@sherwoodforest.org");
        System.out.println(robinHood);

        //  UNION of SETS with .addALL()
        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("(A \u222A B) Union of emails(A) with phones (B)", unionAB);

        //  INTERSECTION of SETS with .retainAll()
        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
        printData("(A \u2229 B) Intersect of emails (A) and phones (B)", intersectAB);

        Set<Contact> intersectBA = new HashSet<>(phoneContacts);
        intersectBA.retainAll(emailContacts);
        printData("(B \u2229 A) Intersect of phones (B) and emails (A)", intersectBA);

        //  DIFFERENCE of SETS with .removeAll()
        //  Beware: this is an asymmetric operation!
        Set<Contact> AminusB = new HashSet<>(emailContacts);
        AminusB.removeAll(phoneContacts);
        printData("(A - B) emails (A) - phones (B)", AminusB);

        Set<Contact> BminusA = new HashSet<>(phoneContacts);
        BminusA.removeAll(emailContacts);
        printData("(B - A) phones (B) - emails (A)", BminusA);

        //  SYMMETRIC DIFFERENCE of SETS with .addAll()
        Set<Contact> symmetricDiff = new HashSet<>(AminusB);
        symmetricDiff.addAll(BminusA);
        printData("Symmetric Difference: phones and emails", symmetricDiff);

        //  SYMMETRIC DIFFERENCE of SETS with .removeAll()
        Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
        symmetricDiff2.removeAll(intersectAB);
        printData("Symmetric Difference: phones and emails", symmetricDiff2);

    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("-".repeat(30));
        System.out.println(header);
        System.out.println("-".repeat(30));
        contacts.forEach(System.out::println);
    }


}
