package section10.Challenges;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

record Town(String town, int distFromSydney) {

    public String town() {
        return town;
    }

    public int distFromSydney() {
        return distFromSydney;
    }
    
}

public class TravelItenerary {

    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        LinkedList<Town> travelItenerary = new LinkedList<>();

        Town adelaide = new Town("Adelaide", 1374);
        Town aliceSprings = new Town("Alice Springs", 2771);
        Town brisbane = new Town("Brisbane", 917);
        Town darwin = new Town("Darwin", 3972);
        Town melbourne = new Town("Melbourne", 877);
        Town perth = new Town("Perth", 3923);
        travelItenerary.add(adelaide);
        travelItenerary.add(aliceSprings);
        travelItenerary.add(brisbane);
        travelItenerary.add(darwin);
        travelItenerary.add(melbourne);
        travelItenerary.add(perth);
        System.out.println(travelItenerary);
        //  :: is a Lambda (see section 14)
        travelItenerary.sort(Comparator.comparing(Town::distFromSydney));
        System.out.println(travelItenerary);

        console(travelItenerary);

    }

    private static void console(LinkedList<Town> travelItenerary) {

        // Scanner scanner = new Scanner(System.in);
        String scannerInput;
        String parsedInput;
        var iterator = travelItenerary.listIterator();
        boolean programRunning = true;
        boolean forward = true;
        boolean backward = true;

        System.out.println();
        System.out.println("TRAVEL ITENERARY PROGRAM");
        System.out.println();

        while (programRunning) {

            System.out.println("Available actions (type word or letter):");
            System.out.println("(C)urrent");
            System.out.println("(F)orward");
            System.out.println("(B)ackward");
            System.out.println("(L)ist Places");
            System.out.println("(M)enu");
            System.out.println("(Q)uit");
            System.out.println();

            scannerInput = scanner.nextLine();
            parsedInput = scannerInput.toUpperCase();

            switch (parsedInput) {
                case "C", "CURRENT" -> current(travelItenerary, iterator);
                case "F", "FORWARD" -> {
                    forwards(travelItenerary, iterator, forward);
                    //  handling repeat element when reversing order;
                    forward = true;
                    backward = false;
                }
                case "B", "BACKWARD" -> {
                    backwards(travelItenerary, iterator, backward);
                    //  handling repeat element when reversing order;
                    forward = false;
                    backward = true;
                }
                case "L", "LIST", "LIST PLACES" -> printItenerary(travelItenerary);
                case "M", "MENU" -> menu(travelItenerary);
                case "Q", "QUIT" -> programRunning = false;
                default -> System.out.printf(scannerInput + " is not a valid command!%n%n");
            }

        }

        System.out.println();
        System.out.println("Exiting...");
        System.out.println("END OF PROGRAM");
        System.out.println();

    }

    private static void menu(LinkedList<Town> travelItenerary) {

        String scannerInput;
        String parsedInput;
        var iterator = travelItenerary.listIterator();
        boolean programRunning = true;

        System.out.println();
        System.out.println("MENU");
        System.out.println();

        while (programRunning) {
            System.out.println("Available actions (type word or letter):");
            System.out.println("(A)dd town to itenerary");
            System.out.println("(R)emove town from itenerary");
            System.out.println("(L)ist Places");
            System.out.println("(B)ack");
            System.out.println();

            scannerInput = scanner.nextLine();
            parsedInput = scannerInput.toUpperCase();

            switch (parsedInput) {
                case "A", "ADD" -> add(travelItenerary);
                case "R", "REMOVE" -> remove(travelItenerary);
                case "L", "LIST", "LIST PLACES" -> printItenerary(travelItenerary);
                case "B", "BACK" -> programRunning = false;
                default -> System.out.printf(scannerInput + " is not a valid command!%n%n");
            }

        }

        System.out.println();

    }

    private static void printItenerary(LinkedList<Town> travelItenerary) {

        int index = 1;

        System.out.println();
        System.out.println("Travel Itenerary:");
        System.out.println();

        for (Town town : travelItenerary) {
            System.out.println(index + "th stop: " + town.town() + " --> " + town.distFromSydney() + "km from Sydney");
            index++;
        }

        System.out.println();

    }
    
    private static void current(LinkedList<Town> travelItenerary, ListIterator<Town> iterator) {

        System.out.println();

        if (!iterator.hasPrevious()) {
            System.out.println("Start of Itinerary!");
            System.out.println();
            return;
        }

        Town memory = iterator.previous();

        System.out.println("Currently at: " + memory.town());
        System.out.println(memory.distFromSydney() + "km from Sydney");
        iterator.next();
        System.out.println();

    }

    private static void forwards(LinkedList<Town> travelItenerary, ListIterator<Town> iterator, boolean forward) {

        System.out.println();

        if (!iterator.hasNext()) {
            System.out.println("End of Itinerary!");
            System.out.println();
            return;
        }

        //  handling repeat element when reversing order;
        if (!forward) {
            iterator.next();
        }

        Town memory = iterator.next();

        System.out.println("Onwards!");
        System.out.println("Currently at: " + memory.town());
        System.out.println(memory.distFromSydney() + "km from Sydney");

        System.out.println();


    }

    private static void backwards(LinkedList<Town> travelItenerary, ListIterator<Town> iterator, boolean backward) {

        System.out.println();

        if (!iterator.hasPrevious()) {
            System.out.println("Start of Itinerary!");
            System.out.println();
            return;
        }

        //  handling repeat element when reversing order;
        if (!backward) {
            iterator.previous();
        }

        Town memory = iterator.previous();

        System.out.println("Going back!");
        System.out.println("Currently at: " + memory.town());
        System.out.println(memory.distFromSydney() + "km from Sydney");

        System.out.println();

    }

    private static void add(LinkedList<Town> travelItenerary) {

        String scannerInput;
        String scannerParsedInput;
        int parsedNumber = 0;
        boolean validInt = false;
        Town memory;
        var iterator = travelItenerary.listIterator();

        System.out.println();
        System.out.println("Add Town to Itenerary");
        System.out.println();

        System.out.print("Please enter the name of the town to be added: ");
        scannerInput = scanner.nextLine();
        //  will capitalize first letter, and assign all others to lower case;
        //  strings with less than 2 characters or NULLs can break this code!
        scannerParsedInput = scannerInput.substring(0, 1).toUpperCase() + scannerInput.substring(1).toLowerCase();

        //  cheking if already present on the list;
        while (iterator.hasNext()) {

            memory = iterator.next();

            if (memory.town().equals(scannerParsedInput)) {
                System.out.printf("%n%s is already listed on the itenerary!%n%n", scannerParsedInput);
                return;
            }
        }

        do {

            System.out.printf("%nPlease enter the distance (in km) from %s to Sydney: ", scannerParsedInput);
            scannerInput = scanner.nextLine();

            try {
                parsedNumber = Integer.parseInt(scannerInput);
                if (parsedNumber < 0) {
                    System.out.printf("Distance cannot be a negative number!%n");
                    continue;
                }
                System.out.printf("Distance from %s and Sydney: %dkm%n%n", scannerParsedInput, parsedNumber);
                validInt = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                System.out.println("Valid integer range: "+Integer.MIN_VALUE+" to "+Integer.MAX_VALUE);
            }

        } while (!validInt);

        Town newTown = new Town(scannerParsedInput, parsedNumber);
        travelItenerary.add(newTown); 
        //  sorts list elements by distance from Sydney, ascending order;
        //  :: is a Lambda (see section 14)
        travelItenerary.sort(Comparator.comparing(Town::distFromSydney));    
        
    }

    private static void remove(LinkedList<Town> travelItenerary) {

        String scannerInput;
        String scannerParsedInput;
        Town memory;
        var iterator = travelItenerary.listIterator();

        System.out.println();
        System.out.println("Remove Town from Itenerary");
        System.out.println();

        System.out.print("Please enter the name of the town to be removed: ");
        scannerInput = scanner.nextLine();
        //  will capitalize first letter, and assign all others to lower case;
        //  strings with less than 2 characters or NULLs can break this code!
        scannerParsedInput = scannerInput.substring(0, 1).toUpperCase() + scannerInput.substring(1).toLowerCase();

        //  cheking if already present on the list;
        while (iterator.hasNext()) {

            memory = iterator.next();

            if (memory.town().equals(scannerParsedInput)) {
                while (true) {
                    System.out.printf("Do you really wish to remove %s from the itenerary? (type Y/N) ", scannerParsedInput);
                    scannerInput = scanner.nextLine().trim().toUpperCase();
                    if (scannerInput.equals("Y") || scannerInput.equals("YES")) {
                        iterator.remove();
                        //  sorts list elements by distance from Sydney, ascending order;
                        //  :: is a Lambda (see section 14)
                        travelItenerary.sort(Comparator.comparing(Town::distFromSydney));
                        System.out.printf("%n%s has been removed from the itenerary!%n%n", scannerParsedInput);
                        return;
                    }
                    if (scannerInput.equals("N") || scannerInput.equals("NO")) {
                        System.out.println();
                        return;
                    }
                }
            }
        }

        
        System.out.printf("%n%s not found on the itenerary!%n%n", scannerParsedInput);
            

    }

}


