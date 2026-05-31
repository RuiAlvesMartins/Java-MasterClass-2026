package section16.Challenges.PirateInvasion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Pirate implements section16.Challenges.GameConsole.Player {
    
    //todo combat
    private final String name;    
    private final Map<String, Integer> gameData;
    private final Set<Chapter> townsVisited;
    private Location currentLocation;
    private Weapon currentWeapon;

    {
        this.gameData = new HashMap<>(Map.of(
            "LVL", 1,
            "XP", 0,
            "HP", 100,
            "ARMOR", 0
        ));

        this.townsVisited = new HashSet<>();

        currentWeapon = Weapon.DAGGER;

    }


    public Pirate(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    } 

    public Location getCurrentLocation() {
        return currentLocation;
    }

    void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    void equipWeapon(Weapon weapon) {
        this.currentWeapon = weapon;
    }

    public void addVisitedTown(Chapter chapter) {
        this.townsVisited.add(chapter);
    }
    
    public Set<Chapter> getTownsVisited() {
        return townsVisited;
    }

    @Override
    public String toString() {
        String s = this.name;
        s = s + " {lvl=%d, xp=%d, hp=%d, armor=%d, wpn=%s}".formatted(
            gameData.get("LVL"), gameData.get("XP"),
            gameData.get("HP"), gameData.get("ARMOR"),  
            currentWeapon.firstLetterUpperCase()  
        );

        String places = "";
        for (Chapter chapter : townsVisited) {
            places = places + chapter.toString() + "; ";
        }
        places = places.trim();
        places = places.substring(0, places.length()-1);

        s = s + " levels visited = {%s}".formatted(places);
        return s;
    }

}
