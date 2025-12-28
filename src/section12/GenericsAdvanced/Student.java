package section12.GenericsAdvanced;

import java.util.Random;

public class Student implements QueryItem {

    private String name;
    private String course;
    private int yearStarted;

    private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static String[] courses = {"C++", "Java", "Python"};
    protected static Random random = new Random();

    public Student() {
        //  int lastNameIndex will is used to generate a char type (ASCII / Unicode);
        //  which will be the student's last name initial;
        //  int 65 == 'A'
        //  int 90 == 'Z'
        //  number generated will be exclusive of the upper bound (91)!
        int lastNameIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)] + " " + (char) lastNameIndex + ".";
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2018, 2023);
    }

    @Override
    public String toString() {
        return "%-15s %-15s %d".formatted(name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fieldNameUpperCase = fieldName.toUpperCase();
        return switch(fieldNameUpperCase) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == Integer.parseInt(value);
            default -> false;
        };
    }

}
