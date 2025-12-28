package section10.Challenges.MobilePhone;

public class Main {

    public static void main(String[] args) {
        
        MobilePhone nokia = new MobilePhone("999 999 999");

        Contact johnDoe = Contact.createContact("John Doe", "888 888 888");
        Contact janeSmith = Contact.createContact("Jane Smith", "777 777 777");
        Contact bobJohnson = Contact.createContact("Bob Johnson", "666 666 666");
        Contact billMiller = Contact.createContact("Bill Miller", "555 555 555");
        Contact aliceBaker = Contact.createContact("Alice Baker", "444 444 444");
        Contact charlieDavis = Contact.createContact("Charlie Davis", "333 333 333");
        Contact deborahEvans = Contact.createContact("Deborah Evans", "222 222 222");
        Contact frankGreen = Contact.createContact("Frank Green", "111 111 111");

        nokia.addNewContact(johnDoe);
        nokia.addNewContact(johnDoe);

        nokia.addNewContact(janeSmith);
        nokia.addNewContact(bobJohnson);
        nokia.addNewContact(billMiller);
        nokia.addNewContact(aliceBaker);
        nokia.addNewContact(charlieDavis);
        nokia.addNewContact(deborahEvans);
        nokia.addNewContact(frankGreen);
        nokia.printContacts();

        // System.out.println(nokia.findContact(deborahEvans);
        // System.out.println(nokia.findContact("Deborah Evans"));
        nokia.addNewContact(deborahEvans);
        nokia.removeContact(deborahEvans);
        nokia.removeContact(deborahEvans);
        // System.out.println(nokia.findContact(deborahEvans));
        // System.out.println(nokia.findContact("Deborah Evans"));
        nokia.printContacts();

        System.out.println(nokia.queryContact("Bob Johnson"));
        System.out.println(nokia.queryContact("Deborah Evans"));


        Contact satanBeelz = Contact.createContact("Satan Beelzebub", "666 666 666");
        nokia.updateContact(bobJohnson, satanBeelz);
        nokia.updateContact(deborahEvans, satanBeelz);

    }

}
