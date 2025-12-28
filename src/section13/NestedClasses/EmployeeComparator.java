package section13.NestedClasses;

import java.util.Comparator;

//  STATIC NESTED CLASS in Employee
public class EmployeeComparator <T extends Employee> implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());

        //  .compareTo() can only be used on types that implement Comparable;
        //  it may obviously not be used on primitives!
        // return o1.getYearStarted() - o2.getYearStarted();
    }

}
