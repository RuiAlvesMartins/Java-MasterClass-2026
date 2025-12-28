package section7.POJOs;

public class Record {

    //  RECORD;
    //  introduced JDK14;
    //  is a special class that contains data not meant to be altered (IMMUTBILITY);
    //  more restrictive than POJOs;
    //  meant to be less work intensive than writing POJOs;
    //  RECORD is also known as PDCs PLAIN DATA CARRIERS;
    

        
    public static void main(String[] args) {
    
    //  this loop will instantiate 5 students;
    for (int i = 1; i <= 5; i++) {
        StudentRECORD s = new StudentRECORD("S92300" + i,
                                switch (i) {
                                    case 1 -> "Mary";
                                    case 2 -> "Carol";
                                    case 3 -> "Tim";
                                    case 4 -> "Harry";
                                    case 5 -> "Lisa";
                                    default -> "Anonymous";
                                },
                                "05/11/1995",
                                "Java MasterClass");

        //  if you have a .TOSTRING method defined on your class, println() will implicitly use that method when you pass it a REFERENCE/INSTANCE;
        System.out.println(s);

        }

        StudentPOJO pojoStudent = new StudentPOJO("S923006", "Ann", "05/11/1985", "Java MasterClass");
        StudentRECORD recordStudent = new StudentRECORD("S923007", "Bill", "05/11/1985", "Java MasterClass");

        System.out.println(pojoStudent);
        System.out.println(recordStudent);

        pojoStudent.setClassList(pojoStudent.getClassList() + ", Java OCP Exam 829");
        // recordStudent.classList(recordStudent.classList() + ", Java OCP Exam 829");
        System.out.println(pojoStudent.getName() + " is taking " + pojoStudent.getClassList());
        System.out.println(recordStudent.name() + " is taking " + recordStudent.classList());

    }

}


