package section16.Challenges.TreasureIsland;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

final class PlayableChar extends Combatant {

    private final Set<Chapter> townsVisited;
    //todo add an inventoryc
    private final Map<Item, Integer> inventory;

    {

        this.townsVisited = new LinkedHashSet<>();
        this.inventory = new HashMap<>();

    }

    PlayableChar(String name) {
        super(name, 1, 0, 100, 0, WeaponMelee.DAGGER, null);
    }
    







    void addVisitedTown(Chapter chapter) {
        this.townsVisited.add(chapter);
    }
    
    Set<Chapter> getTownsVisited() {
        return townsVisited;
    }

    Map<Item, Integer> getInventory() {
        return inventory;
    }



    @Override
    public String toString() {
        String s = super.toString();

        //todo add inventory to print
        String places = "";
        for (Chapter chapter : townsVisited) {
            places = places + chapter.toString() + "; ";
        }
        places = places.trim();
        places = places.substring(0, places.length()-1);

        s = s + "\t levels visited = {%s}".formatted(places);

        return s;
    }    

}
