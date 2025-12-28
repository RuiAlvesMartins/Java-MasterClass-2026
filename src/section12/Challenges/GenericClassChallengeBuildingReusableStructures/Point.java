package section12.Challenges.GenericClassChallengeBuildingReusableStructures;

public class Point implements Mappable {

    //  Point will be modeled as two doubles, latitude and longitude;
    private double latitude;
    private double longitude;
    
    public Point(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String render() {
        String stringPoint = "[%2.14f, %2.14f]".formatted(latitude, longitude);
        return stringPoint;
    }

}
