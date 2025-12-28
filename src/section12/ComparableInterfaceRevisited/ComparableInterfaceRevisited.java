package section12.ComparableInterfaceRevisited;

import java.util.Arrays;

//  COMPARABLE Interface Revisited
//  This is the declaration of the interface:
interface Comparable<T> {
    //  It is a GENERIC TYPE, meaning is parameterized;
    int compareTo(T o);
        //  Any class that implements this interface, needs to implement .compareTo(o);
        //  Returns ZERO (int) if       THIS ==  ARG;
        //  Returns NEGATIVE (int) if   THIS  <  ARG;
        //  Returns POSITIVE (int) if   THIS  >  ARG;


}

public class ComparableInterfaceRevisited {

    public static void main(String[] args) {
        
        

        //  For arrays, we can pass any element that implements Comparable to the .sort(args);
        //  String or primitive WRAPPERS (Integer, Double, etc.) implement Comparable, and can be passed as argument;
        Arrays.sort(args);



        //  Integer implements Comparable
        Integer five = 5;
        Integer[] numbers = {0, 5, 10, -50, 50};

        for (Integer i : numbers) {
            int comparationResult = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n", five,
                (comparationResult == 0) ? "==" : (comparationResult < 0) ? "<" : ">",
                i, comparationResult);
        }
        //  OUTPUT:
        //  5 > 0: compareTo=1                              THIS > ARG  --->  POSITIVE result       
        //  5 == 5: compareTo=0                             THIS == ARG  -->  ZERO result
        //  5 < 10: compareTo=-1                            THIS < ARG  --->  NEGATIVE result
        //  5 > -50: compareTo=1
        //  5 < 50: compareTo=-1



        //  String implements Comparable
        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};

        for (String s : fruit) {
            int comparationResult = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d%n", banana,
                (comparationResult == 0) ? "==" : (comparationResult < 0) ? "<" : ">",
                s, comparationResult);
        }
        //  OUTPUT:
        //  banana > apple: compareTo=1                     THIS > ARG  --->  POSITIVE result
        //  banana == banana: compareTo=0                   THIS == ARG  -->  POSITIVE result
        //  banana < pear: compareTo=-14                    THIS < ARG  --->  POSITIVE result
        //  banana > BANANA: compareTo=32

        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));
        //  OUTPUT:
        //  [BANANA, apple, banana, pear]

        System.out.println("A: " + (int)'A' + "   " + "a: " + (int)'a');
        System.out.println("B: " + (int)'B' + "   " + "b: " + (int)'b');
        System.out.println("P: " + (int)'P' + "   " + "p: " + (int)'p');
        //  OUTPUT:
        //  Each CHAR has an associated int;
        //  compareTo sorts both chars and strings by those ints;
        //  A: 65   a: 97
        //  B: 66   b: 98
        //  P: 80   p: 112



        //  Custom Types implement Comparable
        Student tim = new Student("Tim");
        Student [] students = {new Student("Zach"), new Student("Tim"), new Student("Ann")};

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        //  OUTPUT: 
        //  Student is implementing Comparable, so the array is getting sorted properly;
        //  [Ann, Tim, Zach]

        //  Because Student is implementing Comparable as a RAW type (not specifying any type)
        //  it will allow us to pass a String;
        //  but a ClassCastException will be thrown when tying to cast it into a Student;
        // System.out.println("result = " + tim.compareTo("Mary"));             //  compiler error



        //  Student2 implements Comperable<Student> (no longer a Raw Type)
        Student2 tim2 = new Student2("Tim");
        System.out.println("result = " + tim2.compareTo(new Student2("Tim"))); 
        //  Output:
        //  result = 0       

    }

}

class Student implements java.lang.Comparable {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        //  We can't change the argument type from Object to Student;
        //  We would be breaking the signature forced by the Comparable interface;
        //  So we must cast the Object argument into Student, so we can access name;
        Student otherStudent = (Student) o;
        return name.compareTo(otherStudent.name);
    }

}

class Student2 implements java.lang.Comparable<Student2> {

    private String name;

    public Student2(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Student2 student) {
        //  Now we don't need to cast;
        return name.compareTo(student.name);
    }

}
