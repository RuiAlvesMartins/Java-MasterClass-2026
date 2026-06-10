package section16.Challenges.TreasureIsland;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import section16.Challenges.GameConsole.GameAction;

public class Game extends section16.Challenges.GameConsole.Game<Combatant> {

    //  game will have different levels
    //  each level will have a list of towns (string)
    final List<List<Location>> levelMap;

    {

        System.out.println("Loading game data...");

        Location innGuestRoom =
            new Location(
                Chapter.ADMIRAL_BENBOWS_INN,
                "Guest Room",
                "A small room overlooking the sea. The old captain keeps watch here."
                );

        Location innKitchen =
            new Location(
                Chapter.ADMIRAL_BENBOWS_INN,
                "Kitchen",
                "The warm heart of the inn, filled with the smell of stew and fresh bread."
                );

        Location innUpperFloor =
            new Location(
                Chapter.ADMIRAL_BENBOWS_INN,
                "Upper Floor",
                "A creaking upstairs hallway lined with guest rooms and sea-worn floorboards."
                );

        Location innRoadCliffs =
            new Location(
                Chapter.ADMIRAL_BENBOWS_INN,
                "Road to the Cliffs",
                "A windswept path above the sea with a clear view of approaching ships."
                );

        Location bristolTavern =
            new Location(
                Chapter.BRISTOL,
                "Spy-Glass Tavern",
                "A bustling sailors' tavern owned by the charismatic Long John Silver."
                );

        Location bristolMarket =
            new Location(
                Chapter.BRISTOL,
                "Market",
                "Merchants shout their wares as townsfolk crowd the busy streets."
                );

        Location bristolDocks =
            new Location(
                Chapter.BRISTOL,
                "Docks",
                "Tall ships sway in the harbor while crews prepare for distant voyages."
                );

        Location shipMainDeck =
            new Location(
                Chapter.HMS_HISPANIOLA,
                "Main Deck",
                "The ship's busy center where sailors work beneath the white sails and the open sky."
                );

        Location shipQuarterdeck =
            new Location(
                Chapter.HMS_HISPANIOLA,
                "Quarterdeck",
                "The officers' domain with a commanding view of the entire deck."
                );

        Location shipCaptainCabin =
            new Location(
                Chapter.HMS_HISPANIOLA,
                "Captain's Cabin",
                "Charts and instruments are strewn around the table, with the captain's personal sabers and silverware adorning the walls."
                );

        Location shipGalley =
            new Location(
                Chapter.HMS_HISPANIOLA,
                "Galley",
                "The cook's workplace, rich with the scent of salted meat and stew."
                );

        Location shipHold =
            new Location(
                Chapter.HMS_HISPANIOLA,
                "Cargo Hold",
                "A dark storage space packed with barrels, supplies, and hidden weaponry."
                );

        Location shipRigging =
            new Location(
                Chapter.HMS_HISPANIOLA,
                "Rigging",
                "High above the deck, the wind is tangled in a web of ropes and sails. From here, one has a sweeping view of the ocean."
                );

        Location islandHill =
            new Location(
                Chapter.TREASURE_ISLAND,
                "Spy-Glass Hill",
                "The highest point on the island, offering a panoramic view in every direction."
                );

        Location islandStockade =
            new Location(
                Chapter.TREASURE_ISLAND,
                "Stockade",
                "A rough wooden fort built for defense against a pirate attack."
                );

        Location islandX =
            new Location(
                Chapter.TREASURE_ISLAND,
                "Captain Flint's 'X'",
                "The legendary spot marked on the map where Captain Flint's treasure is said to lie buried."
                );

        Location islandCave =
            new Location(
                Chapter.TREASURE_ISLAND,
                "Ben's Cave",
                "A hidden refuge where Ben Gunn has survived alone for years."
                );

        innGuestRoom.directions().put(innKitchen.name(), innKitchen);
        innGuestRoom.directions().put(innUpperFloor.name(), innUpperFloor);
        innGuestRoom.directions().put(innRoadCliffs.name(), innRoadCliffs);
        innKitchen.directions().put(innGuestRoom.name(), innGuestRoom);
        innUpperFloor.directions().put(innGuestRoom.name(), innGuestRoom);
        innRoadCliffs.directions().put(innGuestRoom.name(), innGuestRoom);
        innRoadCliffs.directions().put(bristolTavern.name(), bristolTavern);

        bristolTavern.directions().put(bristolMarket.name(), bristolMarket);
        bristolTavern.directions().put(bristolDocks.name(), bristolDocks);
        bristolMarket.directions().put(bristolTavern.name(), bristolTavern);
        bristolMarket.directions().put(bristolDocks.name(), bristolDocks);
        bristolDocks.directions().put(bristolTavern.name(), bristolTavern);
        bristolDocks.directions().put(bristolMarket.name(), bristolMarket);
        bristolDocks.directions().put(shipMainDeck.name(), shipMainDeck);
        
        shipMainDeck.directions().put(shipQuarterdeck.name(), shipQuarterdeck);
        shipMainDeck.directions().put(shipRigging.name(), shipRigging);
        shipMainDeck.directions().put(shipGalley.name(), shipGalley);
        shipMainDeck.directions().put(shipHold.name(), shipHold);
        shipQuarterdeck.directions().put(shipMainDeck.name(), shipMainDeck);
        shipQuarterdeck.directions().put(shipRigging.name(), shipRigging);
        shipGalley.directions().put(shipMainDeck.name(), shipMainDeck);
        shipGalley.directions().put(shipCaptainCabin.name(), shipCaptainCabin);
        shipGalley.directions().put(shipHold.name(), shipHold);
        shipCaptainCabin.directions().put(shipGalley.name(), shipGalley);
        shipHold.directions().put(shipGalley.name(), shipGalley);
        shipHold.directions().put(shipMainDeck.name(), shipMainDeck);
        shipRigging.directions().put(islandHill.name(), islandHill);
        shipRigging.directions().put(shipMainDeck.name(), shipMainDeck);
        
        islandHill.directions().put(islandStockade.name(), islandStockade);
        islandHill.directions().put(islandCave.name(), islandCave);
        islandStockade.directions().put(islandHill.name(), islandHill);
        islandStockade.directions().put(islandCave.name(), islandCave);
        islandCave.directions().put(islandHill.name(), islandHill);
        islandCave.directions().put(islandStockade.name(), islandStockade);
        islandCave.directions().put(islandX.name(), islandX);

        innUpperFloor.loot().put(WeaponMelee.CUTLASS.getName(), WeaponMelee.CUTLASS);
        shipCaptainCabin.loot().put(WeaponMelee.SABER.getName(), WeaponMelee.SABER);
        islandHill.loot().put(WeaponMelee.SCIMITAR.getName(), WeaponMelee.SCIMITAR);
        shipHold.loot().put(WeaponMelee.AXE.getName(), WeaponMelee.AXE);
        bristolMarket.loot().put(WeaponRanged.PISTOL.getName(), WeaponRanged.PISTOL);
        shipRigging.loot().put(WeaponRanged.MUSKET.getName(), WeaponRanged.MUSKET);
        islandStockade.loot().put(WeaponRanged.BLUNDERBUSS.getName(), WeaponRanged.BLUNDERBUSS);

        bristolMarket.loot().put(Item.CARTRIDGE_BOX.getName(), Item.CARTRIDGE_BOX);
        shipRigging.loot().put(Item.CARTRIDGE_BOX.getName(), Item.CARTRIDGE_BOX);
        shipHold.loot().put(Item.CARTRIDGE_BOX.getName(), Item.CARTRIDGE_BOX);
        islandStockade.loot().put(Item.CARTRIDGE_CRATE.getName(), Item.CARTRIDGE_CRATE);
        islandX.loot().put(Item.TREASURE.getName(), Item.TREASURE);

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

        System.out.println("Game data loaded successfully");

    }

