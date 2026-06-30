package section18.Challenges.MeetingScheduler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class MySolution {
    
    public static void main(String[] args) {
        
        // var dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter usFormat = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, h:mm a", Locale.US);
        DateTimeFormatter auFormat = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy, h:mm a", Locale.US);

        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        String AUsydney = "Australia/Sydney";
        String USeastern = "US/Eastern";
        String jane = "Jane";
        String joe = "Joe";

        ZonedDateTime AUdateTime = now.withZoneSameInstant(ZoneId.of(AUsydney));
        ZonedDateTime USdateTime = now.withZoneSameInstant(ZoneId.of(USeastern));

        System.out.println(AUdateTime);
        System.out.println(USdateTime);

        System.out.println(AUdateTime.getHour());
        System.out.println(USdateTime.getHour());


        //  ignoring the current day
        USdateTime = USdateTime.plus(1, ChronoUnit.DAYS);
        USdateTime = USdateTime.withHour(0);
        USdateTime = USdateTime.withMinute(0);
        USdateTime = USdateTime.withSecond(0);
        USdateTime = USdateTime.withNano(0);
        System.out.println(USdateTime);
        //  10 day range
        ZonedDateTime USdateTimeCeiling = USdateTime.plus(10, ChronoUnit.DAYS);

        System.out.println();
        while (USdateTime.isBefore(USdateTimeCeiling)) {
            
            AUdateTime = USdateTime.withZoneSameInstant(ZoneId.of(AUsydney));
            // System.out.println(AUdateTime);

            int AUhour = AUdateTime.getHour();
            // System.out.println("AUhour = " + AUhour);
            int UShour = USdateTime.getHour();
            // System.out.println("UShour = " + UShour);

            if (AUhour > 6 && AUhour < 21 &&
                UShour > 6 && UShour < 21) {
                String output = "%s [%s] : %-35s <--->    %s [%s] : %s".formatted(
                    jane,
                    USeastern,
                    USdateTime.format(usFormat),
                    joe,
                    AUsydney,
                    AUdateTime.format(auFormat)
                );    
                System.out.println(output);
            }

            USdateTime = USdateTime.plus(1, ChronoUnit.HOURS);
            // System.out.println(USdateTime);
            
        }

    }

}
