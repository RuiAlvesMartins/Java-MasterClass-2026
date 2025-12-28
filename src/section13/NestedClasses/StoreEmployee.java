package section13.NestedClasses;

import java.util.Comparator;

public class StoreEmployee extends Employee {

    //  INNER CLASS
    public class StoreComparator<T extends StoreEmployee> implements Comparator<StoreEmployee> {

        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            int result = o1.store.compareTo(o2.store);
            //  if workers work at the same store
            if (result == 0) {
                return new Employee.EmployeeComparator<>("yearstarted").compare(o1, o2);
            }
            return result;
        }

    }

    private String store;

    public StoreEmployee() {
    }

    public StoreEmployee(int employeeId, String name, int yearStarted, String store) {
        super(employeeId, name, yearStarted);
        this.store = store;
    }

    @Override
    public String toString() {
        return "%-8s %s".formatted(store, super.toString());
    }

}
