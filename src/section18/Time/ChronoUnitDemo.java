package section18.Time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class ChronoUnitDemo {
    
    //  java.time.temporal.CHRONOUNIT
    //  a set of time representing units;

    public static void main(String[] args) {
        
        Instant dobInstant = Instant.parse("2020-01-01T08:01:00Z");
        LocalDateTime dob = LocalDateTime.ofInstant(dobInstant, ZoneId.systemDefault());
        LocalDateTime dob2 = dob.plusYears(2).plusMonths(4)
                .plusDays(4).plusHours(7).plusMinutes(14)
                .plusSeconds(37);



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
