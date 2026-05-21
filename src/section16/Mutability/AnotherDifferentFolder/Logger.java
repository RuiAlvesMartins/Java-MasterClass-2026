package section16.Mutability.AnotherDifferentFolder;

import java.time.LocalDateTime;

public class Logger {
    
    public static void logToConsole(CharSequence message) {
        
        LocalDateTime dt = LocalDateTime.now();

        //  EXPLICIT INDEXING

        //  "%1$" or "%2$" denote which format arg to use:
        //          "%1$"   will use 1st arg;
        //          "%2$"   will use 2nd arg;
        //  Note: if you use arg indexes, you need to use specifiers for ALL args;

        //  "%s" denotes the argument type will be a String;
        //  "%d" denotes the argument type will be an Int of sorts;
        //  "%f" denotes the argument type will be a Float;

        //  FORMATTING DATETIME

        //  For DateTime, the denoter is "%t" followed by a CONVERSION Char:
        //          "%tD"   gets the day (mm:dd:yy) out of a DateTime object;
        //          "%tT"   gets the time (hh:mm:ss) out of a DateTime object;
        //          (examples not exhaustive)

        //  Learn more on Date/Time Conversions:
        //  https://docs.oracle.com/en/java/javase/17/docs/api/jav a.base/java/util/Formatter.html#dt

        System.out.println("%1$tD %1$tT : %2$s".formatted(dt, message));

        //  .logToConsole() has a nasty SIDE-EFFECT: it clears the StringBuilder instance after eachlog statement;
        if (message instanceof StringBuilder sb) {
            sb.setLength(0);
        }

    }


    
    public static void main(String[] args) {
        
        //  DEFENSIVE CODING

        //  .logToConsole() has a nasty SIDE-EFFECT: it clears the StringBuilder instance after each log statement;
        //  but we can defend it by passing it as a string with .toString();
        StringBuilder tracker = new StringBuilder("Step 1 is abc");
        Logger.logToConsole(tracker.toString());
        tracker.append(", Step 2 is xyz.");
        Logger.logToConsole(tracker.toString());
        System.out.println("After logging, tracker = " + tracker);
        //  REMEMBER: method args are copies of references, 
        //  meaning the original instance can be mutated by the method's code!

    }

}
