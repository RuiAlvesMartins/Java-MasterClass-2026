package section15.Maps.ColossalCaveAdventure.timsSolution;

import java.util.Map;

public record Location(String description, Map<Compass, String> nextPlaces) {
    
}
