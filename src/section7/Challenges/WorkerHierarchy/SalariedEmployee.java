package section7.Challenges.WorkerHierarchy;

public class SalariedEmployee extends Employee {

    private double annualSalary;
    private boolean isRetired;

    public void retire() {
        isRetired = true;
        System.out.println(this.getName() + " has retired.");
    }

    @Override
    public double collectPay() {
        double monthlySalary = annualSalary / 12D;
        if (isRetired) {
            double pension = monthlySalary * 0.8D;
            System.out.println(this.getName() + " collected " + Math.round(pension * 100.0) / 100.0 + "$ from her pension this month.");
            return pension;
        }
        System.out.println(this.getName() + " got payed " + Math.round(monthlySalary * 100.0) / 100.0 + "$ this month.");
        return monthlySalary;
    }

    public SalariedEmployee(String name, String birthDate, String endDate, String hireDate,
            double annualSalary, boolean isRetired) {
        super(name, birthDate, endDate, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    public SalariedEmployee(String name, String birthDate, String hireDate,
            double annualSalary) {
        this(name, birthDate, null, hireDate, annualSalary, false);
    }

    @Override
    public String toString() {
        return "SalariedEmployee [annualSalary=" + annualSalary + ", isRetired=" + isRetired + ", toString()="
                + super.toString() + "]";
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public boolean isRetired() {
        return isRetired;
    }

    

}
