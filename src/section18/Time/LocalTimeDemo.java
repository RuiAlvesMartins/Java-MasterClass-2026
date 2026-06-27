package section18.Time;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeDemo {
    
    //  LocalTime implements TemploralAccessor;
    //  LocalTime is IMMUTABLE!

    //  Review LocalDate before coming here!

    public static void main(String[] args) {
        
        //  instantiating LocalTime
        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime sevenAM = LocalTime.of(7, 0);
        System.out.println(sevenAM);

        LocalTime sevenThirty = LocalTime.of(7, 30, 15);
        System.out.println(sevenThirty);

        LocalTime sevenPM = LocalTime.parse("19:00");
        System.out.println(sevenPM);

        LocalTime sevenThirtyPM = LocalTime.parse("19:30:15.1000");
        System.out.println(sevenThirtyPM);
        System.out.println();

        //  This will compile, but will result in a runtime error:
        // LocalTime sevenPM = LocalTime.parse("19:00");
        //  Format MUST be hh:mm:ss.nnnn



        //  Getter methods

        //  TemporalAccessor.get(TemporalField)
        System.out.println(sevenAM.get(ChronoField.AMPM_OF_DAY));               //  Output: 0
        System.out.println(sevenPM.get(ChronoField.AMPM_OF_DAY));               //  Output: 1

        System.out.println(sevenThirtyPM.getHour());
        System.out.println(sevenThirtyPM.get(ChronoField.HOUR_OF_DAY));

        //  This will compile, but will result in runtime error:
        // System.out.println(sevenThirtyPM.get(ChronoField.YEAR));
        //  Date ChronoFields do not work on LocalTime!

        System.out.println(sevenThirtyPM.getMinute());
        System.out.println(sevenThirtyPM.getSecond());
        System.out.println(sevenThirtyPM.getNano());
        System.out.println();



        //  Temporal.plus(n, TemporalUnit)
        System.out.println(sevenThirtyPM.plus(24, ChronoUnit.HOURS));
        System.out.println(sevenThirtyPM.minus(24, ChronoUnit.HOURS));
        System.out.println();
 


        //  TemporalAccessor.range(TemporalField)
        //  returns the valid range of the temporal field;
        System.out.println(sevenThirtyPM.range(ChronoField.HOUR_OF_DAY));
        System.out.println(sevenThirtyPM.range(ChronoField.MINUTE_OF_HOUR));
        System.out.println(sevenThirtyPM.range(ChronoField.MINUTE_OF_DAY));
        System.out.println(sevenThirtyPM.range(ChronoField.SECOND_OF_MINUTE));
        System.out.println(sevenThirtyPM.range(ChronoField.SECOND_OF_DAY));
        System.out.println();



    }

}
