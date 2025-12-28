package section12.ComparableInterfaceRevisited;

import java.util.Arrays;
import java.util.Random;

//  COMPARATOR INTERFACE
//  Similar to Comparable, but compares 2 arguments;
interface Comparator<T> {
    //  Method names are also different;
    //  In Comparable this method is named compareTo();
    int compare(T o1, T o2);
}

public class ComparatorInterface {

    public static void main(String[] args) {
        
        Student3 tim = new Student3("Tim");
        Student3 [] students = {new Student3("Zach"), new Student3("Tim"), new Student3("Ann")};

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        //  OUTPUT:  [1001 - Zach (2,51), 1002 - Tim (2,60), 1003 - Ann (3,80)]

        Student3 tim2 = new Student3("Tim");
        System.out.println("result = " + tim2.compareTo(new Student3("Tim")));
        //  Because the student id will always be different, result will never be zero!
        //  OUTPUT:  result = -1


        //  we must do this local import because we have a Comparator Demo class up above !
        java.util.Comparator<Student3> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter.reversed());                               
        System.out.println(Arrays.toString(students));

        //  Classes don't have to implement Comparator in order to be compared!
        //  Simply pass their instances as arguments;
        Student3 george = new Student3("George");
        Student3 lucas = new Student3("Lucas");
        System.out.println(george);
        System.out.println(lucas);
        System.out.println(gpaSorter.compare(george, lucas));

    }

}

class StudentGPAComparator implements java.util.Comparator<Student3> {

    @Override
    public int compare(Student3 o1, Student3 o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }

}

class Student3 implements java.lang.Comparable<Student3> {

    private static int LAST_ID = 1000;
    private static Random random = new Random();
    //  absence of an access modifier means field is PACKAGE PRIVATE;
    String name;
    private int id;
    protected double gpa;

    public Student3(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    @Override
    public int compareTo(Student3 student) {
        //  You cant call .compareTo from a primitive (int), nor pass one as argument;
        //  So you must wrap it first (Integer.valueOf());
        return Integer.valueOf(id).compareTo(Integer.valueOf(student.id));
    }

}