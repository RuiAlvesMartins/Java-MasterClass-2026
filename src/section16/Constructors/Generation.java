package section16.Constructors;

import java.time.LocalDate;

public enum Generation {
    
    //  Each CONSTANT is in fact a CLASS of type Generation!
    //  This means you can add a class body!

    GEN_ALPHA {
        //  this constant will be instantiated with the no-args constructor;

        //  Instance Initializer for GEN_ALPHA constant:
        {
            System.out.println("xxx_SKIBIDI_TOILET_xxx");
        }
    },                              
    GEN_Z(2001, 2025),
    MILLENIAL(1981, 2000),
    GEN_X(1965, 1980),
    BABY_BOOMER(1946, 1964),
    SILENT_GENERATION(1927, 1945),
    GREATEST_GENERATION(1901, 1926);
    //  NEVER FORGET to add the semi-colon on the last constant;
    //  when adding custom code to an enum;

    private final int startYear;
    private final int endYear;

    
    //  Constructors on Enums are implicitly PRIVATE!
    Generation(int startYear, int endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
        //  When an enum is initialized;
        //  ALL constants are initialized!
        //  e.g. this will print all constants whenever this enum gets instantiated:
        System.out.println(this);
    }

    private Generation() {
        this(2026, LocalDate.now().getYear());
    }

    @Override
    public String toString() {
        return this.name() + " " + startYear + " - " + endYear;
    }    
    
    
    //  Javap
    //  javap -p bin/section16/Constructors/Generation

}
