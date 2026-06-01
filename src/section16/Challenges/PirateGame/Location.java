package section16.Challenges.PirateGame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Location {
    
    private final String name;
    private final String description;
    private final Chapter chapter;
    private final Map<String, Location> nextLocations = new HashMap<>();
    private final Set<Object> loot = new HashSet<>();


    public Location(String name, String description, Chapter chapter) {
        this.name = name;
        this.description = description;
        this.chapter = chapter;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


    public Chapter getChapter() {
        return chapter;
    }


    public Map<String, Location> getNextLocations() {
        return nextLocations;
    }


    public Set<Object> getLoot() {
        return loot;
    }

}
