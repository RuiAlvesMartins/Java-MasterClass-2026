package section16.Mutability.ImmutableCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        StringBuilder bobsNotes = new StringBuilder();
        StringBuilder billsNotes = new StringBuilder("Bill struggles with generics");
        Student bob = new Student("Bob", bobsNotes);
        Student bill = new Student("Bill", billsNotes);

        List<Student> students = new ArrayList<>(List.of(bob, bill));
        List<Student> studentsFirstCopy = new ArrayList<>(students);
        //  List.copyOf() will make a SHALLOW, but UNMODIFIABLE copy of students;
        List<Student> studentsSecondCopy = List.copyOf(students);
        //  Collections.unmodifiableList() will return an unmodifiable VIEW;
        List<Student> studentsThirdCopy = Collections.unmodifiableList(students);

        students.forEach(System.out::println);
        System.out.println("-".repeat(60));

        //  despite it's fields being declared private and final;
        //  Student.java is lacking defensive geters and many other stuff;
        //  so it is still mutable:
        bobsNotes.append("Bob was one of my first students");
        students.forEach(System.out::println);
        System.out.println("-".repeat(60));

        studentsFirstCopy.add(new Student("Bonnie", new StringBuilder()));
        StringBuilder bonniesNotes = studentsFirstCopy.get(2).getStudentNotes();
        bonniesNotes.append("Bonnie is taking 3 of my courses");

        //  List.sort() runs fine on studentsFirstCopy;
        studentsFirstCopy.sort(Comparator.comparing(Student::getName));
        studentsFirstCopy.forEach(System.out::println);
        System.out.println("-".repeat(60));

        //  despite being a shallow copy, product of List.copyOf()
        //  studentSecondCopy is UNMODIFIABLE!
        // studentsSecondCopy.add("Bonnie", bonniesNotes);                      //  compiler error!
        // studentsSecondCopy.set(0, new Student("Bonnie", bonniesNotes));      //  runtime error!      UnsupportedOperationException!   
        // studentsSecondCopy.sort(Comparator.comparing(Student::getName));     //  runtime error!      UnsupportedOperationException!          

        studentsSecondCopy.forEach(System.out::println);
        System.out.println("-".repeat(60));



        //  UNMODIFIABLE Collections are NOT necessarily IMMUTABLE!
        //  You cannot touch the structure;
        //  But the data (elements) can potentially be mutated!
        //  A collection is IMMUTABLE only if the elements themselves are FULLY IMMUTABLE!

        //  In an immutable collection:
        //          you cannot ADD, REMOVE or CLEAR elements;
        //          you cannot REPLACE or SORT elements;
        //          mutator methods throw UnsupportedOperationException;
        //          NULLs are not accepted;



        // studentsThirdCopy.set(0, new Student("Bonnie", bonniesNotes));       //  runtime error!      UnsupportedOperationException!
        students.add(new Student("Bonnie", bonniesNotes));

        //  despite being unmodifiable, Collections.unmodifiableList() still returns the new student; 
        //  when it is added to the original students list; Why?
        //  because Collections.unmodifiableList() returns a VIEW of the original!
        //  it is subject to all the limitations of List.copyOf();
        //  but it will always be tied to the structure of the collection backing it;
        //  in other words: it cannot be modified directly, but it will change if the original changes! 
        studentsThirdCopy.forEach(System.out::println);
        System.out.println("-".repeat(60));

        //  In essence, a VIEW should:
        //          NOT be mutated by client or calling code;
        //          reflect all mutations in the backing collection;


        
        //  consult schrenshot on JavaMasterClassNotes for more information on different Collections methods and what they do;

    }

}
