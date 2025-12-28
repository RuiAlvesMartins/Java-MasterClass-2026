package section6.Loops;

public class SwitchStatement {

    // Primitive data types like LONG, FLOAT, DOUBLE or BOOLEAN or their wrappers CANNOT be USED!
    // FALL THROUGH when case label matches switch variable, code continues to run nontheless!
    // To prevent fall through, you need to use BREAK!

    public static void main(String[] args) {
        
        //  IF STATEMENT
        int value = 1;
        if (value == 1) {
            System.out.println("Value was 1");
        } else if (value == 2) {
            System.out.println("Value was 2");
        } else {
            System.out.println("Was not 1 or 2");
        }

        //  TRADITIONAL SWITCH
        int switchValue = 1;
        switch (switchValue) {
            case 1:
                System.out.println("Value was "+switchValue);
                break;
            case 2:
                System.out.println("Value was "+switchValue);
                break;
            case 3: case 4: case 5:
                System.out.println("Value was a "+switchValue);
                break;
            default:
                System.out.println("Was not 1, 2, 3, 4 or 5");
                break;
        }

        //  ADVANCED SWITCH
        //  Fallthrough doesn't happen in advanced switch, so BREAK is unnecessary
        int advSwitchValue = 5;
        switch (advSwitchValue) {
            case 1 -> System.out.println("Value was "+advSwitchValue);
            case 2 -> System.out.println("Value was "+advSwitchValue);
            case 3, 4, 5 -> {
                System.out.println("Value was "+advSwitchValue);
                System.out.println("It was neither a 1 nor a 2");
            }
            default -> System.out.println("Was not 1, 2, 3, 4 or 5");
        }

        String month = "XYZ";
        System.out.println(month+" is in the "+getQuarterAdvSwitch(month)+" quarter");

    }

    //  Inside a function, you can use RETURN instead of BREAK
    public static String getQuarter(String month) {
        switch (month) {
            case "JANUARY":
            case "FEBRUARY":
            case "MARCH":
                return "1st";
            case "APRIL":
            case "MAY":
            case "JUNE":
                return "2nd";
            case "JULY":
            case "AUGUST":
            case "SEPTEMBER":
                return "3rd";
            case "OCTOBER":
            case "NOVEMBER":
            case "DECEMBER":
                return "4th";
        }
        return "bad";
    }

    //  function with advanced switch; RETURN comes before SWITCH
    public static String getQuarterAdvSwitch(String month) {
        return switch (month) {
            case "JANUARY", "FEBRUARY", "MARCH" -> "1st";
            case "APRIL", "MAY", "JUNE" -> "2nd";
            case "JULY", "AUGUST", "SEPTEMBER" -> "3rd";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4th";
            //  in a codeblock inside the switch, you can't use RETURN; use YIELD instead
            //  YIELD only works inside a code block!
            //  YIELD only works on a RETURN SWITCH or when pointing to a variable!
            default -> {
                String badResponse = month + " is not a valid month!";
                yield badResponse;
            }
        };
    }

}
