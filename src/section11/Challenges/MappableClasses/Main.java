package section11.Challenges.MappableClasses;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        //  Example of CODING TO AN INTERFACE:
        //  #1: List is an interface, so any instance that implements List (ArrayList, LinkedList, etc.) can be assigned to this REFERENCE variable;
        //  #2: Mappable is also an interface, so any instance that implements Mappable (Building, UtilityLine, etc.) is a VALID data TYPE to be added on this list; 
        List<Mappable> mappables = new ArrayList<>();
        //  We can add instances that implement Mappable;
        //  Adding instances that don't implement Mappable will result in error;
        mappables.add(new Building("Casa da Música do Porto", UsageType.ENTERTAINMENT));
        mappables.add(new UtilityLine("Metro do Porto", UtilityType.INFRASTRUCTURE));

        for (var mappable : mappables) {
            Mappable.mapIt(mappable);
        }

    }

}
