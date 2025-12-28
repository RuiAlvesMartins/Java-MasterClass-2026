package section7.Inheritance;

public class ObjectClass extends java.lang.Object {

    //  OBJECT is the base/root class of every class in Java;
    //  It sits at the throne of the Inheritance HIERARCHY;
    //  All classes that do not extend another class explicitly, extend OBJECT implicitly;
    //  https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html

    public static void main(String[] args) {

        Student max = new Student("Max", 21);
        //  the toString() of Object class prints out the class name + @ + hashcode
        //  HASCODE is an integer that is unique to an instance (in the currently executing code); It can be a hexadecimal;
        //  by looking at hashcode, we can determine if multiple references are pointing to a single instance
        System.out.println(max.toString());
        System.out.println(max);

        PrimarySchoolStudent jimmy = new PrimarySchoolStudent("Jimmy", 8, "Carole");
        System.out.println(jimmy);

    }

}

//  only one class in a java source file can be PUBLIC!
//  you can extend the full path to a class if needed;
class Student extends java.lang.Object {

    private String name;
    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        // return "Student [name=" + name + ", age=" + age + "]";
        return name + " is " + age;
    } 

}


//  EXTENDS only supports one class!
//  class PrimarySchoolStudent extends Student, Object  // this is not correct
class PrimarySchoolStudent extends Student {

    private String parentName;

    PrimarySchoolStudent(String name, int age, String parentName) {
        super(name, age);
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return parentName + "'s kid, " + super.toString();
    }

}