    public Game(String gameName) {
        super(gameName);
    }

    @Override
    //todo sould you instantiate combatant?
    public Combatant createNewPlayer(String name) {
        return new PlayableChar(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        
        Combatant player = this.getPlayer(playerIndex); 

        if (player.getCurrentLocation() == null) {
            //  setting the initial location to the guest room of the inn;
            player.setCurrentLocation(levelMap.get(0).get(0));
        }

        Location currentLocation = player.getCurrentLocation();

        int chapterLen = currentLocation.chapter().toString().length();
        int rem = (90 - 8 - chapterLen)%2;
        int padLen = (90 - 8 - chapterLen)/2;
        System.out.println("-".repeat(padLen) + "    " + currentLocation.chapter() + "    " + "-".repeat(padLen + rem));
        System.out.println("-".repeat(90));

        System.out.println();
        System.out.println("You are in the %s".formatted(currentLocation.name()));
        System.out.println(currentLocation.description());
        System.out.println();

        char optnIndex = '1';

        //  mapping weapon options
        WeaponMelee mlWpn = player.getMeleeWeapon();
        WeaponRanged rgWpn = player.getRangedWeapon();

        Map<Character, GameAction> wpnMap = new LinkedHashMap<>();
        if (!(rgWpn == null)) {
            if (!rgWpn.isLoaded()) {
                //todo allow NPCs to reload too!
                int ammoPool = ((PlayableChar) this.getPlayer(playerIndex)).getInventory().getOrDefault(Item.AMMO, 0);
                wpnMap.put(optnIndex, new GameAction(optnIndex++, "Reload " + rgWpn.getName(), i -> {
                    int ammoSpent = rgWpn.reload(ammoPool);
                    ((PlayableChar) this.getPlayer(playerIndex)).getInventory().put(Item.AMMO, ammoPool - ammoSpent);
                    return false;
                }));
            }
            else {
                wpnMap.put(optnIndex, new GameAction(optnIndex++, "Fire " + rgWpn.getName(), i -> {rgWpn.fireWeapon(); return false;}));
            }
        }
        if (!(mlWpn == null)) {
            wpnMap.put(optnIndex, new GameAction(optnIndex++, "Swing " + mlWpn.getName(), i -> {mlWpn.meleeAttack(); return false;}));    
        }

        //  mapping loot options
        Map<Character, GameAction> lootMap = new LinkedHashMap<>();
        for (Object item : currentLocation.loot().values()) {
            String itemName = null;
            if (item instanceof WeaponMelee weaponMelee) {itemName = weaponMelee.getName();}
            if (item instanceof WeaponRanged weaponRanged) {itemName = weaponRanged.getName();}
            if (item instanceof Item itm) {itemName = itm.getName();}
            lootMap.put(optnIndex, new GameAction(optnIndex++, "Pick up " + itemName, i -> {return pickLoot(i, item);}));
        }

        //  mapping movement options
        Map<Character, GameAction> moveMap = new LinkedHashMap<>();
        for (Location place : currentLocation.directions().values()) {
            String name = place.name();
            if (place.chapter() == currentLocation.chapter()) {
                moveMap.put(optnIndex, new GameAction(optnIndex++, "Go to the " + name, i -> {return move(i, name);}));
            } 
            else {
                String customPrompt = switch (place.chapter()) {
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
                if (location.name().equals(name)) {
                    next = location;
                }    
            }
        }

        this.getPlayer(playerIndex).setCurrentLocation(next);
        if (this.getPlayer(playerIndex) instanceof PlayableChar) {
            PlayableChar playableChar = (PlayableChar) this.getPlayer(playerIndex);
            playableChar.addVisitedTown(next.chapter());
        }

        return false;

    };

    boolean pickLoot(int playerIndex, Object item) {

        if (item instanceof WeaponMelee) {
            WeaponMelee wpn = (WeaponMelee) item;
            WeaponMelee previousWpn = this.getPlayer(playerIndex).getMeleeWeapon();

            if (this.getPlayer(playerIndex).equipMeleeWeapon(wpn)) {
                if (!(previousWpn == null)) {
                    this.getPlayer(playerIndex).getCurrentLocation().loot().put(previousWpn.getName(), previousWpn);
                }
                this.getPlayer(playerIndex).getCurrentLocation().loot().remove(wpn.getName());
                System.out.println("Picked up " + wpn.name() + ".");
            }

        }

        if (item instanceof WeaponRanged) {
            WeaponRanged wpn = (WeaponRanged) item;
            WeaponRanged previousWpn = this.getPlayer(playerIndex).getRangedWeapon();

            if (this.getPlayer(playerIndex).equipRangedWeapon(wpn)) {
                if (!(previousWpn == null)) {
                    this.getPlayer(playerIndex).getCurrentLocation().loot().put(previousWpn.getName(), previousWpn);    
                }
                this.getPlayer(playerIndex).getCurrentLocation().loot().remove(wpn.getName());
                System.out.println("Picked up " + wpn.name() + ".");
            }

        }

        boolean wonGame = false;

        if (item instanceof Item) {
            Item i = (Item) item;
            wonGame = i.apply(this.getPlayer(playerIndex));
            this.getPlayer(playerIndex).getCurrentLocation().loot().remove(i.getName());
        }

        return wonGame;
    }

    
}
