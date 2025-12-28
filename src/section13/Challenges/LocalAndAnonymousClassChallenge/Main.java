package section13.Challenges.LocalAndAnonymousClassChallenge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Alice", "Smith", "12/11/1987"),
            new Employee("Bob", "Johnson", "03/22/1995"),
            new Employee("Clara", "Williams", "07/14/1989"),
            new Employee("David", "Brown", "09/03/1982"),
            new Employee("Emma", "Jones", "01/17/1993"),
            new Employee("Frank", "Garcia", "05/29/1990"),
            new Employee("Grace", "Miller", "11/08/1998"),
            new Employee("Henry", "Davis", "08/12/1985"),
            new Employee("Ivy", "Wilson", "04/26/2000")
        ));

        localEmployeesList(employees, null);
        System.out.printf("%n%n%n");
        localEmployeesList(employees, "year");

    }

    public static void localEmployeesList(List<Employee> list, String sortField) {

        class LocalEmployee implements Comparable<LocalEmployee> {

            Employee employee;

            public LocalEmployee(Employee employee) {
                this.employee = employee;
            }

            public String getFullName() {
                return employee.firstName() + " " + employee.lastName();
            }

            public int getYearsWorked() {
                int yearHired = Integer.valueOf(employee.hireDate().substring(employee.hireDate().length() - 4));
                int currentYear = LocalDate.now().getYear();
                return currentYear - yearHired;
            }

            @Override
            public String toString() {
                return getFullName() + " worked for " + getYearsWorked() + " years";
            }

            @Override
            public int compareTo(LocalEmployee o) {
                return this.getFullName().compareTo(o.getFullName());
            }

            // @Override
            // public int compare(LocalEmployee o1, LocalEmployee o2) {
            //     return switch (sortField.toUpperCase()) {
            //         case "YEARS", "YEAR" -> o1.getYearsWorked() - o2.getYearsWorked();
            //         default -> o1.getFullName().compareTo(o2.getFullName());
            //     };
            // }

        }

        List<LocalEmployee> localEmployees = new ArrayList<>();

        for (var employee : list) {
            localEmployees.add(new LocalEmployee(employee));
        }

        localEmployees.sort(new Comparator<LocalEmployee>() {

            @Override
            public int compare(LocalEmployee o1, LocalEmployee o2) {
                if (sortField == null) {
                    return o1.getFullName().compareTo(o2.getFullName());
                }
                return switch (sortField.toUpperCase()) {
                    case "YEARS", "YEAR" -> o2.getYearsWorked() - o1.getYearsWorked();
                    default -> o1.getFullName().compareTo(o2.getFullName());
                };
            }
            
        });

        for (LocalEmployee localEmployee : localEmployees) {
            System.out.println(localEmployee);
        }

    }

}
