package section18.Time;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateDemo {

    //  LocalDate implements TemploralAccessor;
    //  LocalDate is IMMUTABLE!

    //  LocalDate.now();
    //  LocalDate.of(int, int, int);
    //  LocalDate.of(int, month, int);
    //  LocalDate.ofYearDay(int, int);
    //  LocalDate.parse(string);

    //  LocalDate.getYear();
    //  LocalDate.getMonth();
    //  LocalDate.getMonthValue();
    //  LocalDate.getDayOfWeek();
    //  LocalDate.getDayOfMonth();
    //  LocalDate.getDayOfYear();

    //  TemporalAccessor.get(TemporalField);

    public static void main(String[] args) {
        
        //  returning today's date
        LocalDate today = LocalDate.now();
        System.out.println(today);

        //  four ways of building a date:
        LocalDate Five5 = LocalDate.of(2022, 5, 5);
        System.out.println(Five5);

        LocalDate May5th = LocalDate.of(2022, Month.MAY, 5);
        System.out.println(May5th);

        LocalDate Day125 = LocalDate.ofYearDay(2022, 125);
        System.out.println(Day125);

        //  format: yyyy-mm-dd
        LocalDate May5 = LocalDate.parse("2022-05-05");
        System.out.println(May5);
        System.out.println();



        //  getting fields from a LocalDate instance:
        System.out.println(May5.getYear());
        System.out.println(May5.getMonth());
        System.out.println(May5.getMonthValue());
        System.out.println(May5.getDayOfWeek());
        System.out.println(May5.getDayOfMonth());
        System.out.println(May5.getDayOfYear());
        System.out.println();

        //  TemporalAccessor.get(TemporalField)
        System.out.println(May5.get(ChronoField.YEAR));
        System.out.println(May5.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(May5.get(ChronoField.DAY_OF_MONTH));
        System.out.println(May5.get(ChronoField.DAY_OF_YEAR));
        System.out.println();



        //  Beacuse LocalData is IMMUTABLE, you don't have setters to edit the fields of an instance;
        //  These methods return a new instence instead;
        System.out.println(May5.withYear(2000));
        System.out.println(May5.withMonth(3));
        System.out.println(May5.withDayOfMonth(4));
        System.out.println(May5.withDayOfYear(126));
        //  The original instance remains unchanged;
        //  To keep changes, reference variable must be reassigned to the new instance;
        System.out.println(May5);
        System.out.println();

        System.out.println(May5.with(ChronoField.DAY_OF_YEAR, 126));
        System.out.println(May5.plusYears(1));
        System.out.println(May5.plusMonths(12));
        System.out.println(May5.plusDays(365));
        System.out.println(May5.plusWeeks(52));
        //  Temporal.plus(n, TemporalUnit) will add n of the specified temporal units;
        //  In this example, 365 days:
        System.out.println(May5.plus(365, ChronoUnit.DAYS));
        System.out.println(May5.minus(3, ChronoUnit.MONTHS));
        System.out.println();

        //  TemporalField VS. TemporalUnit
        //  TField represents a specific field within a date-time, e.g. day of the week, month of the year, etc.
        //  TUnit represents a unit of duration of time, e.g. days, months, years, etc.



        //  Comparisson Methods
        System.out.println("May5 > today ? " + May5.isAfter(today));                //  Output: false
        System.out.println("today > May5 ? " + May5.isBefore(today));               //  Output: true
        System.out.println("May5 > today ? " + May5.compareTo(today));              //  Output: -4
        System.out.println("today > May5 ? " + today.compareTo(May5));              //  Output: 4

        System.out.println("today = now ? " + today.compareTo(LocalDate.now()));    //  Output: 0
        System.out.println("today = now ? " + today.equals(LocalDate.now()));       //  Output: true

        System.out.println(today.isLeapYear());                                     //  Output: false
        System.out.println(May5.minusYears(2).isLeapYear());        //  Output: true
        System.out.println();



        //  Stream methods

        //  LocalDate.datesUntil(endExclusive)
        System.out.println("-".repeat(30));
        May5.datesUntil(May5.plusDays(7))
                .forEach(System.out::println);

        //  LocalDate.datesUntil(endExclusive, step)        
        System.out.println("-".repeat(30));
        May5.datesUntil(May5.plusYears(1), Period.ofDays(7))
                .forEach(System.out::println);

    }

}
