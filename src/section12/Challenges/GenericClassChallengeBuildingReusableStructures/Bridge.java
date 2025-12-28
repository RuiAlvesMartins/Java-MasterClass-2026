package section12.Challenges.GenericClassChallengeBuildingReusableStructures;

public class Bridge implements Mappable {

    private Point point;
    private String name;
    private String locality;
    private River river;

    public Bridge(double latitude, double longitude, String name, String locality, River river) {
        this.point = new Point(latitude, longitude);
        this.name = name;
        this.locality = locality;
        this.river = river;
    }

    public Point getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    public String getLocality() {
        return locality;
    }

    public River getRiver() {
        return river;
    }

    public String render() {
        String string = "Render %s as %s (%s)".formatted(
                            this.name, 
                            this.point.getClass().getSimpleName().toUpperCase(),
                            this.point.render()
                        );
        return string;
    }

}
