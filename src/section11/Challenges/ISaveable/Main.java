package section11.Challenges.ISaveable;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        Player luis = new Player("Luis", 6, 9);
        luis.setWeapon("Wodden Nose");

        List luisList = luis.write();
        System.out.println(luisList);

        Player hermanJose = new Player("Herman José", 66, 99);
        hermanJose.read(luisList);
        System.out.println(hermanJose);


    }

}
