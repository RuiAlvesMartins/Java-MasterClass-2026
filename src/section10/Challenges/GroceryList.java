package section10.Challenges;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GroceryList {
    
    private static ArrayList<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        
        console();

    }

    public static void print() {
        
        sort();
        System.out.println(groceryList);
        System.out.println();

    }

    public static void add() {
        
        Scanner scanner = new Scanner(System.in);
        String stringInput;

        System.out.printf("%nADD ITEM(S)%n");
        System.out.printf("%nType your values in a comma separated list:%n");
        
        stringInput = scanner.nextLine();
        String[] array = stringInput.split(",");
        System.out.println();

        //  this is simpler but:
        //  won't prevent duplicates;
        //  won't trim strings;
        // groceryList.addAll(List.of(array));

        for (String item : array) {
            item = item.trim().toLowerCase();
            if (!groceryList.contains(item)) {
                groceryList.add(item);
                System.out.println(item + " added to the groceries list");
            } else {
                System.out.println(item + " is already on the list!");
            }
        }

        sort();
        System.out.println();

    }

    public static void remove() {
        
        Scanner scanner = new Scanner(System.in);
        String stringInput;

        System.out.printf("%nREMOVE ITEM(S)%n");
        System.out.printf("%nType your values in a comma separated list:%n");
        
        stringInput = scanner.nextLine();
        String[] array = stringInput.split(",");
        System.out.println();

        //  this is simpler but won't work as well
        // groceryList.removeAll(List.of(array));

        for (String item : array) {
            item = item.trim().toLowerCase();
            if (groceryList.contains(item)) {
                groceryList.remove(item);
                System.out.println(item + " removed from the groceries list");
            } else {
                System.out.println(item + " is not on the list!");
            }
        }

        sort();
        System.out.println();

    }

    // private static boolean checkList(String key) {

    //     return groceryList.contains(key);

    // }

    private static void sort() {

        groceryList.sort(Comparator.naturalOrder());

    }

    private static void console() {
        
        Scanner scanner = new Scanner(System.in);
        boolean shutDown = false;
        String stringInput;
        int integer = -1;

        System.out.printf("%nGROCERY LIST PROGRAM%n%n");

        do {

            System.out.println("#".repeat(30));
            System.out.printf("%nAvailable actions:%n");
            System.out.printf("%n#0 - Shutdown;%n");
            System.out.printf("#1 - Print list;%n");
            System.out.printf("#2 - Add item(s);%n");
            System.out.printf("#3 - Remove item(s);%n");
            System.out.printf("%nEnter number for corresponding action you want:%n");

            stringInput = scanner.nextLine();

            try {
                integer = Integer.parseInt(stringInput);
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Invalid input!");
                System.out.println("Valid integer range: "+Integer.MIN_VALUE+" to "+Integer.MAX_VALUE);
                System.out.println();
                continue;
            }

            switch (integer) {
                case 0 -> shutDown = true;
                case 1 -> print();
                case 2 -> add();
                case 3 -> remove();
                default -> System.out.printf("%n%d is not attributed!%n%n", integer);
            }

        } while (!shutDown);

        System.out.printf("%nShutting down...%n");
        System.out.println("PROGRAM EXIT");

    }

}
