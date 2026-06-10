package section16.Challenges.TreasureIsland;

import java.util.HashMap;
import java.util.Map;

record Location(
    Chapter chapter, 
    String name, 
    String description, 
    // int level, 
    Map<String, Location> directions,
    // Location chapterChange,
    Map<String, Object> loot,
    Map<String, Combatant> npcs
) {

    //  Compact Constructor
    Location {}

    Location(Chapter chapter, String name, String description) {
        this(chapter, name, description,
            new HashMap<>(),
            new HashMap<>(),
            new HashMap<>()
        );
    }



}
