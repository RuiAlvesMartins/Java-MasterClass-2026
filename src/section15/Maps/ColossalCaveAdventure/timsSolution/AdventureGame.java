package section15.Maps.ColossalCaveAdventure.timsSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdventureGame {
    
    private static final String GAME_LOCATIONS = """
            road,at the end of the road, W: hill, E:well house,S:valley,N:forest
            hill,on top of hill with a view in all directions,N:forest, E:road
            well house,inside a well house for a small spring,W:road,N:lake,S:stream
            valley,in a forest valley beside a tumbling stream,N:road,W:hill,E:stream
            forest,at the edge of a thick dark forest,S:road,E:lake
            lake,by an alpine lake surrounded by wildflowers,W:forest,S:well house
            stream,near a stream with a rocky bed,W:valley, N:well house
            """;

    private String lastPlace;

    private Map<String, Location> adventureMap = new HashMap<>();

    public AdventureGame() {
        this(null);
    }

    public AdventureGame(String customLocations) {
        
        loadLocations(GAME_LOCATIONS);

        //  this will add new locations if the player intends to;
        //  it will also replace existing ones if they are already mapped;
        if (customLocations != null) {
            loadLocations(customLocations);
        }

    }

    private void loadLocations(String data) {

        //  data.split("\\R")
        //  this code splits a string by line break;
        //  fairly robust;
        for (String s : data.split("\\R")) {
            //  s.split(",", 3) will split the string in 3 parts;
            //  all comas after the 2nd will be ignored;
            String[] sParts = s.split(",", 3);
            Arrays.asList(sParts).replaceAll(sPart -> sPart.trim());
            Map<Compass, String> nextPlaces = loadDirections(sParts[2]);
            Location location = new Location(sParts[1], nextPlaces);
            //  why put and not putIfAbsent?
            //  to replace already mapped locations;
            adventureMap.put(sParts[0], location);
        }

        //  for debugging purposes;
        // adventureMap.forEach((k, v) -> System.out.println("%s: %s".formatted(k, v)));

    }

    private Map<Compass, String> loadDirections(String nextPlaces) {

        Map<Compass, String> directions = new HashMap<>();
        List<String> nextSteps =  Arrays.asList(nextPlaces.split(","));
        
        for (String place : nextSteps) {
            String[] dirDest = place.split(":");
            //  in a real world application, you can't guarantee that input data will fit the enum perfectly;
            //  defensive coding would have to be implemented;
            Compass dir = Compass.valueOf(dirDest[0].trim());
            String dest = dirDest[1].trim();
            directions.put(dir, dest);
        }

        return directions;

    }

    void visit(Location location) {
        System.out.println("*** You're standing %s ***".formatted(location.description()));
        //  "\t" adds a tab (8 blank spaces);
        System.out.println("\tFrom here, you can see:");

        location.nextPlaces().forEach(
            (k, v) -> System.out.println("\t\tA %s to the %s (%S);"
                    .formatted(v, k.toString(), k)
            )
        );

        System.out.print("Select your compass (Q to quit) >> ");
    }

    public void move(String direction) {

        var nextPlaces = adventureMap.get(lastPlace).nextPlaces();
        String nextPlace = null;
        if ("ENSW".contains(direction)) {
            nextPlace = nextPlaces.get(Compass.valueOf(direction));
            if (nextPlace != null) {
                play(nextPlace);
            }
        } else {
            System.out.println("!! Invalid direction, try again !!");
        }

    }

    private void play(String location) {

        if (adventureMap.containsKey(location)) {
            
            Location next = adventureMap.get(location);
            lastPlace = location;
            visit(next);

        }
        else {
            System.out.println(location + " is an invalid location");
        }

    }

    public void run(String startingLocation) {

        Scanner scn = new Scanner(System.in);

        play(startingLocation);

        while (true) {
            String direction = scn.nextLine().trim().toUpperCase().substring(0, 1);
            //  quits the game;
            if (direction.equals("Q")) {break;}
            move(direction);
        }

    }

}
