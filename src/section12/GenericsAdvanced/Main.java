package section12.GenericsAdvanced;

import java.util.ArrayList;
import java.util.List;

record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        //  just for demonstration purposes;
        return false;
    }

}

public class Main {

    public static void main(String[] args) {
        
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student());
        } 
        printList(students);
        System.out.printf("%n%n%n");

        List<SubStudent> subStudents = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            subStudents.add(new SubStudent());
        }

        //  this won't compile, why?
        // printList(subStudents);                              //  compiler error!

        //  SubStudent inherits from Student;
        //  SubStudent is a sub type of Student: we can pass it as if it was a Student through method arguments, etc.;

        //  We can pass a SubType to a container of the SuperType:
        students.add(new SubStudent());
        printList(students);                                    //  works fine
        System.out.printf("%n%n%n");



        //  But we can't pass an ArrayList<SubStudent> for an ArrayList<Student>!
        //  Nor can we pass a List<SubStudent> for a List<Student>!
        //  Even though both types have a inheritance relationship!

        //  When we SPECIFY the TYPE of a GENERIC CLASS or CONTAINER;
        //  ONLY that type is VALID! It's SUB-TYPES are NOT valid! 

        //  Example:
        // List<Student> newStudents = new ArrayList<SubStudent>();        //  compiler error!



        //  Workarounds: 
        //      Raw Type;
        //      SubType as argument;
        //      Generic methods;
        //      WildCards; 

        //  RAW TYPE:
        System.out.println("RAW TYPE DEMO");
        printListRawType(subStudents);
        System.out.printf("%n%n%n");
        //  This will work, but remember: BAD PRACTICE!
        //  You can pass a List<ofLiterallyAnythingYouCanThinkOf> and the compiler will accept;
        //  However, if you pass a wrong data type, you will get a RunTime error!

        //  Use the SubType as argument:
        System.out.println("SUB TYPE DEMO");
        printListSubType(subStudents);
        System.out.printf("%n%n%n");
        //  It works, but defeats the purpose of using GENERICS!
        //  You will have to duplicate code everytime you need to work with a new SubType!

        //  GENERIC METHODS:
        System.out.println("GENERIC METHOD DEMO");
        printListGenericMethod(subStudents);
        System.out.printf("%n%n%n");

        //  WILDCARDS:
        System.out.println("WILDCARD DEMO");
        printListWildCard(subStudents);
        System.out.printf("%n%n%n");

        //  WILDCARDS (Lower Bounded):
        System.out.println("WILDCARD LOWER BOUND DEMO");
        //  because wildcard is Lower Bounded to Student, you cannot pass its SubType SubStudent!
        // printListWildCardLowerBounded(subStudents);                             //  compiler error!
        printListWildCardLowerBounded(students);
        System.out.printf("%n%n%n");



        //  TYPE PARAMETERS in STATIC GENERIC METHODS
        //  (consult QueryList.java for more in deapth explanation);
        System.out.println("MATCHES DEMO");
        //  no need to specify the Type Parameter
        //  var queryList infers QueryList<SubStudent>;
        var queryList = new QueryList<>(subStudents);
        //  var matches infers List<SubStudent>;
        var matches = queryList.getMatches("Course", "Python");
        printListWildCard(matches);
        System.out.printf("%n%n%n");

        System.out.println("STATIC GENERIC METHODS DEMO");
        //  Becuse we are calling a static method, no need to instantiate QueryList;
        //  var students2021 infers List<Student>;
        var students2021 = QueryList.getMatches(students, "YearStarted", "2021");
        printListWildCard(students2021);
        System.out.printf("%n%n%n");

        //  Instantiating a new ArrayList will result in var infering the Upper Bound;
        //  var students2022 infers List<QueryItem>;
        var students2022 = QueryList.getMatches(new ArrayList<>(), "YearStarted", "2022");
        //  The Upper Bound for printListWildCard() is Student;
        //  Student =/= QueryItem (the infered type for students 2022); 
        // printListWildCard(students2022);                                    //  compiler error!

        //  We can call a STATIC GENERIC Method with an EXPLICIT TYPE!
        //  (or a type that can be infered);
        System.out.println("EXPLICIT TYPE DEMO");
        //  var students2023 infers List<Student>;
        var students2023 = QueryList.<Student>getMatches(new ArrayList<>(), "YearStarted", "2023");
        //  no results will be printed because the list being searched (new ArrayList) is empty!
        printListWildCard(students2023);
        System.out.printf("%n%n%n");



        //  MULTIPLE UPPER BOUNDS
        //  (consult QueryList.java for more in deapth explanation);
        //  Because Employee does not extend Student, it cannot be passed as a type parameter of QueryList;
        // QueryList<Employee> employeeList = new QueryList<>();                   //  compiler error!        

    }

    public static void printList(List<Student> students) {
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static void printListRawType(List students) {
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static void printListSubType(List<SubStudent> students) {
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static <T extends Student> void printListGenericMethod(List<T> students) {
        for (var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    public static void printListWildCard(List<? extends Student> students) {
        for (var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    public static void printListWildCardLowerBounded(List<? super Student> students) {
        for (var student : students) {
            //  for LOWER BOUNDED wildcards, you may have to cast the types in order to ensure functionality;
            Student s = (Student) student;
            System.out.println(s.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

}
