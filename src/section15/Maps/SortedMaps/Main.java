package section15.Maps.SortedMaps;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class Main {
    
    private static Map<String, Purchase> purchases = new LinkedHashMap<>();
    private static NavigableMap<String, Student> students = new TreeMap<>();
 
    public static void main(String[] args) {
        
        Course jmc = new Course("jmc101", "Java Master Class", "Java");
        Course python = new Course("pyt101", "Python Master Class", "Python");

        addPurchase("Mary Martin", jmc, 129.99);
        addPurchase("Andy Martin", jmc, 139.99);
        addPurchase("Mary Martin", python, 149.99);
        addPurchase("Joe Jones", jmc, 149.99);
        addPurchase("Bill Brown", python, 119.99);

        addPurchase("Chuck Cheese", python, 119.99);
        addPurchase("Davey Jones", jmc, 139.99);
        addPurchase("Eva East", python, 139.99);
        addPurchase("Fred Forker", jmc, 139.99);
        addPurchase("Greg Brady", python, 129.99);

        //  purchases (LinkedHashMap) will be printed in insertion order;
        purchases.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("_".repeat(90));
        //  students (TreeMap) will be printed in alphabetical order;
        students.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("_".repeat(90));
        NavigableMap<LocalDate, List<Purchase>> datedPurchases = new TreeMap<>();
        for (Purchase p : purchases.values()) {
            //todo do I understand this? no!
            datedPurchases.compute(p.purchaseDate(), 
                (pdate, plist) -> {
                    List<Purchase> list = (plist == null) ? new ArrayList<>() : plist;
                    list.add(p);
                    return list;
                }
            );
        }
        datedPurchases.forEach((key, value) -> System.out.println(key + ": " + value));

        int currentYear = LocalDate.now().getYear();
        LocalDate firstDay = LocalDate.ofYearDay(currentYear, 1);
        LocalDate week1 = firstDay.plusDays(7);
        //  NavigableMap.headMap();
        Map<LocalDate, List<Purchase>> week1Purchases = datedPurchases.headMap(week1);
        //  NavigableMap.tailMap();
        Map<LocalDate, List<Purchase>> week2Purchases = datedPurchases.tailMap(week1);

        // System.out.println("_".repeat(90));
        // week1Purchases.forEach((k, v) -> System.out.println(k + ": " + v));
        // System.out.println("_".repeat(90));
        // week2Purchases.forEach((k, v) -> System.out.println(k + ": " + v));

        displayStats(1, week1Purchases);
        displayStats(2, week2Purchases);

        System.out.println("_".repeat(90));
        //  SortedMap.lastKey()
        //  this will return the last date key;
        LocalDate lastDate = datedPurchases.lastKey();
        //  NavigableMap.lastEntry()
        //  this will return a kv pair with all the values (purchases) associated with the last key (date);
        var previousEntry = datedPurchases.lastEntry();
        
        while (previousEntry != null) {

            //  Map.get()
            List<Purchase> lastDaysData = previousEntry.getValue();
            //  this will print the last date, followed by the count of purchases;
            System.out.println(lastDate + " purchases : " + lastDaysData.size());

            //  NavigableMap.lowerKey()
            LocalDate prevDate = datedPurchases.lowerKey(lastDate);
            //  NavigableMap.lowerEntry()
            previousEntry = datedPurchases.lowerEntry(lastDate);
            //  this will cicle through all dates backwards;
            //  once it reaches the first kv, methods will return null and break cicle;
            lastDate = prevDate;

            //  What if we used floor methods?
            //  we would be stuck on infinite loop; 
            //  because they would return the argument itself!
            //  NavigableMap.floorKey()
            // LocalDate prevDate = datedPurchases.floorKey(lastDate);
            //  NavigableMap.floorEntry()
            // previousEntry = datedPurchases.floorEntry(lastDate);
            // lastDate = prevDate;
        }

        System.out.println("_".repeat(90));
        //  NavigableMap.descendingMap()
        var reversed = datedPurchases.descendingMap();
        //  SortedMap.firstKey()
        LocalDate firstDate = reversed.firstKey();
        //  NavigableMap.firstEntry()
        var nextEntry = reversed.firstEntry();
        //  NavigableMap.pollFirstEntry()
        // var nextEntry = reversed.pollFirstEntry();

        while (nextEntry != null) {

            List<Purchase> lastDaysData = nextEntry.getValue();
            System.out.println(firstDate + " purchases : " + lastDaysData.size());
            //  NavigableMap.higherKey()
            LocalDate nextDate = reversed.higherKey(firstDate);
            //  NavigableMap.higherEntry()
            nextEntry = reversed.higherEntry(firstDate);
            //  NavigableMap.pollFirstEntry()
            // nextEntry = reversed.pollFirstEntry();
            firstDate = nextDate;

        }

        //  only the view has had it's order reversed;
        //  the original map preserves the original order!
        System.out.println("_".repeat(90));
        datedPurchases.forEach((k, v) -> System.out.println(k + ": " + v));
        //  if you uncomment the .pollFirstEntry() above;
        //  the previous print order won't run;
        //  because POLL methods REMOVE the kv, leaving the map empty!
        //  be careful about using poll methods on views, because they will affect the map!

    }

    private static void addPurchase(String studentName, Course course, double price) {

        Student existingStudent = students.get(studentName);
        if (existingStudent == null) {
            existingStudent = new Student(studentName, course);
            students.put(studentName, existingStudent);
        }
        else {
            existingStudent.addCourse(course);
        }

        //  this is not realistic, but an arbitrary decision;
        //  meant to highlight the insertion order on purchases (LinkedHashMap);
        // int day = purchases.size() + 1;

        //  this is a more realistic alternative;
        //  and also highlights the different sorting on: 
        //          purchases (LinkedHashMap)   ->  insertion order;
        //          datedPurchases (TreeMap)    ->  chronological order;
        //  insertion order does not necessarily follow chronological order!
        int day = new Random().nextInt(1, 15);

        String key = course.courseId() + "_" + existingStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(), 
            existingStudent.getId(), price, year, day
        );
        purchases.put(key, purchase);

    }

    private static void displayStats(int period, Map<LocalDate, List<Purchase>> periodData) {

        System.out.println("_".repeat(90));
        Map<String, Integer> weeklyCounts = new TreeMap<>();
        //todo do I understand this? no!
        periodData.forEach((k, v) -> {
            System.out.println(k + ": " + v);
            for(Purchase p : v) {
                weeklyCounts.merge(p.courseId(), 1, (prev, current) -> {
                    return prev + current;
                });
            }
        });
        System.out.println("Week %d Purchases = %s".formatted(period, weeklyCounts));

    }

}
