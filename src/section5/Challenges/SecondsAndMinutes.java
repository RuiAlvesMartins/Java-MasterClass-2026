package section5.Challenges;

public class SecondsAndMinutes {

    public static void main(String[] args) {

        System.out.println(getDurationString(3669));
        System.out.println(getDurationString(61, 9));
    }

    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return "Invalid parameter: seconds cannot be negative!";
        }

        int hours = seconds/(60*60);
        int remainingMinutes = (seconds%(60*60)) / 60;
        int remainingSeconds = (seconds%(60*60)) % 60;

        //  int minutes = seconds/60;
        //  int hours = minutes/60;
        //  int remainingMinutes = minutes%60;
        //  int remainingSeconds = seconds%60;

        // return getDurationString(seconds/60, seconds%60);

        return  hours+"h "+remainingMinutes+"m "+remainingSeconds+"s";
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0) {
            return "Invalid parameter: minutes cannot be negative!";
        }

        if (seconds < 0 || seconds > 59) {
            return "Invalid parameter: seconds must be in the 0-59 range!";
        }

        int hours = minutes/60;
        int remainingMinutes = minutes%60;
        return  hours+"h "+remainingMinutes+"m "+seconds+"s";
    }

}
