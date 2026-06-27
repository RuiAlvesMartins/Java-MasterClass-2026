package section18.Time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;

public class ZoneDateTimeDemo {

    //  java.time.ZONEDATETIME
    //  similar to a LocalDateTime, but with a Time Zone associated;

    public static void main(String[] args) {
        
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

    }

}
