package section11.Challenges.MappableClasses;

enum UsageType {
    BUSINESS,
    ENTERTAINMENT,
    GOVERNMENT,
    RESIDENTIAL,
    SPORTS
}

public class Building implements Mappable {

    //  geometry POINT

    private String name;
    private UsageType usage;

    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }
    @Override
    public String getLabel() {
        return name + " (" + usage + ")";
    }
    @Override
    public String getMarker() {
        return switch (usage) {
            case ENTERTAINMENT -> Color.GREEN + " " + PointMarker.TRIANGLE;
            case GOVERNMENT -> Color.RED + " " + PointMarker.STAR;
            case RESIDENTIAL -> Color.BLUE + " " + PointMarker.SQUARE;
            case SPORTS -> Color.YELLOW + " " + PointMarker.CIRCLE;
            default -> Color.WHITE + " " + PointMarker.DIAMOND;
        };
    } 

    //  you can't use default keyword when overriding a DEFAULT method!
    @Override
    public String toJSON() {
        //  call to the default method on interface;
        return Mappable.super.toJSON() + """
                , "name": "%s", "usage": "%s" """.formatted(name, usage);
    }

}
