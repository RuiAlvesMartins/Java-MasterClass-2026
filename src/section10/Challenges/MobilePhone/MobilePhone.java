package section10.Challenges.MobilePhone;

import java.util.ArrayList;

public class MobilePhone {
    
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        //  true if contact doesn't exist;
        int index = findContact(contact.getName());

        if (index >= 0) {
            System.out.println(contact.getName() + " is already on contacts list!");
            return false;
        }

        myContacts.add(contact);
        System.out.println(contact.getName() + " has been added");
        return true;

    }

    public boolean updateContact(Contact outdated, Contact updated) {
        //  true if contact exists and is updated successfully;
        int index = findContact(outdated);

        if (index >= 0) {
            
            if (findContact(updated.getName()) != -1) {
                System.out.println(updated.getName() + " is already on contacts list!");
                System.out.println("Update unsuccessful");
                return false;
            }

            myContacts.set(index, updated);
            System.out.println(updated.getName() + " successfully updated");
            return true;

        }

        System.out.println(outdated.getName() + " not found on contacts list!");
        System.out.println("Update unsuccessful");
        return false;
    }

    public boolean removeContact(Contact contact) {
        //  true if contact exists and is removed successfully;
        int index = findContact(contact.getName());

        if (index >= 0) {
            myContacts.remove(index);
            System.out.println(contact.getName() + " has been removed");
            return true;
        }

        System.out.println(contact.getName() + " not found on contacts list!");
        return false;
    }

    private int findContact(Contact key) {
        //  -1 if doesn't exist;
        for (Contact contact : myContacts) {
            if (contact.getName().equals(key.getName())) {
                return myContacts.indexOf(contact);
            }
        }

        return -1;

    }

    private int findContact(String key) {
        //  -1 if doesn't exist;
        for (Contact contact : myContacts) {
            if (contact.getName().equals(key)) {
                return myContacts.indexOf(contact);
            }
        }

        return -1;

    }

    public Contact queryContact(String key) {
        //  null if nothing is found;
        int index = findContact(key);
        if (index >= 0) {
            return myContacts.get(index);    
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(
                (myContacts.indexOf(contact) + 1) + ". " +
                contact.getName() + " -> " + 
                contact.getPhoneNumber()
            );
        }
    }

}
