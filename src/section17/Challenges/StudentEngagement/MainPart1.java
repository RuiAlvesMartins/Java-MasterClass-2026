package section17.Challenges.StudentEngagement;

import java.util.Arrays;
import java.util.stream.Stream;

public class MainPart1 {
    
    public static void main(String[] args) {
        
        Course pymc = new Course("PYMC","Python Masterclass");
        Course jmc = new Course("JMC","Java Masterclass");
        Course sbmc = new Course("SBMC","SpringBoot Masterclass");
        Course cmc = new Course("CMC","C Masterclass");

        // Student tim = new Student("AU",2019,30,"M", true, jmc, pymc);
        // System.out.println(tim);
        // tim.watchLecture("JMC", 10, 5, 2019);
        // tim.watchLecture("PYMC", 7, 7, 2020);
        // System.out.println(tim);

        // Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
        //         .limit(10)
        //         .forEach(System.out::println);
        // ;



        Student[] students = new Student[1000];
        Arrays.setAll(students, (i) -> Student.getRandomStudent(jmc, sbmc, cmc, pymc));



        var maleStudents = Stream.of(students)
                .filter(student -> student.getGender() == "M")
                .count()
        ;
        System.out.println("There are %d male students.".formatted(maleStudents));

        var femaleStudents = Stream.of(students)
                .filter(student -> student.getGender() == "F")
                .count()
        ;
        System.out.println("There are %d female students.".formatted(femaleStudents));
                var transStudents = Stream.of(students)
                .filter(student -> student.getGender() == "T")
                .count()
        ;
        System.out.println("There are %d transgender students.".formatted(transStudents));



        var underThirty = Stream.of(students)
                .filter(student -> student.getAge() < 30)
                .count()
        ;
        System.out.println("There are %d students under 30 years old.".formatted(underThirty));

        var betweenThirtyAndSixty = Stream.of(students)
                .filter(student -> student.getAge() >= 30)
                .filter(student -> student.getAge() <= 60)
                .count()
        ;
        System.out.println("There are %d students between 30 and 60 years old.".formatted(betweenThirtyAndSixty));

        var overSixty = Stream.of(students)
                .filter(student -> student.getAge() > 60)
                .count()
        ;
        System.out.println("There are %d students over 60 years old.".formatted(overSixty));

        var ageStatistics = Stream.of(students)
                .mapToInt(student -> student.getAge())
                .summaryStatistics()
        ;
        System.out.println(ageStatistics);



        var countryCodes = Stream.of(students)
                .map(student -> student.getCountryCode())
                .distinct()
                .sorted()
        ;
        countryCodes.forEach(s -> System.out.print(s + " "));
        System.out.println();



        var activeFirstStudents = Stream.of(students)
                .anyMatch(student -> student.getYearsSinceEnrolled() > 7 && student.getMonthsSinceActive() == 0)
        ;
        System.out.println("Are first students still active?    " + activeFirstStudents);

        var activeFirstStudentsSample = Stream.of(students)
                .filter(student -> student.getYearsSinceEnrolled() > 7)
                .filter(student -> student.getMonthsSinceActive() == 0)
                .limit(5)
        ;
        activeFirstStudentsSample.forEach(System.out::println);



        var overNinety = Stream.of(students)
                .filter(student -> student.getAge() > 89)
                .count()          
        ;
        System.out.println("There are %d students over 90 years old!".formatted(overNinety));

    }

}
