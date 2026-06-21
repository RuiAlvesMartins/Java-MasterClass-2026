package section17.Challenges.StudentEngagement;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainPart3 {
    
    public static void main(String[] args) {
        
        Course pymc = new Course("PYMC","Python Masterclass", 50);
        Course jmc = new Course("JMC","Java Masterclass", 100);
        Course sbmc = new Course("SBMC","SpringBoot Masterclass", 42);
        Course cmc = new Course("CMC","C Masterclass", 60);
        Course gdj = new Course("GDJ","Java for Game Development");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(pymc, jmc, sbmc, cmc, gdj))
                .filter(s -> s.getYearsSinceEnrolled() <= 4)
                .limit(10000)
                .sorted(Comparator.comparing(Student::getStudentID))
                .toList()
        ;
        System.out.println(students.stream().mapToInt(Student::getYearEnrolled).summaryStatistics());



        var maxEnrollmentDate = students.stream()
                .map(s -> s.getYearsSinceEnrolled())
                .max(Comparator.naturalOrder())
                .orElse(null)
        ;
        System.out.println("First student enrolled %d years ago.".formatted(maxEnrollmentDate));

        var maxEnrolledCourses = students.stream()
                .map(s -> s.getEngagementMap().size())
                .max(Comparator.naturalOrder())
                .orElse(null)
        ;
        System.out.println("Max # enrolled courses = %d".formatted(maxEnrolledCourses));

        var minEnrolledCourses = students.stream()
                .map(s -> s.getEngagementMap().size())
                .min(Comparator.naturalOrder())
                .orElse(null)
        ;
        System.out.println("Min # enrolled courses = %d".formatted(minEnrolledCourses));

        var avgEnrolledCourses = students.stream()
                .map(s -> s.getEngagementMap().size())
                .mapToInt(i -> i)
                .average()
                .orElse(0.00)
        ;
        System.out.println("Avg # enrolled courses = %.2f".formatted(avgEnrolledCourses));

        System.out.println(students.stream().mapToInt(s -> s.getEngagementMap().size()).summaryStatistics());



        System.out.println();
        var studentsPerCourse = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(
                                CourseEngagement::getCourseCode, 
                                Collectors.counting()
                        )
                )
        ;
        studentsPerCourse.forEach((k, v) -> System.out.println("Enrolled in %s course: %d students".formatted(k, v)));

        System.out.println();
        var coursesPerStudent = students.stream()
                .collect(Collectors.groupingBy(
                                s -> s.getEngagementMap().size(),
                                Collectors.counting()
                        )
                )
        ;
        coursesPerStudent.forEach((k, v) -> System.out.println("Enrolled in %d courses: %d students".formatted(k, v)));

        System.out.println();
        var completionPerCourse = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(
                                        CourseEngagement::getCourseCode,
                                        Collectors.averagingDouble(CourseEngagement::getPercentComplete)
                                        // Collectors.summarizingDouble(CourseEngagement::getPercentComplete)
                                )
                        )
        ;
        completionPerCourse.forEach((k, v) -> System.out.println("Avg completion in %s course: %.2f%%".formatted(k, v)));

        System.out.println();
        var activityPerCourse = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(
                                CourseEngagement::getCourseCode, 
                                Collectors.groupingBy(
                                                CourseEngagement::getLastActivityYear,
                                                Collectors.counting()
                                        )
                                )
                        )
        ;
        activityPerCourse.forEach((k, v) -> {
                System.out.println(k + " course activity:");
                for (var k1 : v.keySet()) {
                        System.out.println("%d: %d last active students".formatted(k1, v.get(k1)));
                }
                System.out.println();
        });

        System.out.println();
        var enrollmentYearPerCourse = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(
                                CourseEngagement::getCourseCode, 
                                Collectors.groupingBy(
                                                CourseEngagement::getEnrollmentYear,
                                                Collectors.counting()
                                        )
                                )
                        )
        ;
        enrollmentYearPerCourse.forEach((k, v) -> {
                System.out.println(k + " course enrollment:");
                for (var k1 : v.keySet()) {
                        System.out.println("%d: %d students".formatted(k1, v.get(k1)));
                }
                System.out.println();
        });
        
        

    }

}
