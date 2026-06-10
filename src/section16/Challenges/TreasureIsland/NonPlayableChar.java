package section16.Challenges.TreasureIsland;

final class NonPlayableChar extends Combatant {

    NonPlayableChar(String name, int level, int xp, int hp, int armor, WeaponMelee meleeWeapon, WeaponRanged rangedWeapon) {
        super(name, level, xp, hp, armor, meleeWeapon, rangedWeapon);
    }

    NonPlayableChar(String name, int level, WeaponMelee meleeWeapon, WeaponRanged rangedWeapon) {
        this(name, level, 0, 100, 0, meleeWeapon, rangedWeapon);
    }
    
}
