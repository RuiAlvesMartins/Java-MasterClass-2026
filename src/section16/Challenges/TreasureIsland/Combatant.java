package section16.Challenges.TreasureIsland;

import java.util.HashMap;
import java.util.Map;

abstract sealed class Combatant implements section16.Challenges.GameConsole.Player permits PlayableChar, NonPlayableChar {
    
    private final String name;    
    private final Map<String, Integer> gameData;
    
    private Location currentLocation;

    private WeaponMelee meleeWeapon;
    private WeaponRanged rangedWeapon;

    {
        
        this.gameData = new HashMap<>(Map.of(
            "LVL", 1,
            "XP", 0,
            "HP", 100,
            "ARMOR", 0
        ));

    }

    Combatant(String name, int level, int xp, int hp, int armor, WeaponMelee meleeWeapon, WeaponRanged rangedWeapon) {
        this.name = name;
        this.gameData.put("LVL", level);
        this.gameData.put("XP", xp);
        this.gameData.put("HP", hp);
        this.gameData.put("ARMOR", armor);
        this.meleeWeapon = meleeWeapon;
        this.rangedWeapon = rangedWeapon;
    }



    @Override
    public String name() {
        return name;
    } 

    Location getCurrentLocation() {
        return currentLocation;
    }

    void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    boolean equipMeleeWeapon(WeaponMelee weaponMelee) {
        if (weaponMelee.getLevel() < this.getData("LVL")) {
            System.out.println("Need to be level #%d or higher to equip %s!".formatted(
                weaponMelee.getLevel(), weaponMelee.getName()));
            return false;
        }
        this.meleeWeapon = weaponMelee;
        System.out.println("Equiped %s.".formatted(weaponMelee.getName()));
        return true;
    }

    boolean equipRangedWeapon(WeaponRanged weaponRanged) {
        if (weaponRanged.getLevel() < this.getData("LVL")) {
            System.out.println("Need to be level #%d or higher to equip %s!".formatted(
                weaponRanged.getLevel(), weaponRanged.getName()));
            return false;
        }
        this.rangedWeapon = weaponRanged;
        System.out.println("Equiped %s.".formatted(weaponRanged.getName()));
        return true;
    }

    public WeaponMelee getMeleeWeapon() {
        return meleeWeapon;
    }

    public WeaponRanged getRangedWeapon() {
        return rangedWeapon;
    }

    int getData(String dataField) {
        return gameData.get(dataField);
    }

    private void setData(String dataField, int value) {
        gameData.put(dataField, value);
    }

    private void adjustValue(String dataField, int value) {
        gameData.compute(dataField, (k, v) -> v += value);
    }

    private void adjustHealth(int value) {
        int health = getData("HP");
        health += value;
        health = health < 0 ? 0 : health > 100 ? 100 : health;
        setData("HP", health);
    }

    boolean useWeapon() {
        return false;
    }

    // boolean visitTown(Chapter place) {
    //     if (place != null) {
    //         townsVisited.add(place);
    //         return false;
    //     }
    //     return true;
    // }

    @Override
    public String toString() {
        String s = this.name;
        s = s + "={lvl=%d, xp=%d, hp=%d, armor=%d}".formatted(
            gameData.get("LVL"), gameData.get("XP"),
            gameData.get("HP"), gameData.get("ARMOR")
        );
        s = s + " weapons={%s, %s}".formatted(
            this.meleeWeapon.name(),
            this.rangedWeapon.name()
        );
        s = s + " location=%s(%s)".formatted(
            currentLocation.name(),
            currentLocation.chapter()
        );

        return s;
    }

}
