package section17.Challenges.StudentEngagement;

import java.time.LocalDate;
import java.time.Period;

    //  each Student should have one CourseEngagement for every Course they are enrolled in;

public class CourseEngagement {
    
    private final Course course;
    private final LocalDate enrollmentDate;
    private String engagementType;
    private int lastLecture;
    private LocalDate lastActivityDate;

    public CourseEngagement(Course course, LocalDate enrollmentDate, String engagementType) {
        this.course = course;
        this.enrollmentDate = this.lastActivityDate = enrollmentDate;
        this.engagementType = engagementType;
    }



    public String getCourseCode() {
        return course.courseCode();
    }

    public int getEnrollmentYear() {
        return enrollmentDate.getYear();
    }

    public int getLastActivityYear() {
        return lastActivityDate.getYear();
    }

    public String getLastActivityMonth() {
        // return lastActivityDate.getMonth().toString();
        return "%tb".formatted(lastActivityDate);
    }

    public int getMonthsSinceActive() {
        Period period = Period.between(lastActivityDate, LocalDate.now());
        // return period.getYears()*12 + period.getMonths();
        return (int) period.toTotalMonths();
    }

    public double getPercentComplete() {
        return (double) (lastLecture*100.00/course.lectureCount());
    }




    // public Course getCourse() {
    //     return course;
    // }

    // public LocalDate getEnrollmentDate() {
    //     return enrollmentDate;
    // }

    public String getEngagementType() {
        return engagementType;
    }

    public int getLastLecture() {
        return lastLecture;
    }

    // public LocalDate getLastActivityDate() {
    //     return lastActivityDate;
    // }



    // void setCourse(Course course) {
    //     this.course = course;
    // }

    // void setEnrollmentDate(LocalDate enrollmentDate) {
    //     this.enrollmentDate = enrollmentDate;
    // }

    // void setEngagementType(String engagementType) {
    //     this.engagementType = engagementType;
    // }

    // void setLastLecture(int lastLecture) {
    //     this.lastLecture = lastLecture;
    // }

    // void setLastActivityDate(LocalDate lastActivityDate) {
    //     this.lastActivityDate = lastActivityDate;
    // }



    void watchLecture(int lectureNumber, LocalDate date) {
        //  students can review past lectures at any time;
        //  but that should not update the lastLecture variable;
        this.lastLecture = Math.max(lectureNumber, lastLecture);
        this.lastActivityDate = date;
        this.engagementType = "Lecture " + lastLecture;
    }



    @Override
    public String toString() {
        return "%s: %s %d %s [%d]".formatted(course.courseCode(),
                getLastActivityMonth(), getLastActivityYear(), engagementType, getMonthsSinceActive());
    }

    

    


    


}
