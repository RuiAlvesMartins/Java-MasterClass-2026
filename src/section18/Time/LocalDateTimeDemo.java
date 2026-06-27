package section18.Time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class LocalDateTimeDemo {
    
    //  LocalDateTime implements TemploralAccessor;
    //  LocalDateTime is IMMUTABLE!

    //  LocalDateTime is composed of:
    //          a Date field (LocalDate);
    //          a Time field (LocalTime);
    //  LocalDateTime has all of LocalDate and LocalTime methods;
    //  Review LocalDate and LocalTime before comming here!

    public static void main(String[] args) {
        
        LocalDateTime todayAndNow = LocalDateTime.now();
        System.out.println(todayAndNow);

        LocalDateTime May5Noon = LocalDateTime.of(2022, 5, 5, 12, 0);
        System.out.println("%tD %tr".formatted(May5Noon, May5Noon));
        System.out.println("%1$tF %1$tT ".formatted(May5Noon));

        //  Date Time Format Specifiers:
        //          %tD:  mm/dd/yy    
        //          %tr:  hh:mm:ss AM/PM
        //          %tF:  yyyy-mm-dd
        //          %tT:  hh:mm:ss AM 

        //  LocalDateTime.format(DateTimeFormatter)
        System.out.println(todayAndNow.format(DateTimeFormatter.ISO_WEEK_DATE));
        //  There are more DateTimeFormatter available for use;
        //  You can also build your own:
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(May5Noon.format(dtf));
        System.out.println(May5Noon.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        LocalDateTime May6Noon = May5Noon.plusHours(24);
        System.out.println(May6Noon.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

    }

}
