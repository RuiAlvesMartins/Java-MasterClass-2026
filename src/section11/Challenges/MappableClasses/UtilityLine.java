package section11.Challenges.MappableClasses;

enum UtilityType {
    ELECTRICAL,
    FIBER_OPTIC,
    GAS,
    WATER,
    INFRASTRUCTURE
}

public class UtilityLine implements Mappable {

    //  geometry LINE

    private String name;
    private UtilityType utility;
  
    public UtilityLine(String name, UtilityType utility) {
        this.name = name;
        this.utility = utility;
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }
    @Override
    public String getLabel() {
        return name + " (" + utility + ")";
    }
    @Override
    public String getMarker() {
        return switch (utility) {
            case ELECTRICAL -> Color.RED + " " + LineMarker.DASHED;
            case FIBER_OPTIC -> Color.GREEN + " " + LineMarker.DOTTED;
            case GAS -> Color.ORANGE + " " + LineMarker.SOLID;
            case WATER -> Color.BLUE + " " + LineMarker.SOLID;
            default -> Color.BLACK + " " + LineMarker.SOLID;
        };
    } 

    //  you can't use default keyword when overriding a DEFAULT method!
    @Override
    public String toJSON() {
        //  call to the default method on interface;
        return Mappable.super.toJSON() + """
                , "name": "%s", "utility": "%s" """.formatted(name, utility);
    }

}
