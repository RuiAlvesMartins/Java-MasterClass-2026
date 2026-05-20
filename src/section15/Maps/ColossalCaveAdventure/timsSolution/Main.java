package section15.Maps.ColossalCaveAdventure.timsSolution;

public class Main {
    
    public static void main(String[] args) {
        
        String myCustomLocations = """        
                lake,at the edge of Lake Tim,E:ocean,W:forest,S:well house,N:cave
                ocean,on Tim's beach before an angry sea,W:lake
                cave,at the mouth of Tim's bat cave,E:ocean,W:forest,S:lake
                """;


        AdventureGame game = new AdventureGame(myCustomLocations);

        game.run("road");

    }

}
