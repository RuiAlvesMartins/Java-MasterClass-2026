package section18.Time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class PeriodDurationDemo {
    
    //  java.time.PERIOD
    //  a DATE based amout of time e.g. 5 days, 1 month, 2 years, etc.

    //  java.time.DURATION
    //  a TIME based amount of time e.g. 60 seconds, 10 minuts, 24 hours, etc.

    public static void main(String[] args) {

        Instant dobInstant = Instant.parse("2020-01-01T08:01:00Z");
        LocalDateTime dob = LocalDateTime.ofInstant(dobInstant, ZoneId.systemDefault());

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

    }

}
