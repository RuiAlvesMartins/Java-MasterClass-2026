package section17.Challenges.StudentEngagement;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

public class MainPart2 {
    
    public static void main(String[] args) {
        
        Course pymc = new Course("PYMC","Python Masterclass", 50);
        Course jmc = new Course("JMC","Java Masterclass", 100);
        // Course sbmc = new Course("SBMC","SpringBoot Masterclass");
        // Course cmc = new Course("CMC","C Masterclass");
        Course gdj = new Course("GDJ","Java for Game Development");

        List<Student> studentsList = Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
                .limit(5000)
                .sorted(Comparator.comparing(Student::getStudentID))
                .toList()
        ;

        // studentsList = Stream.iterate(0, i -> i<5000, i -> i+1)                 //  careful! don't use i++ on Stream.iterate()!
        //         .map(i -> Student.getRandomStudent(pymc, jmc, gj))
        //         .sorted(Comparator.comparing(Student::getStudentID))
        //         .toList()
        // ;



        var javaStudentCount = studentsList.stream()
                .filter(s -> s.getEngagementMap().get("JMC") != null)
                .count()
        ;
        // System.out.println("#%d students are enrolled in the Java MasterClass".formatted(javaStudentCount));

        var completionSum = studentsList.stream()
                .filter(s -> s.getEngagementMap().get("JMC") != null)
                .map(s -> s.getEngagementMap().get("JMC").getPercentComplete())
                .reduce(0.0, (r, v) -> r + v)
        ;
        double averageCompletion = completionSum/javaStudentCount;
        System.out.println("averageCompletion = %.2f%%".formatted(averageCompletion));

        double completionFloor = averageCompletion * 1.25D;
        System.out.println("completionFloor = %.2f%%".formatted(completionFloor));

        var subSetStudents = studentsList.stream()
                .filter(s -> s.getEngagementMap().get("JMC") != null)
                .filter(s -> s.getEngagementMap().get("JMC").getPercentComplete() > completionFloor)
                .collect(() -> new TreeSet<>(Comparator.comparing(Student::getStudentID)), TreeSet::add, TreeSet::addAll)
        ;
        // subSetStudents.stream().forEach(s -> System.out.print(s.getStudentID() + " "));
        System.out.println("#%d students above completion floor".formatted(subSetStudents.stream().count()));

        subSetStudents.stream()
                .filter(s -> s.getMonthsSinceActive() == 0)
                .sorted(Comparator.comparing(Student::getYearsSinceEnrolled).reversed())
                .limit(10)
                // .peek(s -> System.out.println(s))
                .forEach(student -> student.addCourse(gdj))
        ;
        
        var gameDevelopmentStudents = studentsList.stream()
                .filter(s -> s.getEngagementMap().get("GDJ") != null)
                .peek(s -> System.out.println(s))
                .count()
        ;
        System.out.println("#%d students enrolled in Game Development with Java.".formatted(gameDevelopmentStudents));



    }

}
