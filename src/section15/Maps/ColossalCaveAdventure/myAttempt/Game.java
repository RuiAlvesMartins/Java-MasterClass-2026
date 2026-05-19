package section15.Maps.ColossalCaveAdventure.myAttempt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    
    private static Scanner scanner = new Scanner(System.in);
    Map<String, Location> world;
    Location currentLocation;
    boolean quitFlag;

    

    public Game() {
        this.world = worldInitializer();
        this.currentLocation = world.get("Road");
        this.quitFlag = false;
    }

    private static Map<String, Location> worldInitializer() {

        Location road = new Location("road", "on a road winding through a hill to the west, and a water stream leading to a lake to the east.");
        Location forest = new Location("forest", "by a tall pine tree, in the middle of a forest. A dirt track heads south, to the road.");
        Location hill = new Location("hill", "a top a grassy hill overlooking the road. You can see the forest and the valley.");
        Location valley = new Location("valley", "at the bottom of a valley, between the hill and the stream.");
        Location wellHouse = new Location("well house", "inside a well house for a small spring.");
        Location lake = new Location("lake", "by a blue lake, it's calm water reflecting the sky.");
        Location stream = new Location("stream", "near a stream with a rocky bed.");

        road.getNextPlaces().put("N", forest);
        road.getNextPlaces().put("W", hill);
        road.getNextPlaces().put("S", valley);
        road.getNextPlaces().put("E", wellHouse);

        forest.getNextPlaces().put("SW", hill);
        forest.getNextPlaces().put("S", road);
        forest.getNextPlaces().put("E", lake);

        hill.getNextPlaces().put("N", forest);
        hill.getNextPlaces().put("E", road);
        hill.getNextPlaces().put("SE", valley);

        valley.getNextPlaces().put("N", road);
        valley.getNextPlaces().put("W", hill);
        valley.getNextPlaces().put("E", stream);

        wellHouse.getNextPlaces().put("N", lake);
        wellHouse.getNextPlaces().put("W", road);
        wellHouse.getNextPlaces().put("S", stream);

        lake.getNextPlaces().put("W", forest);
        lake.getNextPlaces().put("S", wellHouse);

        stream.getNextPlaces().put("N", wellHouse);
        stream.getNextPlaces().put("W", valley);

        Map<String, Location> world = new HashMap<>();
        world.put(road.getName(), road);
        world.put(forest.getName(), forest);
        world.put(hill.getName(), hill);
        world.put(valley.getName(), valley);
        world.put(wellHouse.getName(), wellHouse);
        world.put(lake.getName(), lake);
        world.put(stream.getName(), stream);

        return world;

    }

    private static void printLogo() {
        System.out.println();
        System.out.println("_".repeat(30));
        System.out.println("|" + " ".repeat(28) + "|");
        System.out.println("|  Colossal Adventure Game   |");
        System.out.println("|" + "_".repeat(28) + "|");
        System.out.println();
    }
    
    private void printLocation(Location l) {

        System.out.println();
        System.out.println("_".repeat(120));

        System.out.println("You are " + l.getDescription());
        System.out.println();
        System.out.println("From here you can see:");

        if (l.getNextPlaces().get("NE") != null) {
            System.out.println("        # a %s to the North-East (NE)".formatted(
                l.getNextPlaces().get("NE").getName().toLowerCase()
            ));
        }
        if (l.getNextPlaces().get("N") != null) {
            System.out.println("        # a %s to the North (N)".formatted(
                l.getNextPlaces().get("N").getName().toLowerCase()
            ));
        }
        if (l.getNextPlaces().get("NW") != null) {
            System.out.println("        # a %s to the North-West (NW)".formatted(
                l.getNextPlaces().get("NW").getName().toLowerCase()
            ));
        }

        if (l.getNextPlaces().get("W") != null) {
            System.out.println("        # a %s to the West (W)".formatted(
                l.getNextPlaces().get("W").getName().toLowerCase()
            ));
        }

        if (l.getNextPlaces().get("SW") != null) {
            System.out.println("        # a %s to the South-West (SW)".formatted(
                l.getNextPlaces().get("SW").getName().toLowerCase()
            ));
        }
        if (l.getNextPlaces().get("S") != null) {
            System.out.println("        # a %s to the South (S)".formatted(
                l.getNextPlaces().get("S").getName().toLowerCase()
            ));
        }
        if (l.getNextPlaces().get("SE") != null) {
            System.out.println("        # a %s to the South-East (SE)".formatted(
                l.getNextPlaces().get("SE").getName().toLowerCase()
            ));
        }

        if (l.getNextPlaces().get("E") != null) {
            System.out.println("        # a %s to the East (E)".formatted(
                l.getNextPlaces().get("E").getName().toLowerCase()
            ));
        }

    }

    private void directionInput() {

        System.out.println();
        System.out.println("Select your compass direction (Q to quit): ");

        String input = scanner.nextLine();
        String direction = switch (input.toUpperCase()) {

            case "N", "NORTH" -> "N";
            case "W", "WEST" -> "W";
            case "S", "SOUTH" -> "S";
            case "E", "EAST" -> "E";

            case "NE", "NORTH EAST", "NORTH-EAST" -> "NE";
            case "NW", "NORTH WEST", "NORTH-WEST" -> "NW";
            case "SE", "SOUTH EAST", "SOUTH-EAST" -> "SE";
            case "SW", "SOUTH WEST", "SOUTH-WEST" -> "SW";

            case "Q", "QUIT" -> "Q";
            default -> "";
        };

        if (direction.equals("Q")) {
            this.exitGame();
            return;
        }

        if (!direction.isEmpty()) {
            Location nextLocation = currentLocation.getNextPlaces().get(direction);
            if (nextLocation != null) {
                currentLocation = world.get(nextLocation.getName());
            }
            else {
                System.out.println(direction + " is not a valid direction!");
            }
        }
        else {
            System.out.println(input + " is not a valid input!");
        }

    }

    private void exitGame() {

        System.out.println();
        System.out.println("Are you sure you want to quit the game? (Y/N)");
        
        if (scanner.nextLine().toUpperCase().equals("Y")) {
            quitFlag = true;
            System.out.println();
            System.out.println("Exiting game...");
            return;
        }

    }

    void console() {

        printLogo();

        while (!quitFlag) {
            printLocation(currentLocation);
            directionInput();
        }

    }

}
