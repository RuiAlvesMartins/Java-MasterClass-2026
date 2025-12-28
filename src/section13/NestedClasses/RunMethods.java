package section13.NestedClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {

    public static void main(String[] args) {

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
            new StoreEmployee(10_015, "Meg", 2019, "Target"),
            new StoreEmployee(10_515, "Joe", 2021, "Walmart"),
            new StoreEmployee(10_105, "Tom", 2020, "Macys"),
            new StoreEmployee(10_215, "Marty", 2018, "Walmart"),
            new StoreEmployee(10_322, "Bud", 2016, "Target")
        ));

        //  Stand Alone Class (regular class)
        var c0 = new EmployeeComparator<StoreEmployee>();
        //  Static Nested Class in Employee
        //  notice that although the Comparator class is static, the outer class EMployee is not and you have to instantiate it!
        var c1 = new Employee.EmployeeComparator<StoreEmployee>();
        //  Inner Class in StoreEmployee
        //  you have to instantiate both StoreEmployee and Comparator;
        var c2 = new StoreEmployee().new StoreComparator<StoreEmployee>();

        //  LOCAL CLASS
        class NameSort<T> implements Comparator<StoreEmployee> {

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }

        }

        var c3 = new NameSort<StoreEmployee>();

        //  ANONYMOUS CLASS
        var c4 = new Comparator<StoreEmployee>() {

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }

        };

        sortIt(storeEmployees, c0);
        sortIt(storeEmployees, c1);
        //  OUTPUT:  Sorting with Comparator: section13.NestedClasses.Employee$EmployeeComparator@3b9a45b3
        //  notice the '$' between "Employee" and "EmployeeComparator": it is an indication of a NESTED class;
        sortIt(storeEmployees, c2);
        //  OUTPUT:  Sorting with Comparator: section13.NestedClasses.StoreEmployee$StoreComparator@7699a589
        //  notice the '$' between "StoreEmployee" and "StoreComparator": it is an indication of a NESTED class;
        sortIt(storeEmployees, c3);
        //  OUTPUT:  Sorting with Comparator: section13.NestedClasses.RunMethods$1NameSort@4dd8dc3
        //  notice the "$1" between "RunMethods" and "NameSort";
        sortIt(storeEmployees, c4);
        //  OUTPUT:  Sorting with Comparator: section13.NestedClasses.RunMethods$1@568db2f2
        //  notice the "$1" after "RunMethods";
        //  the Comparator class has no name!

        //  ANONYMOUS CLASS Example 2:
        //  This class will be a SubType of Employee!
        // var e1 = new Employee() {};

        //  ANONYMOUS CLASS as an argument:
        sortIt(storeEmployees, new Comparator<StoreEmployee>() {

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }

        });
        //  OUTPUT:  Sorting with Comparator: section13.NestedClasses.RunMethods$2@5fd0d5ae
        //  notice the "$2" after "RunMethods";

        //  LAMBDA EXPRESSION
        sortIt(storeEmployees, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        //  OUTPUT:  Sorting with Comparator: section13.NestedClasses.RunMethods$$Lambda$13/0x0000000800c01d30@7ef20235
        //  notice the "$$Lambda$13" after "RunMethods";

    }

    //  argument comparator is Lower Bounded;
    //  So that we can pass StoreEmployee and its SuperType Employee;
    public static <T> void sortIt(List<T> list, Comparator<? super T> comparator) {

        System.out.println("Sorting with Comparator: " + comparator.toString());
        for (var employee : list) {
            System.out.println(employee);
        }

    }

}
