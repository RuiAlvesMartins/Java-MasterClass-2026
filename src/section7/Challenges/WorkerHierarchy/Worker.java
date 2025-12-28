package section7.Challenges.WorkerHierarchy;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Worker {

    private String name;
    private String birthDate;
    private String endDate;

    public int getAge() {
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate birthDate = LocalDate.parse(this.birthDate, format);
            LocalDate today = LocalDate.now();
            return Period.between(birthDate, today).getYears();
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date formt. Please use dd/MM/yyyy.");
            return -1;
        }

    }

    public double collectPay() {
        return 0;
    }

    public void terminate(String endDate) {
        this.endDate = endDate;
        System.out.println("On " + endDate + ", " + name + " has been terminated.");
    }

    public Worker(String name, String birthDate, String endDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Worker [name=" + name + ", birthDate=" + birthDate + ", endDate=" + endDate + "]";
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEndDate() {
        return endDate;
    }

}
