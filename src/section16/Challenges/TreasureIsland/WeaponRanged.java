package section16.Challenges.TreasureIsland;

enum WeaponRanged {

    PISTOL(45, 6, 40),
    MUSKET(65, 12, 120),
    BLUNDERBUSS(95, 18, 80);

    private String name;
    private int damage;
    private int level;
    private int accuracy;
    private boolean loaded; 

    private WeaponRanged(int damage, int minlvl, int accuracy) {
        this.name = this.firstLetterUpperCase();
        this.damage = damage;
        this.level = minlvl;
        this.accuracy = accuracy;
        this.loaded = false;
    }

    boolean fireWeapon() {
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
        System.out.println("Fire " + this.name() + "... " + soundEffect);

        loaded = false;
        return true;
    }

    //todo maybe move this method to combat logic?
    boolean hit(int playerLVL, int distance) {

        double hitProbability = (playerLVL + accuracy - distance) / (double) accuracy;
        //  bounding probabilities between 0% and 100%;
        hitProbability = Math.max(0, Math.min(1, hitProbability));

        //debug
        // System.out.println("%s {acc=%d, lvl=%d, dist=%d} = %.2f%%".formatted(
        //     this, this.accuracy, playerLVL, distance, hitProbability * 100
        // ));

        boolean hit = Math.random() < hitProbability;
        if (hit) {
            System.out.println("Hit!");
        } else {
            System.out.println("Missed");
        }
        return hit;
    }

    int reload(int ammoPool) {
        if (ammoPool < 0) {
            return 0;
        }
        if (this.loaded) {
            System.out.println("%s is already loaded!".formatted(this.name()));
            return 0;
        }
        if (this == BLUNDERBUSS) {
            if (ammoPool < 6) {
                System.out.println("Need #6 shot to reload %s. Insuficient ammunition!".formatted(this.name()));
                return 0;
            }
            this.loaded = true;
            System.out.println("%s is now loaded.".formatted(this.name()));
            //todo move this sout to other place
            System.out.println("#%d shot remaining.".formatted(ammoPool - 6));
            return 6;
        }
        if (ammoPool < 1) {
            System.out.println("Need at least #1 shot to reload %s. Insuficient ammunition!".formatted(this.name()));
            return 0;
        }
        this.loaded = true;
        System.out.println("%s is now loaded.".formatted(this.firstLetterUpperCase()));
        //todo move this sout to other place
        System.out.println("#%d shot remaining.".formatted(ammoPool - 1));
        return 1;
    }


    
    String getName() {
        return name;
    }
    int getDamage() {
        return damage;
    }
    int getLevel() {
        return level;
    }
    int getAccuracy() {
        return accuracy;
    }
    boolean isLoaded() {
        return loaded;
    }

    String firstLetterUpperCase() {
        String s = this.toString().toUpperCase().charAt(0) + 
                    this.toString().toLowerCase().substring(1);
        return s;
    }
    
}
