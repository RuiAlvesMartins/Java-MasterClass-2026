package section8.Challenges.Car;

public class Main {

    public static void main(String[] args) {
        
        Car trabi = new Car(6, "Trabant");
        System.out.println(trabi.startEngine());
        System.out.println(trabi.accelerate());
        System.out.println(trabi.brake());

        Mitsubishi mitsubishi = new Mitsubishi(8, "Lancer Evolution");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Holden holden = new Holden(8, "Commodore");
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());

        Ford ford = new Ford(6, "Fiesta");
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

    }

}
