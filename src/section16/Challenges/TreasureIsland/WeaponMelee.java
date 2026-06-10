package section16.Challenges.TreasureIsland;

enum WeaponMelee {
    
    CUTLASS(40, 4),
    SABER(45, 8),
    SCIMITAR(50, 12),
    AXE(75, 16),
    DAGGER(25, 1);

    private String name;
    private int damage;
    private int level;

    private WeaponMelee(int damage, int minlvl) {
        this.name = this.firstLetterUpperCase();
        this.damage = damage;
        this.level = minlvl;
    }

    void meleeAttack() {
        //todo
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

    String firstLetterUpperCase() {
        String s = this.toString().toUpperCase().charAt(0) + 
                    this.toString().toLowerCase().substring(1);
        return s;
    }

}
