package section15.Sets.Theatre;

public class Main {
    
    public static void main(String[] args) {

        Theatre t = new Theatre("Malenki", 4, 40);

        // Theatre.Seat s1 = t.new Seat('A', 1);
        // System.out.println(s1.getSeat());

        // System.out.println(s1);
        // s1.setReserved(true);
        // System.out.println(s1);

        // t.printSeatMap();

        // t.reserveSeat('A', 0);
        // t.reserveSeat('A', 1);
        // t.reserveSeat('A', 2);
        t.reserveSeat('A', 3);
        // t.reserveSeat('A', 4);
        // t.reserveSeat('A', 5);
        // t.reserveSeat('A', 6);
        // t.reserveSeat('A', 7);
        // t.reserveSeat('A', 8);
        t.reserveSeat('A', 9);
        // t.reserveSeat('A', 10);
        // t.reserveSeat('A', 11);

        // t.reserveSeat('B', 0);
        t.reserveSeat('B', 1);
        // t.reserveSeat('B', 2);
        // t.reserveSeat('B', 3);
        // t.reserveSeat('B', 4);
        // t.reserveSeat('B', 5);
        // t.reserveSeat('B', 6);
        t.reserveSeat('B', 7);
        // t.reserveSeat('B', 8);
        // t.reserveSeat('B', 9);
        // t.reserveSeat('B', 10);
        // t.reserveSeat('B', 11);

        // t.reserveSeat('C', 0);
        t.reserveSeat('C', 1);
        // t.reserveSeat('C', 2);
        t.reserveSeat('C', 3);
        // t.reserveSeat('C', 4);
        t.reserveSeat('C', 5);
        // t.reserveSeat('C', 6);
        t.reserveSeat('C', 7);
        // t.reserveSeat('C', 8);
        // t.reserveSeat('C', 9);
        // t.reserveSeat('C', 10);
        // t.reserveSeat('C', 11);

        // t.reserveSeat('D', 0);
        // t.reserveSeat('D', 1);
        // t.reserveSeat('D', 2);
        // t.reserveSeat('D', 3);
        // t.reserveSeat('D', 4);
        // t.reserveSeat('D', 5);
        // t.reserveSeat('D', 6);
        // t.reserveSeat('D', 7);
        // t.reserveSeat('D', 8);
        // t.reserveSeat('D', 9);
        // t.reserveSeat('D', 10);
        // t.reserveSeat('D', 11);

        // t.printSeatMap();

        // t.reserveSeat('E', 0);
        // t.reserveSeat('E', 11);

        t.printSeatMap();

        // t.reserveSeat(12, 5, 'A', 'D');
        t.reserveSeat(5, 5, 'A', 'A', 3, 8);

        t.printSeatMap();

    }

}
