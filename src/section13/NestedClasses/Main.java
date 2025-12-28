package section13.NestedClasses;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        List<Employee> employees = new ArrayList<>(List.of(
                                                        new Employee(10_001, "Ralph", 2015),
                                                        new Employee(10_005, "Carole", 2021),
                                                        new Employee(10_022, "Jane", 2013),
                                                        new Employee(13_151, "Laura", 2020),
                                                        new Employee(10_050, "Jim", 2018)
                                                    ));

        // var comparator = new EmployeeComparator<>();
        // employees.sort(comparator);

        //  Instantiating Static Nested Class in employee
        //  No need to specify the type in <> because Java infers it;
        employees.sort(new Employee.EmployeeComparator<>("name").reversed());

        for (var e : employees) {
            System.out.println(e);
        }

        System.out.printf("%n%n%n");
        System.out.println("Store Members");

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
            new StoreEmployee(10_015, "Meg", 2019, "Target"),
            new StoreEmployee(10_515, "Joe", 2021, "Walmart"),
            new StoreEmployee(10_105, "Tom", 2020, "Macys"),
            new StoreEmployee(10_215, "Marty", 2018, "Walmart"),
            new StoreEmployee(10_322, "Bud", 2016, "Target")
        ));

        //  SubClass StoreEmployee can call Static Nested Class on SuperClass Employee!
        var employeeComparator = new StoreEmployee.EmployeeComparator<>();
        storeEmployees.sort(employeeComparator);

        System.out.printf("%n%n%n");

        //  INSTANTIATING INNER CLASS
        //  It must be done through an instance of the outer class!
        StoreEmployee genericEmployee = new StoreEmployee();
        //  Keyword NEW is called from the outer class instance!
        var storeComparator = genericEmployee.new StoreComparator<>();
        //  Alternatively, you can chain instantiations of outer and inner classes:
        // var storeComparator = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(storeComparator);

        for (var e : storeEmployees) {
            System.out.println(e);
        }

        System.out.printf("%n%n%n");
        System.out.println("With Pig Latin Names");
        addPigLatinName(storeEmployees);

    }

    //  accepts a List of StoreEmployee or any of its subtypes (Upper Bounded WildCard)
    public static void addPigLatinName(List<? extends StoreEmployee> list) {

        //  LOCAL CLASS
        //  Why a class inide a method?
        //  In this case, we use it to append an extra field (String pigLatinName) to StoreEmployee instances;
        //  We don't want to add this local class to the existing library of classes, nor allow the remaining code to access it or extend it;        
        //  For just this simple purpose, a local class will do just fine;

        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee> {

            private String pigLatinName;
            private Employee originalInstance;

            String lastName = "Piggy";
            
            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return this.pigLatinName.compareTo(o.pigLatinName);
            }           

        }

        List<DecoratedEmployee> pigList = new ArrayList<>(list.size());

        for (var employee : list) {
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            pigList.add(new DecoratedEmployee(pigLatin, employee));
        }

        //  no need to specify a comparator, because DecoratedEmployee implements Comparable;
        pigList.sort(null);

        for (var decoratedEmployee : pigList) {

            //  this demonstrates that the outer method can access private fields of the inner local class;
            // String newPigName = decoratedEmployee.originalInstance.getName() + decoratedEmployee.pigLatinName;

            System.out.println(decoratedEmployee);
        }

    }

}
