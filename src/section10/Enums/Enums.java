package section10.Enums;

import java.util.Random;

public class Enums {
    
    //  ENUMS
    //  Enumeration (Wikipedia): a complete ordered listing of all the items in a collection;
    //  Enum (Java): special DATA TYPE that contains predefined CONSTANTS;
    //  Constant: a variable whose value can't be changed once it has been set;

    //  An ENUM can be thought of an array where it's elements:
    //          are known;
    //          are immutable;
    //          are referred to by a constant name (instead of an index);
    //  List of constant identifiers, separated by commas, are ordered by the ORDER you DECLARE/TYPE them;
    //  .ordinal() starts at 0;

    public static void main(String[] args) {
        
        DayOfTheWeek weekday = DayOfTheWeek.TUESDAY;
        System.out.println(weekday);

        for (int i = 0; i < 10; i++) {
            weekday = getRandomDay();

            //  .name()         //  returns name of enum element;
            //  .ordinal()      //  returns the index position; starts at 0;
            System.out.printf("Name is %s, Ordinal Value = %d%n", weekday.name(), weekday.ordinal());

            //  test EQUALITY with ==
            if (weekday == DayOfTheWeek.FRIDAY) {
                System.out.println("It's friday, friday, gotta get down on friday!");
            }

        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < 10; i++) {
            weekday = getRandomDay();
            switchDayOfWeek(weekday);
        }

        System.out.println();
        System.out.println();

        //  .values() will return an array with all elements of an enum;
        for (BurgerToppings topping : BurgerToppings.values()) {
            System.out.println(topping.name() + " : " + topping.getPrice());
        }

    }

    public static DayOfTheWeek getRandomDay() {
        //  will return a random number between 0 and 6 (argument = 7, but upper bound is excluded);
        int randomInteger = new Random().nextInt(DayOfTheWeek.values().length);     //  DayOfTheWeek length = 7;
        //  .values() will return an array DayOfTheWeek[];
        var allDays = DayOfTheWeek.values();

        return allDays[randomInteger];

    }

    public static void switchDayOfWeek(DayOfTheWeek weekDay) {

        int weekDayInteger = weekDay.ordinal() + 1;
        switch (weekDay) {
            case SATURDAY -> System.out.println("Saturday is day #" + weekDayInteger);
            case SUNDAY -> System.out.println("Sunday is day #" + weekDayInteger);
            default -> System.out.println(
                weekDay.name().charAt(0) + 
                weekDay.name().substring(1).toLowerCase() + 
                " is day #" + 
                weekDayInteger
            );
        }

    }

}