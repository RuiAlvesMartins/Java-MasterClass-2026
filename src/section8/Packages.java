package section8;

import section8.Challenges.Polymorphism.Car;
// import section8.Challenges.Car.Car;

public class Packages {
    
    //  PACKAGES
    //  A Package can be thought of as a folder/directory on the Operating System;
    //  All classes inside a package have mutual access to each other, unless restricted by access modifiers;
    //  Packages also allow for common class names across different libraries, and a way to correctly identify them;
    //  Example  //  import java.util.Date;
    //           //  import java.sql.Date;
    //  Encapsulation at the package level can be enforced with the PROTECTED access modifier;
    //  Package statement needs to be the FIRST STATEMENT in the code (except for comments or white space);
    //  Classes/files in a non declared package are implicitly stored in the unnamed DEFAULT PACKAGE; Because package has no name, these classes CANNOT be imported by other packages!
    //  Hierarchical levels are separated with a period (.);
    //  naming convention: all lower case, reverse domain name;
    //  Example  //  abccompany.com
    //           //  import com.abccompany;



    //  IMPORT
    //  Allows the class/file to have access to a different package;
    //  Has to be declared AFTER Package, but BEFORE any classes;
    //  We can import all classes in a package with asterisk (*);
    //  Example  //  import java.util.*;


    public static void main(String[] args) {
        
        Car firstCar = Car.getCar("EV", "Honda EV Plus", 149);

        //  you can't import this class, it colides with the previous one;
        //  you have to work on it like this:
        section8.Challenges.Car.Car secondCar = new section8.Challenges.Car.Car(8, "Morris");

    }

}
