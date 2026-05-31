package section16.Challenges.PirateInvasion;

public enum Weapon {
    
    CUTLASS(40,4, -1),
    SABER(45,8, -1),
    SCIMITAR(50,12, -1),
    AXE(75,16, -1),
    DAGGER(25,1, -1),
    PISTOL(35,6, 30),
    MUSKET(60,12, 120),
    BLUNDERBUSS(95,18, 60);

    private int damage;
    private int minlvl;
    private int range;
    private int ammo;
    private boolean loaded; 

    private Weapon(int damage, int minlvl, int range) {
        this.damage = damage;
        this.minlvl = minlvl;
        this.range = range;
        this.ammo = 0;
        this.loaded = false;
    }

    public int getRange() {
        return range;
    }

    public boolean isLoaded() {
        return loaded;
    }

    void swingWeapon() {
        System.out.println("Swing %s!".formatted(this.firstLetterUpperCase()));
    }

    void addAmmo(int ammo) {
        if (ammo < 1) {
            return ;
        }
        if (this.range > -1) {
            this.ammo += ammo;
        }
    }

    boolean fireWeapon() {
        if (this.range < 0) {
            // System.out.println("Cannot fire a " + this.firstLetterUpperCase() + "!");
            return false;
        }
        if (!loaded) {
            System.out.println("%s is not loaded!".formatted(this.firstLetterUpperCase()));
            return false;
        }

        String soundEffect = switch(this) {
            case PISTOL -> "tsh'PHEW!";
            case MUSKET -> "tsh'BOOM!!!";
            case BLUNDERBUSS -> "tsh'BOOOOOOOOM!!!!!!!!! %n(your tinitus has grown worse)".formatted();
            default -> "";
        };
        System.out.println("Fire " + this.firstLetterUpperCase() + "... " + soundEffect);

        loaded = false;
        return true;
    }

    boolean reload() {
        if (this.range < 0) {
            // System.out.println("Cannot reload a " + this.firstLetterUpperCase() + "!");
            return false;
        }
        if (loaded) {
            System.out.println("%s is already loaded!".formatted(this.firstLetterUpperCase()));
            return false;
        }
        if (this == BLUNDERBUSS) {
            if (this.ammo < 6) {
                System.out.println("Need at least #6 shot to reload %s. Insuficient ammunition!".formatted(this.firstLetterUpperCase()));
                return false;
            }
            this.ammo-=6;
            this.loaded = true;
            System.out.println("%s is now loaded.".formatted(this.firstLetterUpperCase()));
            System.out.println("#%d shot left for %s.".formatted(this.ammo, this.firstLetterUpperCase()));
            return true;
        }
        if (this.ammo < 1) {
            System.out.println("Need at least #1 shot to reload %s. Insuficient ammunition!".formatted(this.firstLetterUpperCase()));
            return false;
        }
        this.ammo--;
        this.loaded = true;
        System.out.println("%s is now loaded.".formatted(this.firstLetterUpperCase()));
        System.out.println("#%d shot left for %s.".formatted(this.ammo, this.firstLetterUpperCase()));
        return true;
    }

    public int getAmmo() {
        System.out.println("#%d shot left for %s.".formatted(this.ammo, this.firstLetterUpperCase()));
        return ammo;
    }

    String firstLetterUpperCase() {
        String s = this.toString().toUpperCase().charAt(0) + 
                    this.toString().toLowerCase().substring(1);
        return s;
    }

}
