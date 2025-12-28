package section12.GenericClasses;

public record BaseballPlayer(String name, String position) implements Player {

    //  Record has an implicit EQUALS() method, that we can use to compare objects;
    //  Records can IMPLEMENT interfaces but can NOT EXTEND Abstract Classes!

    //  This constructor is not necessary, as Records already have an ALL-ARGS constructor by default;
    // public BaseballPlayer(String name, String position) {
    //     this.name = name;
    //     this.position = position;
    // }

}
