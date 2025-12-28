package section6.Challenges;

public class NatoPhoneticAlphabet {

    public static void main(String[] args) {
        
        System.out.println(getNatoPhoneticCode('g'));
        System.out.println(getNatoPhoneticCode('a'));
        System.out.println(getNatoPhoneticCode('y'));
        System.out.println(getNatoPhoneticCode(' '));

    }

    public static String getNatoPhoneticCode(char c) {

        String phoneticCode = "";

        switch (c) {
            case 'A', 'a': phoneticCode = "Alpha"; break;
            case 'B', 'b': phoneticCode = "Bravo"; break;
            case 'C', 'c': phoneticCode = "Charlie"; break; 
            case 'D', 'd': phoneticCode = "Delta"; break;
            case 'E', 'e': phoneticCode = "Echo"; break;
            case 'F', 'f': phoneticCode = "Foxtrot"; break;
            case 'G', 'g': phoneticCode = "Golf"; break;
            case 'H', 'h': phoneticCode = "Hotel"; break;
            case 'I', 'i': phoneticCode = "India"; break;
            case 'J', 'j': phoneticCode = "Juliett"; break;
            case 'K', 'k': phoneticCode = "Kilo"; break;
            case 'L', 'l': phoneticCode = "Lima"; break;
            case 'M', 'm': phoneticCode = "Mike"; break;
            case 'N', 'n': phoneticCode = "November"; break;
            case 'O', 'o': phoneticCode = "Oscar"; break;
            case 'P', 'p': phoneticCode = "Papa"; break;
            case 'Q', 'q': phoneticCode = "Quebec"; break;
            case 'R', 'r': phoneticCode = "Romeo"; break;
            case 'S', 's': phoneticCode = "Sierra"; break;
            case 'T', 't': phoneticCode = "Tango"; break;
            case 'U', 'u': phoneticCode = "Uniform"; break;
            case 'V', 'v': phoneticCode = "Victor"; break;
            case 'W', 'w': phoneticCode = "Whiskey"; break;
            case 'X', 'x': phoneticCode = "X-ray"; break;
            case 'Y', 'y': phoneticCode = "Yankee"; break;
            case 'Z', 'z': phoneticCode = "Zulu"; break;
            default : phoneticCode = "Code word not found for " + c + " character.";
        }
        return phoneticCode;        
    }

}
