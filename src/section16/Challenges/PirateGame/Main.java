package section16.Challenges.PirateGame;

public class Main {
    
    public static void main(String[] args) {
        
        Weapon cutlass = Weapon.CUTLASS;
        Weapon axe = Weapon.AXE;
        Weapon pistol = Weapon.PISTOL;
        Weapon blunderbuss = Weapon.BLUNDERBUSS;

        System.out.println(cutlass);
        cutlass.addAmmo(10);
        System.out.println(cutlass);
        cutlass.fireWeapon();
        cutlass.reload();

        axe.fireWeapon();
        axe.reload();

        pistol.addAmmo(5);
        pistol.fireWeapon();
        pistol.getAmmo();
        pistol.reload();
        pistol.fireWeapon();
        pistol.getAmmo();
        pistol.fireWeapon();
        pistol.reload();
        pistol.getAmmo();

        blunderbuss.addAmmo(5);
        blunderbuss.reload();
        blunderbuss.getAmmo();
        blunderbuss.addAmmo(7);
        blunderbuss.reload();
        blunderbuss.fireWeapon();
        blunderbuss.swingWeapon();

        Game g = new Game(null);
        System.out.println(g.levelMap.get(0).get(0).getName());


    }

}
