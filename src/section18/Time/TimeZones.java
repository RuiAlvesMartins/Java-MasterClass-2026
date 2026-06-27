package section18.Time;

public class TimeZones {
    
    //  Greenwich Mean Time (GMT)
    //  Coordinated Standard Time (UTC)

    //  00:00:00 UTC, Thursday 1st January 1970 = Unix, POSIX or EPOCH Time
    //  Predetermined start of time on many OSs;



    //  Time Zone has two parts:
    //          UTC offset  (+ west; - east)            https://twiki.org/cgi-bin/xtra/tzdatepick.html
    //          Daylight Savings Time (optional)        https://en.wikipedia.org/wiki/Daylight_saving_time

    //  Java derives time zone data from three sources:
    //          Internet Assigned Numbers Authority (IANA) Time Zone Database(TZDB) (defualt, takes precedence over the others)
    //          International Air Transport Association (IATA)
    //          Microsoft


 
    //  Deprecated classes:
    //          Date
    //          TimeZone
    //          GregorianCalendar
    //          DateFormat
    //          SimpleDateFormat
    //  Use is discouraged in new code because of thread safety;  



    //  System.currentTimeMilis()
    //  returns miliseconds since epoch time (midninght 1st jan 1970 UTC)

    //  System.nanoTime()
    //  returns nanoseconds from an arbitrary origin time;
    //  this origin is not epoch time, and can be in the future;
    //  it may also differ across JVM instances;
    //  It can't be used to represent real time; 
    //  Its purpose is to measure elapsed time for invocations in a single JVM instance;

}
