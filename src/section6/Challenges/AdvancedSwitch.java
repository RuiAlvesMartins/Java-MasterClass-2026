package section6.Challenges;

public class AdvancedSwitch {

    public static void main(String[] args) {
        
        printDayOfWeek(-1);
        printDayOfWeek(0);
        printDayOfWeek(1);
        printDayOfWeek(2);
        printDayOfWeek(3);
        printDayOfWeek(4);
        printDayOfWeek(5);
        printDayOfWeek(6);
        printDayOfWeek(7);

        //  printWeekDay(-1);
        //  printWeekDay(0);
        //  printWeekDay(1);
        //  printWeekDay(2);
        //  printWeekDay(3);
        //  printWeekDay(4);
        //  printWeekDay(5);
        //  printWeekDay(6);
        //  printWeekDay(7);

    }

    public static void printDayOfWeek(int day) {
        String dayOfTheWeek = switch (day) {
            case 0 -> {yield "Sunday";}
            case 1 -> {yield "Monday";}
            case 2 -> {yield "Tuesday";}
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "not a valid day of the week!";
        };
        System.out.println(day+" is "+dayOfTheWeek);
    }

    public static void printWeekDay(int day) {
        String dayOfTheWeek = "";
        if (day == 0) {dayOfTheWeek = "Sunday";}
        else if (day == 1) {dayOfTheWeek = "Monday";}
        else if (day == 2) {dayOfTheWeek = "Tuesday";}
        else if (day == 3) {dayOfTheWeek = "Wednesday";}
        else if (day == 4) {dayOfTheWeek = "Thursday";}
        else if (day == 5) {dayOfTheWeek = "Friday";}
        else if (day == 6) {dayOfTheWeek = "Saturday";}
        else {dayOfTheWeek = "not a valid day of the week!";} 
        System.out.println(day+" is "+dayOfTheWeek);
    }

}
