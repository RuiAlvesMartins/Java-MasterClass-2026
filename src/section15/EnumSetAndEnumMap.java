package section15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//  EnumSet and EnumMap both have special implementation;
    //  that makes them extremely compact and efficient;
    //  but differs from HashSet or HashMap;
    //  no special list implementation exists for enums;

public class EnumSetAndEnumMap {

    //  ENUMSET

    //  EnumSet is ABSTRACT, meaning we cannot instantiate it directly;
    //  Comes with many FACTORY methods to create instances;
    //  All elements in an EnumSet must come from the same Enum type!
    //  Much better PERFORMANCE compared to using an HashSet with an Enum type;
    //  Bulk operations (e.g. .containsAll() and .retainAll()) run in almost CONSTANT TIME O(1);
    //  (if they are run on an EnumSet and the argument is also an EnumSet);



    //  ENUMMAP

    //  Specialized Map implementation for use with ENUM type KEYS;
    //  Keys must all come from the same Enum type!
    //  Keys are ordered naturally by the ordinal value of the constants;
    //  This map has same functionality as HashMap, with O(1) for basic operations;
    //  EnumMap has better PERFORMANCE than using a HashMap with an Enum type as keys;
    //  Enum key type is specified during construction of EnumMap:
    //          explicitly: by passing the key type class;
    //          implicitly: passing an EnumSet;



    enum WeekDay {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

    public static void main(String[] args) {
        
        List<WeekDay> annsWorkDays = new ArrayList<>(List.of(
            WeekDay.MONDAY,
            WeekDay.TUESDAY,
            WeekDay.THURSDAY,
            WeekDay.FRIDAY
        ));

        //  EnumSet methods

        //  EnumSet.copyOf()
        var annsDaysSet = EnumSet.copyOf(annsWorkDays);
        System.out.println(annsDaysSet.getClass().getSimpleName()); //  RegularEnumSet

        //  EnumSets are represented internally as BIT VECTORS (a series of 1s and 0s);
        //  1 indicates the Enum constant is present in the EnumSet (ordinal value equal to index of the bit);
        //  0 indicates the Enum constant is not present in the EnumSet;
        //  Bit vectors allow all set operations to use BIT MATH, making it very FAST;

        //  RegularEnumSet uses a single LONG as its bit vector, containing a 64 bit maximum, represeenting 64 Enum constants;
        //  JumboEnumSet is returned if there is more than 64 Enums in the EnumSet;

        //  Visual representation of annsWorkDays EnumSet:

        //  Sunday  Monday  Tuesday Wednesday   Thursday    Friday  Saturday
        //     0      1        1        0           1         1        0
        //  (bit vector length = # constants in the enum type (WeekDay))   
        
        

        //  Constants in EnumSet are printed in the order defined in the Enum;
        annsDaysSet.forEach(System.out::println);

        //  EnumSet.allOf()
        //  returns all constants in Enum;
        System.out.println("_".repeat(30));
        var allDaysSet = EnumSet.allOf(WeekDay.class);
        allDaysSet.forEach(System.out::println);

        //  EnumSet.complementOf()
        //  returns the difference;
        System.out.println("_".repeat(30));
        Set<WeekDay> newPersonDays = EnumSet.complementOf(annsDaysSet);
        newPersonDays.forEach(System.out::println);

        //  EnumSet.removeAll()
        //  removes the provided elements;
        System.out.println("_".repeat(30));
        Set<WeekDay> anotherWay = EnumSet.copyOf(allDaysSet);
        anotherWay.removeAll(annsDaysSet);
        anotherWay.forEach(System.out::println);

        //  EnumSet.range()
        //  returns the constants inside the priveded range;
        System.out.println("_".repeat(30));
        Set<WeekDay> businessDays = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        businessDays.forEach(System.out::println);



        //  EnumMap methods

        Map<WeekDay, String[]> employeeMap = new EnumMap<>(WeekDay.class);

        System.out.println("_".repeat(30));
        employeeMap.put(WeekDay.FRIDAY, new String[] {"Ann", "Mary", "Bob"});
        employeeMap.put(WeekDay.MONDAY, new String[] {"Mary", "Bob"});
        employeeMap.forEach(
            (k, v) -> System.out.println(k + ": " + Arrays.toString(v))
        );

    }
    
}
