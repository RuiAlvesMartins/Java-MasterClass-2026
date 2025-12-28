package section8.Composition;
public class Main {

    //  COMPOSITION
    //  It is when a class is composed by other classes;
    //  Some of it's fields are classes;

    //  Inheritance: IS A relationship;
    //  Composition: HAS A relationship;
    //  Composition is more flexible than inheritance, and less likely to break encapsulation;

    public static void main(String[] args) {
        
        ComputerCase theCase = new ComputerCase("2208", "Dell", "240");
        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, "2540 x 1440");
        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");
        PersonalComputer thePC = new PersonalComputer("2208", "Dell", theCase, theMonitor, theMotherboard);

        //  METHOD CHAINING
        //  we call the case object from the PC object, and then call one of it's methods;
        //  However this is not desirable, we don't want users to have access to the components of the SUPER OBJECT;
        thePC.getComputerCase().pressPowerButton();
        thePC.getMotherboard().loadProgram("Windows OS");
        thePC.getMonitor().drawPixerAt(10, 10, "red");        

        //  this is a better way to boot up;
        thePC.powerUp();

    }

}
