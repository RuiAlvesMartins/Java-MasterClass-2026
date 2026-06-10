package section16.Challenges.TreasureIsland;

enum Item {
    
    //  each CONSTANT in an ENUM is an ANONYMOUS SUBCLASS of that enum!

    AMMO("Ammo Box"),
    CARTRIDGE_BOX("Cartridge Box"),
    CARTRIDGE_CRATE("Cartridge Crate"),
    TREASURE("Captain Flint's Treasure");

    private final String name;

    private Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //todo also allow NPCs to have a cartridge box
    boolean apply(Combatant player) {
        if (!(player instanceof PlayableChar)) {
            return false;
        }
        PlayableChar p = (PlayableChar) player;
        switch (this) {
            case CARTRIDGE_BOX -> {
                p.getInventory().merge(AMMO, 10, Integer::sum);
                System.out.println("Picked up " + this.getName() + ". #10 cartridges added.");
            }
            case CARTRIDGE_CRATE -> {
                p.getInventory().merge(AMMO, 30, Integer::sum);
                System.out.println("Picked up " + this.getName() + ". #30 cartridges added.");
            }
            case TREASURE -> {
                System.out.println("You have found Captain Flint's hidden treasure!");
                System.out.println("You have won the game!");
                return true;
            }
            default -> {}
        };
        return false;
    }

}
