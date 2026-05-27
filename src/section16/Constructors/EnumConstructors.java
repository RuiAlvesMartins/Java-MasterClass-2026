package section16.Constructors;

public class EnumConstructors {
    
    public static void main(String[] args) {
        
        Person joe = new Person("Joe", "01-01-1960");
        System.out.println(joe);
        
        Person joeCopy = new Person(joe);
        System.out.println(joeCopy);

        Generation g = Generation.BABY_BOOMER;
        //  REMEMBER: you can't instantiate enums                   ... duh!
        // Generation h = new Generation(1900, 1925);               //  compiler error!
        // Generation j = new Generation.BABY_BOOMER(1945, 1965);   //  compiler error!

        //  Javap
        //  javap -p bin/section16/Constructors/Generation

    }

}
