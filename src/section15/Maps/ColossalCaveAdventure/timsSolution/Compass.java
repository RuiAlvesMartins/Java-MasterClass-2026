package section15.Maps.ColossalCaveAdventure.timsSolution;

enum Compass {
    
    E, N, S, W;

    private static final String[] directions = {"East", "North", "South", "West"};

    @Override
    public String toString() {
        //  this.ordinal() returns the index of the enum;
        //  e.g. 'S' will return index 2 (remember index starts at 0);
        //  directions[2] will return "South";
        return directions[this.ordinal()];
    }  
        
}