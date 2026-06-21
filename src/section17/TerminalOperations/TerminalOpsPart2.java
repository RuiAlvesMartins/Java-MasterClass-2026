package section17.TerminalOperations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import section17.Challenges.StudentEngagement.Course;
import section17.Challenges.StudentEngagement.Student;

public class TerminalOpsPart2 {
    
    //  Terminal Operations Part 2    
    //  Operations that return OPTIONAL

    //  .FINDFIRST()
    //  returns an OPTIONAL describing the first element of the stream;
    //  returns an empty optional if the stream is empty;
    
    //  .FINDANY()
    //  returns an OPTIONAL describing a random element of the stream;
    //  returns an empty optional if the stream is empty;

    //  .MAX(comparator)
    //  returns an OPTIONAL whith the maximum value specified by the comparator;
    //  returns an empty optional if the stream is empty;

    //  .MIN(comparator)
    //  returns an OPTIONAL whith the minimum value specified by the comparator;
    //  returns an empty optional if the stream is empty;

    //  .AVERAGE()
    //  Available only on PRIMITIVE Streams (IntStream, LongStream, DoubleStream);
    //  Returns OptionalDouble;

    //  .REDUCE(accumulator)
    //  accumulates elements into a single type;
    //  returns type wrapped in an optional; 



    public static void main(String[] args) {
        
        Course pymc = new Course("PYMC","Python Masterclass");
        Course jmc = new Course("JMC","Java Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
                .limit(1000)
                .toList()
        ;



        int minAge = 21;
        
        //  Stream.findAny()
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .findAny()                                          //  Stream is transformed into an Optional
                .ifPresentOrElse(
                        s -> System.out.println("Student %d from %s is %d".formatted(
                                s.getStudentID(), s.getCountryCode(), s.getAge()
                        )), 
                        () -> System.out.println("Didn't find anyone under " + minAge)
                )
        ;
        System.out.println();

        //  Stream.findFirst()
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .findFirst()                                          //  Stream is transformed into an Optional
                .ifPresentOrElse(
                        s -> System.out.println("Student %d from %s is %d".formatted(
                                s.getStudentID(), s.getCountryCode(), s.getAge()
                        )), 
                        () -> System.out.println("Didn't find anyone under " + minAge)
                )
        ;
        System.out.println();

        //  Stream.sorted(comparator)
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .sorted(Comparator.comparing(Student::getAge))
                .findFirst()                                          //  Stream is transformed into an Optional
                .ifPresentOrElse(
                        s -> System.out.println("Student %d from %s is %d".formatted(
                                s.getStudentID(), s.getCountryCode(), s.getAge()
                        )), 
                        () -> System.out.println("Didn't find anyone under " + minAge)
                )
        ;
        System.out.println();

        //  Stream.min()
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .min(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(
                        s -> System.out.println("Student %d from %s is %d".formatted(
                                s.getStudentID(), s.getCountryCode(), s.getAge()
                        )), 
                        () -> System.out.println("Didn't find anyone under " + minAge)
                )
        ;
        System.out.println();

        //  Stream.max()
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .max(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(
                        s -> System.out.println("Student %d from %s is %d".formatted(
                                s.getStudentID(), s.getCountryCode(), s.getAge()
                        )), 
                        () -> System.out.println("Didn't find anyone under " + minAge)
                )
        ;
        System.out.println();

        //  IntStream.average()
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .mapToInt(Student::getAge)                          //  Transfomrs Stream into IntStream
                .average()                                          //  returns OptionalDouble
                .ifPresentOrElse(
                        a -> System.out.println("Avg age under 21: %.2f".formatted(a)), 
                        () -> System.out.println("Didn't find anyone under " + minAge)
                )
        ;
        System.out.println();

        //  Stream.reduce(accumulator)
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .map(Student::getCountryCode)
                .distinct()
                .reduce((a, b) -> String.join(", ", a, b))
                .ifPresentOrElse(
                        System.out::println, 
                        () -> System.out.println("None found")
                );
        ;
        System.out.println();

        students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .map(l -> String.join(",", l))
                .filter(l -> l.contains("AU"))
                .findAny()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Missing AU")
                )
        ;
        System.out.println();

    }

}

