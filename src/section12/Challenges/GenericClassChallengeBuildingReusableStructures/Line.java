package section12.Challenges.GenericClassChallengeBuildingReusableStructures;

import java.util.ArrayList;
import java.util.List;

public class Line implements Mappable {

    //  Line will be modeled as a list of points, each with a double value for latitude and longitude;
    private List<Point> points; 

    public Line() {
        this.points = new ArrayList<>();
    }

    public List<Point> getPoints() {
        return points;
    }
    
    public boolean addPoint(Point p, int index) {
        if (findPoint(p) != null) {
            //  point already on the list!
            return false;
        }
        if (index < 0 || index > points.size()) {
            //  index out of bounds!
            return false;
        }
        //  point is added;
        //  .add() on ArrayList automatically shifts other elements to the right!
        points.add(index, p);
        return true;
    }

    public boolean addPoint(Point p) {
        //  adds element to the end of the list
        return addPoint(p, points.size());
    }

    private Point findPoint(Point p) {
        for (Point point : points) {
            if (point.getLatitude() == p.getLatitude() &&
                point.getLongitude() == p.getLongitude()) {
                //  point already on the list!
                return point;
            }
        }
        //  point not found;
        return null;
    }

    @Override
    public String render() {
        String stringLine = "[";
        for (Point p : points) {
            stringLine = stringLine + p.render();
        }
        return stringLine + "]";
    }

}
