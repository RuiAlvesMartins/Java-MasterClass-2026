package section17.TerminalOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import section17.Challenges.StudentEngagement.Course;
import section17.Challenges.StudentEngagement.Student;

public class OptionalType {
    
    //  OPTIONAL
    //  Optional is a GENERIC CLASS;
    //  It's purpose is to serve as a CONTAINER for a value that MAY or may not be NULL;
    //  Designed to adress the NULLPOINTERException, intended to be a RETURN type; 

    //  Optional tries to adress the problem of no result/data being a valid situation;
    //          e.g. the sales price of an item having not yet been determined;
    //          it would be very misleading to assign a 0 to that field;
    //  Optional is a way of indicating that a value may not be present, and can SAFELY be ignored during processing;
    
    //  HOWEVER: https://stackoverflow.com/questions/26327957/should-java-8-getters-return-optional-type/26328555#26328555
    //          Wrapping elements in Optional can consume more memory and slow down execution!
    //          Wrapping elements in Optional adds complexity to the code, and reduces readability;
    //          Optional is NOT SERIALIZABLE!
    //          Using Optional for fields or method parameters is not recomended!



    //  Static Factory Methods of Optional:
    //          Optional.EMPTY()                when optional is certain to contain NO value;
    //          Optional.OF()                   when optional is certain to CONTAIN a value;
    //          Optional.OFNULLABLE()           when not certain of what to expect;



    //  Instance methods of Optional:
    //
    //          Optional.ISEMPTY()              returns true when optional contains no value;
    //          Optional.ISPRESENT()            returns true when optional contains a value;
    //
    //          Optional.GET()                  returns value if present; runtime error otherwise!
    //          Optional.ORELSE(type)           returns value if present, OR the type provided as argument; 
    //          Optional.ORELSEGET(supplier)    returns value if present, otherwise returns result of supplier;
    //
    //          Optional.IFPRESENT(consumer)        
    //          Optional.IFPRESENTORELSE(consumer, runnable)



    //  Rules for Optional:
    //          RULE #1: check .isPresent() before acessing .get()!
    //          RULE #2: Any method returning an Optional MUST NOT return NULL!
    //          RULE #3: You can't pass a NULL to a Optional.OF()!
    

    public static void main(String[] args) {
        
        Course pymc= new Course("PYMC", "Python Masterclass");
        Course jmc= new Course("JMC", "Java Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                        .limit(1000)
                        // .peek(s -> System.out.println(s))
                        .collect(Collectors.toList())
        ;



        Optional<Student> o1 = getStudent(new ArrayList<>(), "first");
        System.out.println("Empty = " + o1.isEmpty() + ", Present = " + o1.isPresent());
        System.out.println(o1);
        System.out.println();

        Optional<Student> o2 = getStudent(students, "first");
        System.out.println("Empty = " + o2.isEmpty() + ", Present = " + o2.isPresent());
        System.out.println(o2);
        System.out.println(o2.get());
        System.out.println();

        students.add(0, null);
        Optional<Student> o3 = getStudent(students, "first");
        System.out.println("Empty = " + o3.isEmpty() + ", Present = " + o3.isPresent());
        System.out.println(o3);                                     //  output: Optional.empty
        // System.out.println(o3.get());                               //  runtime error!      
        //  can only call .get() when .isPresent() is true! i.e. when Optional contains a value!
        //  RULE #1: check .isPresent() before acessing .get()!
        if (o3.isPresent()) {
            System.out.println(o3.get());
        }
        //  Optional.ifPresent(consumer)
        //  does the same thing as the if statement, but in a functional statement;
        o3.ifPresent(System.out::println);
        //  Optional.ifPresentOrElse(consumer, runnable)
        //  will execute runnable on a empty optional;
        o3.ifPresentOrElse(System.out::println, () -> System.out.println("---> Empty"));
        System.out.println();

        // Student firstStudent = o3.isPresent() ? o3.get() : null;
        //  Optional.orElse()
        Student firstStudent = o3.orElse(null);
        long id = firstStudent == null ? -1 : firstStudent.getStudentID();
        System.out.println("firstStudent ID is " + id);
        System.out.println();

        //  Optional.orElse()
        Student secondStudent = o3.orElse(getDummyStudent(jmc));
        long id2 = secondStudent == null ? -1 : secondStudent.getStudentID();
        System.out.println("secondStudent ID is " + id2);
        System.out.println();

        //  Optional.orElseGet(supplier)
        Student thirdStudent = o3.orElseGet(() -> getDummyStudent(jmc));
        long id3 = thirdStudent == null ? -1 : thirdStudent.getStudentID();
        System.out.println("thirdStudent ID is " + id3);
        System.out.println();



        //  Optional methods can resemble STREAMS!

        List<String> countries = students.stream()
                .filter(s -> s != null)
                .filter(s -> s.getCountryCode() != null)
                .map(Student::getCountryCode)
                .distinct()
                .toList()
        ;

        Optional.of(countries)
                .map(l -> String.join(", ", l))
                .filter(l -> l.contains("FR"))
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Missing FR"))
        ;
        //  these chained methods might look like a Stream Pipeline;
        //  but they are NOT!

        //  Optional is the result of various Terminal operations;
        //  these methods provide familiar Stream functionality, to Optional values;
        //  this means they can be chained to stream pipleines (provided terminal op returned optional);

    }

    private static Optional<Student> getStudent(List<Student> list, String type) {

        if (list == null || list.size() == 0) {
            //  RULE #2: Any method returning an Optional MUST NOT return NULL!
            // return null;                                            //  runtime error!
            //  It should return an empty Optional instead;
            return Optional.empty();
        } else if (type.equals("first")) {
            //  RULE #3: You can't pass a NULL to a Optional.OF()!
            // return Optional.of(list.get(0));                        //  runtime error!
            //  Optional.ofNullable() should be used when uncertain of what to expect;
            return Optional.ofNullable(list.get(0));
        } else if (type.equals("last")) {
            return Optional.ofNullable(list.get(list.size()-1));
        }
        return Optional.ofNullable(list.get(new Random().nextInt(list.size())));
    }

    private static Student getDummyStudent(Course... courses) {
        System.out.println("Getting the dummy student");
        return new Student("NO", 1, 1, "T",
                false, courses);
    }

}
