package section7.References;

public class References {

    //  CLASSES are custom data types, with FIELDS and METHODS; They are blueprints for objects;
    //  OBJECTS are INSTANCES of classes; their STATE is dictated by the FIELDS; their BEHAVIOUR is dictated by the METHODS;
    //  REFERENCES are variables that point to an OBJECT, but are NOT the OBJECT;

    public static void main(String[] args) {
        
        //  OBJECTS ALWAYS have to be INSTANTIATED!
        House blueHouse = new House("Blue");
        //  both blueHouse and anotherHouse are VARIABLES, they POINT to the object but ARE NOT the object!            
        House anotherHouse = blueHouse;               

        System.out.println(blueHouse.getColor());     //  prints "Blue";
        System.out.println(anotherHouse.getColor());  //  prints "Blue";

        //  because anotherHouse is pointing to the same previously created object, this SETTER will set a new color to the same object!
        anotherHouse.setColor("Red");           
        
        System.out.println(blueHouse.getColor());     //  prints "Red";  
        System.out.println(anotherHouse.getColor());  //  prints "Red";

        //  now a new object is being instantiated; greenHouse will point to a different object!
        House greenHouse = new House("Green");
        //  REFERENCES can be REASSIGNED to different objects!
        //  anotherHouse will stop pointing to the previous object, and point to the new one!
        anotherHouse = greenHouse;                      

        System.out.println(blueHouse.getColor());     //  prints "Red";
        System.out.println(greenHouse.getColor());    //  prints "Green";  
        System.out.println(anotherHouse.getColor());  //  prints "Green";

        //  objects can be instantiated WITHOUT REFERENCES;
        //  it will be stored in memory, but your code will have no way to access it;
        //  Java's GARBAGE COLLECTION proccess deletes objects without pointers/references!
        new House("Beige");

        //  OBJECTS can be instantiated with the same STATE, but they will be DIFFERENT objects!
        //  Their REFERENCES must be different though!
        House house1 = new House("Yellow");
        House house2 = new House("Yellow");

    }

}
