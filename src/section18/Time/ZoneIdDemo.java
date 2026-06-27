package section18.Time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

public class ZoneIdDemo {
    
    public static void main(String[] args) {

        //  System.setProperty() is used to set system variables;
        //  (it should be set on the Main class, or the application ENTRY point)

        //  It can be used to set (i.e. change) the timezone;
        //  It needs to be set before any Date/Time manipulation code happens!
        //  I.e. it needs to happen before timezone is cached on the first call!
        //  TimeZone can also be changed by passing it as a command line argument on JVM startup;
        System.setProperty("user.timezone", "America/Los_Angeles");

        System.out.println(ZoneId.systemDefault());
        //  returns the timezone of the OS;

        System.out.println("Number of TZs = " + ZoneId.getAvailableZoneIds().size());
        //  returns a Set<String> of all time zones;



        ZoneId.getAvailableZoneIds().stream()
                .filter(s -> s.startsWith("Australia"))
                .sorted()
                //  transforms Stream<String> into Stream<ZoneId>
                .map(s -> ZoneId.of(s))
                .forEach(z -> System.out.println(z.getId() + ": " + z.getRules()));
                //  ZoneId.getId() returns Id; note: blank spaces replaced by underscores;
                //  ZoneId.getRules() returns the UTC offset (as well as DST?);
        ;
        System.out.println();



        Set<String> jdk8Zones = ZoneId.getAvailableZoneIds();
        //  TimeZone is a deprecated class;
        //  It is maintained for backwards compatibility, but it's usage is discouraged because of thread safety;
        String[] alternate = TimeZone.getAvailableIDs();
        Set<String> oldway = new HashSet<>(Set.of(alternate));

        jdk8Zones.removeAll(oldway);
        System.out.println(jdk8Zones);                              //  Output: []

        jdk8Zones = ZoneId.getAvailableZoneIds();
        oldway.remove(jdk8Zones);
        // System.out.println(oldway);                                 //  Output: just run the code and you will see
        //  This means that the old TimeZone class has zones that are not present in the newer ZoneId!



        //  Converting old TimeZone into new ZoneId
        // ZoneId bet = ZoneId.of("BET");                           //  runtime error!              
        ZoneId bet = ZoneId.of("BET", ZoneId.SHORT_IDS);
        System.out.println(bet);



        //  This will return a different time, depending on how you set the timezone:
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);



        Instant instantNow = Instant.now();
        System.out.println(instantNow);     
        // the Z at the end indicates standard UTC time (zero offset)

    }

}
