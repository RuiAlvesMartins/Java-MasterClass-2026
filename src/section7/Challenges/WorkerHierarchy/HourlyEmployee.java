package section7.Challenges.WorkerHierarchy;

public class HourlyEmployee extends Employee {

    private double hourlyPayRate;

    @Override
    public double collectPay() {
        double dailySalary = hourlyPayRate * 8D;
        System.out.println(this.getName() + " got payed " + Math.round(dailySalary * 100.0) / 100.0 + "$ today.");
        return dailySalary;
    }

    public void getDoublePay() {
        double bonusSalary = this.collectPay() * 2D;
        System.out.println(this.getName() + " got payed " + Math.round(bonusSalary * 100.0) / 100.0 + "$ today, at a double rate.");
    }

    public HourlyEmployee(String name, String birthDate, String hireDate,
            double hourlyPayRate) {
        super(name, birthDate, null, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public String toString() {
        return "HourlyEmployee [hourlyPayRate=" + hourlyPayRate + ", toString()=" + super.toString() + "]";
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    

}
