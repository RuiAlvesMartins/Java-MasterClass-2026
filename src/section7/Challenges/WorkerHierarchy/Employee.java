package section7.Challenges.WorkerHierarchy;

public class Employee extends Worker {

    private long employeeId;
    private String hireDate;

    private static long employeeNo = 19700101L;

    public Employee(String name, String birthDate, String endDate, String hireDate) {
        super(name, birthDate, endDate);
        this.employeeId = Employee.employeeNo++;
        this.hireDate = hireDate;
    }

    public Employee(String name, String birthDate, String hireDate) {
        this(name, birthDate, null, hireDate);
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", hireDate=" + hireDate + ", toString()=" + super.toString()
                + "]";
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getHireDate() {
        return hireDate;
    }

    

}
