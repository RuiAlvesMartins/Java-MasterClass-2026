package section15.Sets.Theatre;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Theatre {
    
    class Seat implements Comparable<Seat> {

        char row;
        int number;
        boolean isReserved;

        public Seat(char row, int number) {
            this.row = row;
            this.number = number;
            this.isReserved = false;
        }

        public String getSeat() {
            String seat = String.format("%c%03d", row, number);
            return seat;
        }

        public boolean isReserved() {
            return isReserved;
        }

        private void setReserved(boolean isReserved) {
            this.isReserved = isReserved;
        }

        @Override
        public String toString() {
            return "%s |%s|".formatted(this.getSeat(), isReserved ? "x" : " ");
        }

        @Override
        public int compareTo(Seat o) {
            int rowCompare = Character.compare(this.row, o.row);

            if (rowCompare != 0) {
                return rowCompare;
            }

            return Integer.compare(this.number, o.number);
        }

    }



    String name;
    // no more than 26 rows A - Z
    int nRows;
    // uniform number of seats per row
    int nSeatsPerRow;
    NavigableSet<Seat> seats = new TreeSet<>(); 
    // a theatre instance should be constructed with the theatre name, the number of rows in the theatre, and the number of seats total in the theatre;
    // you should create the seats and number them, as part of the initialization of Theatre class;
    
    public Theatre(String name, int nRows, int totalSeats) {
        this.name = name;
        this.nRows = nRows > 26 ? 26 : nRows < 1 ? 1 : nRows;
        this.nSeatsPerRow = totalSeats < nRows ? 1 : totalSeats / nRows;
        this.seats = this.setSeats();
    }
    
    private NavigableSet<Seat> setSeats() {

        NavigableSet<Seat> seats = new TreeSet<>();
        char row = 'A';

        for(int i=0; i<nRows; i++) {

            // String lineRow = "";

            for(int j=0; j<nSeatsPerRow; j++) {

                Seat s = new Seat((char) (row + i), j + 1);
                seats.add(s);
                // lineRow = lineRow + s + " ";

            }

            // System.out.println(lineRow);

        }

        return seats;

    }
    
    // .printSeatMap()
    //  prints each seat, one row per line;
    //  should show which seats are reserved;
    public void printSeatMap() {

        System.out.println();
        System.out.println(name + " Theatre");
        System.out.println("_".repeat(30));

        char row = 'A';

        for(int i=0; i<nRows; i++) {

            Seat s1 = new Seat(row, 0);
            row++;
            Seat s2 = new Seat(row, 0);
            var subSeats = seats.tailSet(s1).headSet(s2);
            String line = "";

            for (Seat seat : subSeats) {
                line = line + seat + " ";
            }

            System.out.println(line);

        }

        System.out.println("_".repeat(30));

    }

    //  create a method for a booking agent to reserve a single seat;
    public boolean reserveSeat(char row, int number) {

        if (row - 'A' >= nRows || row - 'A' < 0) {
            System.out.println("Argument out of bounds: Row %c does not exist!".formatted(row));
            return false;
        }

        if (number > nSeatsPerRow || number < 1) {
            System.out.println("Argument out of bounds: Seat %c%03d does not exist!".formatted(row, number));
            return false;
        }

        Seat demo = new Seat(row, number);
        Seat s = seats.ceiling(demo);
        
        if (s.isReserved) {
            System.out.println(s.getSeat() + " is already booked!");
            return false;
        }

        s.setReserved(true);
        System.out.println(s.getSeat() + " has been reserved!");
        return true;

    }

    //  optional 
    //  create a reservation method that specifies:
    //      number of reservations requested;
    //      range of rows (e.g. A through C) for frontrow seats;
    //      range of contiguous seats (1 <= range of contiguous seats <= # seats per row);
    public boolean reserveSeat(int totalSeats, int contiguousSeats, char startRow, char endRow, int minSeat, int maxSeat) {

        //  validations
        if (minSeat < 1 || minSeat > nSeatsPerRow) {
            System.out.println("Argument out of bounds: minSeat");
            return false;
        }
        if (maxSeat < minSeat || maxSeat > nSeatsPerRow) {
            System.out.println("Argument out of bounds: maxSeat");
            return false;
        }
        if (totalSeats > nRows * nSeatsPerRow) {
            System.out.println("Argument out of bounds: can't book %d seats in a %d seat theatre!".formatted(totalSeats, nRows * nSeatsPerRow));
            return false;
        }
        if (contiguousSeats > totalSeats) {
            System.out.println("Argument out of bounds: ");
            return false;
        }
        if (contiguousSeats > nSeatsPerRow) {
            System.out.println("Argument out of bounds: can't book %d contigous seats. Rows have only %d seats!".formatted(contiguousSeats, nSeatsPerRow));
            return false;
        }
        if (contiguousSeats > maxSeat - minSeat) {
            System.out.println("Argument out of bounds: can't book %d contiguous seats in the %d-%d seat range!".formatted(contiguousSeats, minSeat, maxSeat));
            return false;
        }
        if (startRow - 'A' >= nRows || startRow - 'A' < 0) {
            System.out.println("Argument out of bounds: Row %c does not exist!".formatted(startRow));
            return false;
        }
        if (endRow - 'A' >= nRows || endRow - 'A' < 0) {
            System.out.println("Argument out of bounds: Row %c does not exist!".formatted(endRow));
            return false;
        }

        NavigableSet<Seat> seatsToBook = new TreeSet<>();
        int seatsLeftToBook = totalSeats;

        for(int i=0; i<=endRow-startRow; i++) {

            Seat s1 = new Seat((char) (startRow + i), minSeat);
            Seat s2 = new Seat((char) (startRow + i), maxSeat + 1);

            var row = seats.tailSet(s1).headSet(s2);

            int seatsToBookInThisRow = seatsLeftToBook > contiguousSeats ? contiguousSeats : seatsLeftToBook;
            int contiguousCounter = 0;

            for (Seat seat : row) {
                if (!seat.isReserved) {
                    contiguousCounter++;

                    if (contiguousCounter == seatsToBookInThisRow) {
                        
                        char c = seat.getSeat().charAt(0);
                        int n = Integer.parseInt(seat.getSeat().substring(1, 4));

                        var contiguousSeatsInThisRow = row
                                .tailSet(new Seat(c, n + 1 - contiguousCounter))
                                .headSet(new Seat(c, n + 1));

                        seatsToBook.addAll(contiguousSeatsInThisRow);

                        seatsLeftToBook = seatsLeftToBook - seatsToBookInThisRow;

                        break;

                    }

                }
                else{
                    contiguousCounter = 0;
                }
            }

        }

        if (seatsLeftToBook == 0) {
            for (Seat seat : seatsToBook) {
                char c = seat.getSeat().charAt(0);
                int i = Integer.parseInt(seat.getSeat().substring(1, 4));
                this.reserveSeat(c, i);
            }
            return true;
        }

        System.out.println("Not possile to book requested seats.");
        return false;

    }


}
