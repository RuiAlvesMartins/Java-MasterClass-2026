package section17.TerminalOperations;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import section17.Challenges.StudentEngagement.Course;
import section17.Challenges.StudentEngagement.Student;

public class CollectAndReduce {
    
        //  Transformations and Type Reductions

        //  .COLLECT()
        //  elements are accumulated into a CONTAINER;
        //  has two overloaded versions:
        //          .collect(Collector)
        //          .collect(Supplier, Accumulator, Combiner)  
        //                  Supplier: instantiates the container;       
        //                  Accumulator: adds elements to the container;
        //                  Combiner: ???? todo  joins multiple accumulated outputs into a single collection; 

        //  .REDUCE()
        //  elements are accumulated into a SINGLE TYPE;
        //          .reduce(identity, accumulator)


    public static void main(String[] args) {
        
        Course pymc = new Course("PYMC","Python Masterclass");
        Course jmc = new Course("JMC","Java Masterclass");
        Course sbmc = new Course("SBMC","SpringBoot Masterclass");
        Course cmc = new Course("CMC","C Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(pymc, jmc, sbmc, cmc))
                .limit(1000)
                .toList()
        ;



        Set<Student> australianStudents = students.stream()
                .filter(student -> student.getCountryCode() == "AU")
                .collect(Collectors.toSet())
        ;
        System.out.println("# of Australian Students = " + australianStudents.size());

        Set<Student> underThirty = students.stream()
                .filter((s) -> s.getAgeEnrolled() < 30)
                .collect(Collectors.toSet());
        System.out.println("# of Under Thirty Students = " + underThirty.size());

        //  TreeSet<>(Comparator)
        //  constructs a new empty TreeSet, sorted by Comparator;
        Set<Student> youngAussies1 = new TreeSet<>(Comparator.comparing(Student::getStudentID));
        youngAussies1.addAll(australianStudents);
        youngAussies1.retainAll(underThirty);
        youngAussies1.forEach((student) -> System.out.print(student.getStudentID() + " "));
        System.out.println();

        Set<Student> youngAussies2 = students.stream()
                .filter((s) -> s.getAgeEnrolled() < 30)
                .filter((s) -> s.getCountryCode().equals("AU"))
                //  Collectors.toSet() will not return an ordered set!
                // .collect(Collectors.toSet())

                //  .collect(Supplier, Accumulator, Combiner)
                .collect(
                    () -> new TreeSet<>(Comparator.comparing(Student::getStudentID)), 
                    TreeSet::add, 
                    TreeSet::addAll)
        ;
        youngAussies2.forEach((student) -> System.out.print(student.getStudentID() + " "));
        System.out.println();



        //  .reduce(identity, accumulator)
        String countryList = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .reduce("", (r, v) -> r + " " + v);
        System.out.println("countryList = " + countryList);
        //  in this example, elements are reduced to a single string type;

    }

}
