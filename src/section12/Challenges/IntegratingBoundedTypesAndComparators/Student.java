package section12.Challenges.IntegratingBoundedTypesAndComparators;

import java.util.Random;

public class Student implements QueryItem, Comparable<Student> {

    private int studentId;
    private String name;
    private String course;
    private int yearStarted;

    private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static String[] courses = {"C++", "Java", "Python"};
    protected static Random random = new Random();
    private static int STATIC_ID = random.nextInt(333_222_111, 1_000_000_000);

    public Student() {
        studentId = STATIC_ID++;
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
        return "%-15d %-15s %-15s %d".formatted(studentId, name, course, yearStarted);
    }

    protected int getStudentId() {
        return studentId;
    }
    protected String getName() {
        return name;
    }
    protected String getCourse() {
        return course;
    }
    protected int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fieldNameUpperCase = fieldName.toUpperCase();
        return switch(fieldNameUpperCase) {
            case "STUDENTID" -> studentId == Integer.parseInt(value);
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == Integer.parseInt(value);
            default -> false;
        };
    }

    @Override
    public int compareTo(Student student) {
        //  You cant call .compareTo from a primitive (int), nor pass one as argument;
        //  So you must wrap it first (Integer.valueOf());
        return Integer.valueOf(studentId).compareTo(Integer.valueOf(student.studentId));
    }

}

