package section16.Challenges.PirateInvasion;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import section16.Challenges.GameConsole.GameAction;

public class Game extends section16.Challenges.GameConsole.Game<Pirate> {

    //  game will have different levels
    //  each level will have a list of towns (string)
    final List<List<Location>> levelMap;

    {

        Location innGuestRoom =
            new Location("Guest Room",
                "A small room overlooking the sea. The old captain keeps watch here.",
                Chapter.ADMIRAL_BENBOWS_INN);

        Location innKitchen =
            new Location("Kitchen",
                "The warm heart of the inn, filled with the smell of stew and fresh bread.",
                Chapter.ADMIRAL_BENBOWS_INN);

        Location innUpperFloor =
            new Location("Upper Floor",
                "A creaking upstairs hallway lined with guest rooms and sea-worn floorboards.",
                Chapter.ADMIRAL_BENBOWS_INN);

        Location innRoadCliffs =
            new Location("Road to the Cliffs",
                "A windswept path above the sea with a clear view of approaching ships.",
                Chapter.ADMIRAL_BENBOWS_INN);

        Location bristolTavern =
            new Location("Spy-Glass Tavern",
                "A bustling sailors' tavern owned by the charismatic Long John Silver.",
                Chapter.BRISTOL);

        Location bristolMarket =
            new Location("Market",
                "Merchants shout their wares as townsfolk crowd the busy streets.",
                Chapter.BRISTOL);

        Location bristolDocks =
            new Location("Docks",
                "Tall ships sway in the harbor while crews prepare for distant voyages.",
                Chapter.BRISTOL);

        Location shipMainDeck =
            new Location("Main Deck",
                "The ship's busy center where sailors work beneath the white sails and the open sky.",
                Chapter.HMS_HISPANIOLA);

        Location shipQuarterdeck =
            new Location("Quarterdeck",
                "The officers' domain with a commanding view of the entire deck.",
                Chapter.HMS_HISPANIOLA);

        Location shipCaptainCabin =
            new Location("Captain's Cabin",
                "Charts and instruments are strewn around the table, with the captain's personal sabers and silverware adorning the walls.",
                Chapter.HMS_HISPANIOLA);

        Location shipGalley =
            new Location("Galley",
                "The cook's workplace, rich with the scent of salted meat and stew.",
                Chapter.HMS_HISPANIOLA);

        Location shipHold =
            new Location("Cargo Hold",
                "A dark storage space packed with barrels, supplies, and hidden weaponry.",
                Chapter.HMS_HISPANIOLA);

        Location shipRigging =
            new Location("Rigging",
                "High above the deck, the wind is tangled in a web of ropes and sails. From here, one has a sweeping view of the ocean.",
                Chapter.HMS_HISPANIOLA);

        Location islandHill =
            new Location("Spy-Glass Hill",
                "The highest point on the island, offering a panoramic view in every direction.",
                Chapter.TREASURE_ISLAND);

        Location islandStockade =
            new Location("Stockade",
                "A rough wooden fort built for defense against a pirate attack.",
                Chapter.TREASURE_ISLAND);

        Location islandX =
            new Location("Captain Flint's 'X'",
                "The legendary spot marked on the map where Captain Flint's treasure is said to lie buried.",
                Chapter.TREASURE_ISLAND);

        Location islandCave =
            new Location("Ben's Cave",
                "A hidden refuge where Ben Gunn has survived alone for years.",
                Chapter.TREASURE_ISLAND);

        innGuestRoom.getNextLocations().put(innKitchen.getName(), innKitchen);
        innGuestRoom.getNextLocations().put(innUpperFloor.getName(), innUpperFloor);
        innGuestRoom.getNextLocations().put(innRoadCliffs.getName(), innRoadCliffs);
        innKitchen.getNextLocations().put(innGuestRoom.getName(), innGuestRoom);
        innUpperFloor.getNextLocations().put(innGuestRoom.getName(), innGuestRoom);
        innRoadCliffs.getNextLocations().put(innGuestRoom.getName(), innGuestRoom);
        innRoadCliffs.getNextLocations().put(bristolTavern.getName(), bristolTavern);

        bristolTavern.getNextLocations().put(bristolMarket.getName(), bristolMarket);
        bristolTavern.getNextLocations().put(bristolDocks.getName(), bristolDocks);
        bristolMarket.getNextLocations().put(bristolTavern.getName(), bristolTavern);
        bristolMarket.getNextLocations().put(bristolDocks.getName(), bristolDocks);
        bristolDocks.getNextLocations().put(bristolTavern.getName(), bristolTavern);
        bristolDocks.getNextLocations().put(bristolMarket.getName(), bristolMarket);
        bristolDocks.getNextLocations().put(shipMainDeck.getName(), shipMainDeck);
        
        shipMainDeck.getNextLocations().put(shipQuarterdeck.getName(), shipQuarterdeck);
        shipMainDeck.getNextLocations().put(shipRigging.getName(), shipRigging);
        shipMainDeck.getNextLocations().put(shipGalley.getName(), shipGalley);
        shipMainDeck.getNextLocations().put(shipHold.getName(), shipHold);
        shipQuarterdeck.getNextLocations().put(shipMainDeck.getName(), shipMainDeck);
        shipQuarterdeck.getNextLocations().put(shipRigging.getName(), shipRigging);
        shipGalley.getNextLocations().put(shipMainDeck.getName(), shipMainDeck);
        shipGalley.getNextLocations().put(shipCaptainCabin.getName(), shipCaptainCabin);
        shipGalley.getNextLocations().put(shipHold.getName(), shipHold);
        shipCaptainCabin.getNextLocations().put(shipGalley.getName(), shipGalley);
        shipHold.getNextLocations().put(shipGalley.getName(), shipGalley);
        shipHold.getNextLocations().put(shipMainDeck.getName(), shipMainDeck);
        shipRigging.getNextLocations().put(islandHill.getName(), islandHill);
        shipRigging.getNextLocations().put(shipMainDeck.getName(), shipMainDeck);
        
        islandHill.getNextLocations().put(islandStockade.getName(), islandStockade);
        islandHill.getNextLocations().put(islandCave.getName(), islandCave);
        islandStockade.getNextLocations().put(islandHill.getName(), islandHill);
        islandStockade.getNextLocations().put(islandCave.getName(), islandCave);
        islandCave.getNextLocations().put(islandHill.getName(), islandHill);
        islandCave.getNextLocations().put(islandStockade.getName(), islandStockade);
        islandCave.getNextLocations().put(islandX.getName(), islandX);

        String lootCartridgeBox = "Cartridge Box";
        String lootCartridgeCrate = "Cartridge Crate";
        String lootTreasure = "Captain Flint's Treasure";

        innUpperFloor.getLoot().add(Weapon.CUTLASS);
        shipCaptainCabin.getLoot().add(Weapon.SABER);
        islandHill.getLoot().add(Weapon.SCIMITAR);
        shipHold.getLoot().add(Weapon.AXE);
        bristolMarket.getLoot().add(Weapon.PISTOL);
        shipRigging.getLoot().add(Weapon.MUSKET);
        islandStockade.getLoot().add(Weapon.BLUNDERBUSS);

        bristolMarket.getLoot().add(lootCartridgeBox);
        shipRigging.getLoot().add(lootCartridgeBox);
        shipHold.getLoot().add(lootCartridgeBox);
        islandStockade.getLoot().add(lootCartridgeCrate);
        islandX.getLoot().add(lootTreasure);

        List<Location> inn = new ArrayList<>(List.of(
            innGuestRoom,
            innKitchen,
            innUpperFloor,
            innRoadCliffs
        ));
        List<Location> bristol = new ArrayList<>(List.of(
            bristolTavern,
            bristolMarket,
            bristolDocks
        ));
        List<Location> hispaniola = new ArrayList<>(List.of(
            shipMainDeck,
            shipQuarterdeck,
            shipCaptainCabin,
            shipGalley,
            shipHold,
            shipRigging
        ));

        List<Location> island = new ArrayList<>(List.of(
            islandHill,
            islandStockade,
            islandCave,
            islandX
        ));

        levelMap = new ArrayList<>(List.of(
            inn,
            bristol,
            hispaniola,
            island
        ));

    }

