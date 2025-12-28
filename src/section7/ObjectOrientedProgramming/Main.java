package section7.ObjectOrientedProgramming;

public class Main {

    public static void main(String[] args) {
        
        Car car = new Car();
        car.describeCar();

        Car tesla = new Car();
        tesla.setMake("Tesla");
        tesla.setModel("Model X");
        tesla.setColor("Gray");
        tesla.setDoors(2);
        tesla.setConvertible(true);
        tesla.describeCar();

        Car porshe = new Car("Porshe", "Carrera", "Black", 2, true);
        porshe.describeCar();

        Car lada = new Car("Lada", "Niva", "4x4", 2);
        lada.describeCar();

        Car toyota = new Car();
        toyota.setMake(null);
        toyota.setModel("HiAce");
        toyota.setColor("Beije");
        toyota.setDoors(4);
        toyota.setConvertible(false);
        toyota.describeCar();

    }

}
