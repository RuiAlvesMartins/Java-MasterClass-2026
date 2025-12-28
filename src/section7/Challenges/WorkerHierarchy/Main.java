package section7.Challenges.WorkerHierarchy;

public class Main {

    public static void main(String[] args) {
        
        Worker bill = new Worker("Bill", "01/05/1975", null);
        System.out.println(bill);
        System.out.println(bill.getName() + " is " + bill.getAge() + " years old.");

        Employee john = new Employee("John", "11/09/1973", "12/08/2001");
        System.out.println(john);
        System.out.println(john.getName() + " is " + john.getAge() + " years old.");
        System.out.println(john.getName() + " joined the company on " + john.getHireDate() + ".");

        SalariedEmployee sarah = new SalariedEmployee("Sarah", "01/01/1992", "01/08/2015", 35_000D);
        System.out.println(sarah);
        System.out.println(sarah.getName() + " is " + sarah.getAge() + " years old.");
        System.out.println(sarah.getName() + " joined the company on " + sarah.getHireDate() + ".");
        sarah.collectPay();

        double standardHourlyRate = 12D;
        HourlyEmployee jane = new HourlyEmployee("Jane", "01/04/1998", "20/07/2019", standardHourlyRate);
        System.out.println(jane);
        System.out.println(jane.getName() + " is " + jane.getAge() + " years old.");
        System.out.println(jane.getName() + " joined the company on " + jane.getHireDate() + ".");
        jane.getDoublePay();

        sarah.retire();
        sarah.terminate("07/10/2023");
        sarah.collectPay();


    }

}
