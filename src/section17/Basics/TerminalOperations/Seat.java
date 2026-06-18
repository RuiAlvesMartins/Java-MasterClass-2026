package section17.Basics.TerminalOperations;

import java.util.Random;

public record Seat(char rowMarker, int seatNumber, boolean isReserved) {

    public Seat(char rowMarker, int seatNumber) {
        this(rowMarker, seatNumber, 
            new Random().nextBoolean());
    }

    @Override
    public String toString() {
        return "%c%03d %s".formatted(rowMarker, seatNumber, isReserved? "Taken" : "Free");
    }

}
