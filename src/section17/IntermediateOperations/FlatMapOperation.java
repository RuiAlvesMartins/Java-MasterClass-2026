package section17.IntermediateOperations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import section17.Challenges.StudentEngagement.Course;
import section17.Challenges.StudentEngagement.Student;

import static java.util.stream.Collectors.*;

public class FlatMapOperation {
    
    //  Stream.FLATMAP(function)
    //  performs ONE-TO-MANY transformations on elements in a stream pipeline;
    //  it flattens results from a hierarchical collection, into one stream of uniformly typed elements;
    //  i.e. returns a flattened stream of elements;

    public static void main(String[] args) {
        
        Course pymc = new Course("PYMC","Python Masterclass", 50);
        Course jmc = new Course("JMC","Java Masterclass", 100);

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
                .limit(5000)
                .sorted(Comparator.comparing(Student::getStudentID))
                .toList()
        ;

        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience))          
        ;
        // System.out.println("Experienced Students = " + experienced.get(true).size());

        var multiLevel = students.stream()
                .collect(groupingBy(
                                Student::getCountryCode,
                                groupingBy(Student::getGender)
                        )
                )
        ;
        multiLevel.forEach((k1, v1) -> {
                // System.out.println(k1);
                v1.forEach((k2, v2) -> {
                        // System.out.println("\t" + k2 + " " + v2.size());
                });
        });



        // long studentCount = students.stream().count();

        long studentBodyCount = 0;
        for (var list : experienced.values()) {
            studentBodyCount += list.size();
        }
        System.out.println("studentBodyCount = " + studentBodyCount);



        long activeStudentsCount = 0;
        for (var list : experienced.values()) {
            var activeStream = list.stream().collect(partitioningBy(s -> s.getMonthsSinceActive() <=3, counting()));
            activeStudentsCount += activeStream.get(true);
        }
        System.out.println("Students active on the last 3 months = " + activeStudentsCount);



        //  will return the sum of students;
        studentBodyCount = experienced.values().stream()
                .mapToInt(l -> l.size())
                .sum()
        ;
        System.out.println("studentBodyCount = " + studentBodyCount);

        //  will return the sum of active students;
        studentBodyCount = experienced.values().stream()
                .map(l -> l.stream()
                        .filter(s -> s. getMonthsSinceActive() <=3)
                        .count()
                )
                .mapToLong(l -> l)
                .sum()
        ;
        System.out.println("Students active on the last 3 months = " + studentBodyCount);



        //  Stream.FLATMAP(function)
        long count = experienced.values().stream()
                .flatMap(l -> l.stream())
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count()
        ;
        System.out.println("(experienced) Students active on the last 3 months = " + count);

        //  flattening a multi level map
        count = multiLevel.values().stream()
                //  flatening the 1st level
                .flatMap(map -> map.values().stream())
                //  flatening the 2nd level
                .flatMap(l -> l.stream())
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count()
        ;
        System.out.println("(multiLevel) Students active on the last 3 months = " + count);



        //  .MAP() does NOT flatten the data!
        var c = multiLevel.values().stream()
                // .map(map -> map.values().stream())               //  Stream<Stream<List<Student>>>
                // .flatMap(map -> map.values().stream())           //  Stream<List<Student>>
        ;
        System.out.println(c);
        //  Map exchanges one type for another, for each element;
        //  FlatMap exchanges one element for a stream of elements;

    }

}
