package section15.Maps.ColossalCaveAdventure.myAttempt;

import java.util.HashMap;
import java.util.Map;

public class Location {
    
    String name;
    String description;
    Map<String, Location> nextPlaces;

    public Location(String name, String description) {

        this.name = "";
        String[] wordsInName = name.split(" ");
        for (String word : wordsInName) {
            word = word.substring(0, 1).toUpperCase()
                    + word.substring(1).toLowerCase();

            this.name = this.name + " " + word;
        }

        this.name = this.name.trim();
        this.description = description;
        this.nextPlaces = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Location> getNextPlaces() {
        return nextPlaces;
    }

    

}
