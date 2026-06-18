package section17.Challenges.StudentEngagement;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Student {
    
    private static long lastStudentID = 1;
    private final static Random random = new Random();

    private final long studentID;
    private final String countryCode;
    private final int yearEnrolled;
    private final int ageEnrolled;
    private final String gender;
    private final boolean programmingExperience;
    private final Map<String, CourseEngagement> engagementMap = new HashMap<>();

    public Student(String countryCode, int yearEnrolled, int ageEnrolled, String gender,
            boolean programmingExperience, Course... courses) {
        this.studentID = lastStudentID++;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageEnrolled = ageEnrolled;
        this.gender = gender;
        this.programmingExperience = programmingExperience;

        for (Course course : courses) {
            this.addCourse(course, LocalDate.of(yearEnrolled, 1, 1));
        }
    }



    public long getStudentID() {
        return studentID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getYearEnrolled() {
        return yearEnrolled;
    }

    public int getAgeEnrolled() {
        return ageEnrolled;
    }

    public String getGender() {
        return gender;
    }

    public boolean hasProgrammingExperience() {
        return programmingExperience;
    }

    public Map<String, CourseEngagement> getEngagementMap() {
        //  defensive copy
        return Map.copyOf(engagementMap);
    }



    public void addCourse(Course course) {
        this.addCourse(course, LocalDate.now());
    }
    public void addCourse(Course course, LocalDate enrollDate) {
        engagementMap.put(course.courseCode(), new CourseEngagement(course, enrollDate, "Enrollment"));
    }
    public int getAge() {
        return ageEnrolled + this.getYearsSinceEnrolled();
    }
    public int getMonthsSinceActive(String courseCode) {
        // return engagementMap.get(courseCode).getMonthsSinceActive();
        CourseEngagement ce = engagementMap.get(courseCode);
        return ce == null ? 0 : ce.getMonthsSinceActive();
    }
    public int getMonthsSinceActive() {
        int mostRecentActivity = (LocalDate.now().getYear() - 2014) * 12;
        for (String courseCode : engagementMap.keySet()) {
            mostRecentActivity = Math.min(mostRecentActivity, getMonthsSinceActive(courseCode));
        }
        return mostRecentActivity; 
    }
    public double getPercentComplete(String courseCode) {
        CourseEngagement ce = engagementMap.get(courseCode);
        return ce == null ? 0.0 : ce.getPercentComplete();

    }
    public int getYearsSinceEnrolled() {
        return LocalDate.now().getYear() - yearEnrolled;

    }
    public void watchLecture(String courseCode, int lectureNumber, int month, int year) {
        LocalDate date = LocalDate.of(year, month, 1);
        CourseEngagement ce = engagementMap.get(courseCode);
        if (ce != null) {
            ce.watchLecture(lectureNumber, date);
        }
        // engagementMap.get(countryCode).watchLecture(lectureNumber, date);
    }
    public static Student getRandomStudent(Course... courses) {
        int maxYear = LocalDate.now().getYear() + 1;
        Student student = new Student(
                getRandomVal("AU", "CA", "CN", "GB", "IN", "UA", "US"), 
                random.nextInt(2015, maxYear), 
                random.nextInt(18, 90), 
                getRandomVal("M", "F", "T"), 
                random.nextBoolean(), 
                courses
        );

        for (Course course : courses) {
            int lecture = random.nextInt(1, course.lectureCount());
            int year = random.nextInt(student.getYearEnrolled(), maxYear);
            int month = random.nextInt(1, 13);
            if (year == (maxYear - 1)) {
                if (month > LocalDate.now().getMonthValue()) {
                    month = LocalDate.now().getMonthValue();
                }
            }
            student.watchLecture(course.courseCode(), lecture, month, year);
        }

        return student;
    }



    private static String getRandomVal(String... data) {
        return data[random.nextInt(data.length)];
    }

    @Override
    public String toString() {
        return "Student [studentID=" + studentID + ", countryCode=" + countryCode + ", yearEnrolled=" + yearEnrolled
                + ", ageEnrolled=" + ageEnrolled + ", gender=" + gender + ", programmingExperience="
                + programmingExperience + ", engagementMap=" + engagementMap + "]";
    }

}