    public Game(String gameName) {
        super(gameName);
    }

    @Override
    public Pirate createNewPlayer(String name) {
        return new Pirate(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        
        Pirate player = this.getPlayer(playerIndex); 

        if (player.getCurrentLocation() == null) {
            //  setting the initial location to the guest room of the inn;
            player.setCurrentLocation(levelMap.get(0).get(0));
        }

        Location currentLocation = player.getCurrentLocation();

        int chapterLen = currentLocation.getChapter().toString().length();
        int rem = (90 - 8 - chapterLen)%2;
        int padLen = (90 - 8 - chapterLen)/2;
        System.out.println("-".repeat(padLen) + "    " + currentLocation.getChapter() + "    " + "-".repeat(padLen + rem));
        System.out.println("-".repeat(90));

        System.out.println();
        System.out.println("You are in the %s".formatted(currentLocation.getName()));
        System.out.println(currentLocation.getDescription());
        System.out.println();

        char optnIndex = '1';

        //  mapping weapon options
        Weapon wpn = player.getCurrentWeapon();
        Map<Character, GameAction> wpnMap = new LinkedHashMap<>();
        if (wpn.getRange() > -1) {
            if (!wpn.isLoaded()) {
                wpnMap.put(optnIndex, new GameAction(optnIndex++, "Reload " + wpn.firstLetterUpperCase(), i -> {wpn.reload(); return false;}));
            }
            else {
                wpnMap.put(optnIndex, new GameAction(optnIndex++, "Fire " + wpn.firstLetterUpperCase(), i -> {wpn.fireWeapon(); return false;}));
            }
        }
        wpnMap.put(optnIndex, new GameAction(optnIndex++, "Swing " + wpn.firstLetterUpperCase(), i -> {wpn.swingWeapon(); return false;}));

        //  mapping loot options
        Map<Character, GameAction> lootMap = new LinkedHashMap<>();
        for (Object item : currentLocation.getLoot()) {
            String itemName = item.toString();
            if (item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                itemName = weapon.firstLetterUpperCase();
            }
            lootMap.put(optnIndex, new GameAction(optnIndex++, "Pick up " + itemName, i -> {return pickLoot(i, item);}));
        }

        //  mapping movement options
        Map<Character, GameAction> moveMap = new LinkedHashMap<>();
        for (Location place : currentLocation.getNextLocations().values()) {
            String name = place.getName();
            if (place.getChapter() == currentLocation.getChapter()) {
                moveMap.put(optnIndex, new GameAction(optnIndex++, "Go to the " + name, i -> {return move(i, name);}));
            } 
            else {
                String customPrompt = switch (place.getChapter()) {
                    case Chapter.BRISTOL -> "Get on a coach to Bristol";
                    case Chapter.HMS_HISPANIOLA -> "Finish preparations and set sail";
                    case Chapter.TREASURE_ISLAND -> "Land in sight! Approach and disenbark";
                    default -> "";
                };
                moveMap.put(optnIndex, new GameAction(optnIndex++, customPrompt, i -> {return move(i, name);}));
            }

        }

        Map<Character, GameAction> map = new LinkedHashMap<>();
        map.putAll(wpnMap);
        map.putAll(lootMap);
        map.putAll(moveMap);
        map.putAll(this.getStandardActions());
        return map;

    }
    

    boolean move(int playerIndex, String name) {

        Location next = null;

        for (List<Location> list : levelMap) {
            for (Location location : list) {
                if (location.getName().equals(name)) {
                    next = location;
                }    
            }
        }

        this.getPlayer(playerIndex).setCurrentLocation(next);
        this.getPlayer(playerIndex).addVisitedTown(next.getChapter());

        return false;

    };

    boolean pickLoot(int playerIndex, Object item) {

        if (item instanceof Weapon) {
            Weapon wpn = (Weapon) item;
            Weapon previousWpn = this.getPlayer(playerIndex).getCurrentWeapon();

            this.getPlayer(playerIndex).getCurrentLocation().getLoot().add(previousWpn);
            this.getPlayer(playerIndex).getCurrentLocation().getLoot().remove(item);
            this.getPlayer(playerIndex).equipWeapon(wpn);

            System.out.println("Picked up " + wpn.firstLetterUpperCase() + ".");
        }

        if (item instanceof String) {
            String s = (String) item;
            Weapon wpn = this.getPlayer(playerIndex).getCurrentWeapon();
            switch (s) {
                case "Cartridge Box" -> {wpn.addAmmo(10); System.out.println("Picked up " + s + ". #10 cartridges added.");}
                case "Cartridge Crate" -> {wpn.addAmmo(30); System.out.println("Picked up " + s + ". #30 cartridges added.");}
                case "Captain Flint's Treasure" -> {
                    System.out.println("You have found Captain Flint's hidden treasure!");
                    System.out.println("You have won the game!");
                    return true;
                }
                default -> {}
            };
            this.getPlayer(playerIndex).getCurrentLocation().getLoot().remove(item);
        }

        return false;
    }

    
}
