package section17.TerminalOperations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import section17.Challenges.StudentEngagement.Course;
import section17.Challenges.StudentEngagement.Student;

//  STATIC IMPORT
import static java.util.stream.Collectors.*;

        //  This section will cover some methods on COLLECTORS;
        //  Documentation: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/Collectors.html#method-summary


  
        //  Collectors.GROUPINGBY(function)
        //  returns a collector that collects data into a map:
        //          key: result of the function;
        //          value: a List of elements mapped to the key;
        //  this collector can be passed to .collect()

        //  Collectors.GROUPINGBY(function, collector)
        //  same as .groupingBy(function);
        //  but you can pass a collector with a reduction operation;

        //  Collectors.FILTERING(predicate, collector)
        //  accumulates elements where predicate is true, into the specified collector;

        //  Collectors.PARTITIONINGBY(predicate)
        //  returns a collector that collects data into a map:    
        //          key: boolean;
        //          value: a List of elements mapped to the key (by the predicate);

        //  Collectors.PARTITIONINGBY(predicate, collector)
        //  same as .partitioningBy(predicate);
        //  but you can pass a collector with a reduction operation;

        //  Collectors.COUNTING()
        //  returns a collector that counts the input elements;



public class CollectorsAdvanced {
    
    public static void main(String[] args) {
        
        Course pymc = new Course("PYMC","Python Masterclass", 50);
        Course jmc = new Course("JMC","Java Masterclass", 100);
        // Course gdj = new Course("GDJ","Java for Game Development");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
                .limit(5000)
                .sorted(Comparator.comparing(Student::getStudentID))
                .toList()
        ;

        //  Collectors.GROUPINGBY(function)
        var mappedStudents = students.stream()
                .collect(Collectors.groupingBy(Student::getCountryCode))
        ;
        mappedStudents.forEach((k, v) -> System.out.println(k + " " + v.size()));

        System.out.println("-".repeat(90));
        int minAge = 25;
        var youngerSet = students.stream()
                //  Collectors.GROUPINGBY(function, collector)
                .collect(groupingBy(                                        //  sourced from static import Collectors.*
                        Student::getCountryCode,      
                        //  Collectors.FILTERING(predicate, collector)  
                        filtering(s -> s.getAge() <= minAge, toList())      //  sourced from static import Collectors.*
                        )
                )
        ;
        youngerSet.forEach((k, v) -> System.out.println(k + " " + v.size()));

        //  Collectors.PARTITIONINGBY(predicate)
        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience))          
        ;
        System.out.println("Experienced Students = " + experienced.get(true).size());

        //  Collectors.PARTITIONINGBY(predicate, collector)
        var expCount = students.stream()
                //  Collectors.COUNTING()
                .collect(partitioningBy(Student::hasProgrammingExperience, counting()))          
        ;
        System.out.println("Experienced Students = " + expCount.get(true));

        //  Collectors.PARTITIONINGBY(predicate, collector)
        var experiencedAndActive = students.stream()
                .collect(partitioningBy(
                        s -> s.hasProgrammingExperience() && s.getMonthsSinceActive() == 0,
                        counting()
                        )
                )          
        ;
        System.out.println("Experienced and Active Students = " + experiencedAndActive.get(true));



        //  Multi Level Map
        var multiLevel = students.stream()
                .collect(groupingBy(
                                Student::getCountryCode,
                                groupingBy(Student::getGender)
                        )
                )
        ;
        multiLevel.forEach((k1, v1) -> {
                System.out.println(k1);
                v1.forEach((k2, v2) -> {
                        System.out.println("\t" + k2 + " " + v2.size());
                });
        });

    }

}
