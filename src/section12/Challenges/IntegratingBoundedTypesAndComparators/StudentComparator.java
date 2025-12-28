package section12.Challenges.IntegratingBoundedTypesAndComparators;

import java.util.Comparator;

public class StudentComparator implements Comparator<SubStudent> {

    @Override
    public int compare(SubStudent o1, SubStudent o2) {
        return Double.valueOf(o1.getPercentComplete()).compareTo(Double.valueOf(o2.getPercentComplete()));
    }

}
