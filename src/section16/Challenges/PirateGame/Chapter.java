package section16.Challenges.PirateGame;

enum Chapter {
    
    ADMIRAL_BENBOWS_INN,
    BRISTOL,
    HMS_HISPANIOLA,
    TREASURE_ISLAND;

    @Override
    public String toString() {
        return super.toString().replace("_", " ");
    }
  

}
