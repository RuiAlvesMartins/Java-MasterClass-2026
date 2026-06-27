package section18.Time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public class InstantDemo {
    
    //  java.time.INSTANT
    //  designed to represent only a point in time, or a timestamp;
    //  composed of seconds (long) and nanoseconds (int), counted since Unix or Epoch time start (midningh 1jan70);

    //  Instant cannot be formatted into a Date or Time, without providing time-zone information;
    //  When printed, 'Z' is used at the end to indicate that the produced timestamp is in reference to UTC;
    //  This allows for comparisons regardless of time zones or operating systems!

    public static void main(String[] args) {
        
        //  System.setProperty() is used to set system variables;
        //  See ZoneIdDemo.java for more info;
        System.setProperty("user.timezone", "America/Los_Angeles");
        System.out.println(ZoneId.systemDefault());

        Instant instantNow = Instant.now();
        System.out.println(instantNow);
        // the Z at the end indicates standard UTC time (zero offset)



        for (ZoneId z : List.of(
                ZoneId.of("Australia/Sydney"),
                ZoneId.of("Europe/Paris"),
                ZoneId.of("America/New_York")
        )) {
            DateTimeFormatter zoneFormat = DateTimeFormatter.ofPattern("z:zzzz");
            System.out.println(z);
            System.out.println("\t" + instantNow.atZone(z).format(zoneFormat));
            //  this will print a DURATION (e.g. PT1H)
            //  (PT = Period of Time; Offset = 1 Hour)
            System.out.println("\t" + z.getRules().getDaylightSavings(instantNow));
            //  the Daylight Savings offset is only applied when this flag is TRUE:
            System.out.println("\t" + z.getRules().isDaylightSavings(instantNow));
        }
        System.out.println();



        //  instantiating Instant by parsing a string:
        Instant dobInstant = Instant.parse("2020-01-01T08:01:00Z");
        //  instantiating a LocalDateTime with .ofInstant():
        LocalDateTime dob = LocalDateTime.ofInstant(dobInstant, ZoneId.systemDefault());
        System.out.println("Your kid's birthdate, LA time = " + dob.format(
            DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        ZonedDateTime dobSydney = ZonedDateTime.ofInstant(dobInstant, ZoneId.of("Australia/Sydney"));
        System.out.println("Your kid's birthdate, Sydney time = " + dobSydney.format(
            DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        //  with this method, you only need to pass the time zone:    
        ZonedDateTime dobHere = dobSydney.withZoneSameInstant(ZoneId.systemDefault());
        System.out.println("Your kid's birthdate, Here time = " + dobHere.format(
            DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        //  ZonedDateTime.now() will use the system's default timezone;
        ZonedDateTime firstOfMonth = ZonedDateTime.now()
        //  ZoneDateTime.with(TemporalAdjuster) allows adjustment of the date/time;
                .with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("First day of next Month = %tD".formatted(firstOfMonth));



        Period timePast = Period.between(LocalDate.EPOCH, dob.toLocalDate());
        System.out.println(timePast);
        //  Output: P50Y
        //  P = Period; 50 Years;

        Duration timeSince = Duration.between(Instant.EPOCH, dob.toInstant(ZoneOffset.UTC));
        System.out.println(timeSince);
        //  Output: PT438288H1M
        //  PT = Period of Time; 438288 Hours and 1 Minute


        
        LocalDateTime dob2 = dob.plusYears(2).plusMonths(4)
                .plusDays(4).plusHours(7).plusMinutes(14)
                .plusSeconds(37);

        System.out.println("Your kid's birthdate, Here time = " + dob2.format(
            DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        Period timePast2 = Period.between(LocalDate.EPOCH, dob2.toLocalDate());
        System.out.println(timePast2);
        //  Output: P52Y4M4D

        Duration timeSince2 = Duration.between(Instant.EPOCH, dob2.toInstant(ZoneOffset.UTC));
        System.out.println(timeSince2);
        //  Output: PT458815H15M37S



        System.out.println();
        for (ChronoUnit u : ChronoUnit.values()) {
            if (u.isSupportedBy(LocalDate.EPOCH)) {
                long val = u.between(LocalDate.EPOCH, dob2.toLocalDate());
                System.out.println(u + " past = " + val);
            } else {
                System.out.println("-- Not supported: " + u);
            }
        }
        System.out.println();

        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.EPOCH, ZoneOffset.UTC);
        System.out.println();
        for (ChronoUnit u : ChronoUnit.values()) {
            if (u.isSupportedBy(ldt)) {
                long val = u.between(ldt, dob2);
                System.out.println(u + " past = " + val);
            } else {
                System.out.println("-- Not supported: " + u);
            }
        }
        System.out.println();

    }

}
