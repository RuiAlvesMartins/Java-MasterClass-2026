package section17.TerminalOperations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import section17.Challenges.StudentEngagement.Course;
import section17.Challenges.StudentEngagement.Student;

public class ToArrayToList {
    
        //  Transformations and Type Reductions

        //  .TOARRAY()
        //  returns an Object[] containing the elements of this stream;
        //  .toArray(IntFunction) allows you to return an array of the same type as the stream elements;

        //  .TOLIST()
        //  accumulates elements into a List;
        //  elements are accumulated by the order they are encountered;
        //  returned list is UNMODIFIABLE!      
        //  (you can always pass it to a ArrayList constructor to make it modifiable);

    public static void main(String[] args) {
        
        Course pymc = new Course("PYMC","Python Masterclass");
        Course jmc = new Course("JMC","Java Masterclass");
        Course sbmc = new Course("SBMC","SpringBoot Masterclass");
        Course cmc = new Course("CMC","C Masterclass");

        Student[] students = new Student[1000];
        Arrays.setAll(students, (i) -> Student.getRandomStudent(jmc, sbmc, cmc, pymc));



        //  .toList() is a terminal operation;
        //  .forEach() is also a terminal operation;
        //  how can two terminal operations compile at the same time?
        Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .toList()
                .forEach(System.out::println)
        ;
        //  ANSWER: they can't.
        //  .forEach() in this case is being run on a LIST instance, not on a Stream;
        //  .forEach() is therefore, NOT a terminal operation! 


        //  .toList()
        List<Student> longTimeLearnersList =  Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .toList()
        ;

        //  .toArray()
        //  will return an Object[];
        //  you will not be able to call Student methods without casting the elements first!
        var longTimeObjectsArray =  Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .toArray()
        ;

        //  .toArray(IntFunction)
        //  allows you to return an array of the same type as the stream elements;        
        var longTimeStudentsArray =  Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .toArray(i -> new Student[i])
                // .toArray(Student[]::new)
        ;

        //  .collect(Collectors.toList())
        var learners =  Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .collect(Collectors.toList())
                // .toList()
        ;
        //  unlike Stream.toList(), Collectors.toList() returns a MODIFIABLE type!
        Collections.shuffle(learners);
        //  (this line will through a RUNTIME ERROR if learners is unmodifiable)




    }

}
