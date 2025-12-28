package section12.Challenges.IntegratingBoundedTypesAndComparators;

public class SubStudent extends Student {

    private double percentComplete;

    //  REMEMBER: this constructor will implicitly call the super constructor!
    public SubStudent() {
        //  Upper bound is excluded, so the maximum value is 100.00!
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.2f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        if (fieldName.equalsIgnoreCase("percentComplete")) {
            return percentComplete <= Double.parseDouble(value);
        }

        return super.matchFieldValue(fieldName, value);

        // String fieldNameUpperCase = fieldName.toUpperCase();
        // return switch(fieldNameUpperCase) {
        //     case "STUDENTID" -> getStudentId() == Integer.parseInt(value);
        //     case "NAME" -> getName().equalsIgnoreCase(value);
        //     case "COURSE" -> getCourse().equalsIgnoreCase(value);
        //     case "YEARSTARTED" -> getYearStarted() == Integer.parseInt(value);
        //     case "PERCENTCOMPLETE" -> percentComplete <= Double.parseDouble(value);
        //     default -> false;
        // };
    }
    
}

