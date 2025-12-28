package section13.NestedClasses;

import java.util.Comparator;

public class Employee {

    //  STATIC NESTED CLASS
    public static class EmployeeComparator <T extends Employee> implements Comparator<Employee> {

        String stringField = "";

        public EmployeeComparator() {
            this.stringField = "employeeId";
        }

        public EmployeeComparator(String stringField) {
            this.stringField = stringField;
        }

        @Override
        public int compare(Employee o1, Employee o2) {

            //  in an inner class (static or not), we can ACCESS PRIVATE FIELDS DIRECTLY!
            return switch(stringField.toUpperCase()) {
                //  no need to use getters!
                case "NAME" -> o1.name.compareTo(o2.name);
                //  .compareTo() can only be used on types that implement Comparable;
                //  it may obviously not be used on primitives!
                case "YEARSTARTED" -> o1.yearStarted - o2.yearStarted;
                default -> o1.employeeId - o2.employeeId;
            };

        }

    }

    private int employeeId;
    private String name;
    private int yearStarted;

    public Employee() {

    }

    public Employee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    // public int getYearStarted() {
    //     return yearStarted;
    // }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }

}
