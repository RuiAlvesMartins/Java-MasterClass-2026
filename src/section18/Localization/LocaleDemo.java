package section18.Localization;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class LocaleDemo {
    
    //  Where you are matters, as it determines how you expect to see dates, currencies, numbers, etc. 
    //  Many countries have different currency symbols and scales for least significant currency digit;



    //  INTERNATINALIZATION     a.k.a. I18n   
    //  method for application design that incorporates language and regional elements, through LOCALE;  
    //  strings used in messages or user interface elements and images are stored externally to the application;
    //  these can be retrieved using a Locale, and then displayed for a specific user;
    //  Java uses ResourceBundle class to support this feature; 


    
    //  java.util.LOCALE
    //  underpins built-in support for Localization and Internationalization;
    //  is composed of:
    //          BaseLocale:
    //                  language (String);
    //                  region (String);
    //                  script (String);
    //                  variant (String);
    //          LocalExtentions:

    //  JDK17 supported Locales:
    //  https://www.oracle.com/java/technologies/javase/jdk17-suported-locales.html#compatlocales



    public static void main(String[] args) {
        
        Locale.setDefault(Locale.PRC);
        System.out.println("Default Locale = " + Locale.getDefault());

        Locale.setDefault(Locale.US);
        System.out.println("Default Locale = " + Locale.getDefault());



        //  Instantiating Locale
        //  the Locale(String) constructor is deprecated as of JDK19;
        //  however, this is what Tim Buchalka used to teach JDK17;
        //  just keep in mind that now there is a better way of doing this!
        Locale en = new Locale("en");
        Locale enAU = new Locale("en", "AU");
        Locale enCA = new Locale("en", "CA"); 
        
        //  Locale.Builder()
        //  this is probably the new correct way
        Locale enIN = new Locale.Builder().setLanguage("en").setRegion("IN").build();
        Locale enNZ = new Locale.Builder().setLanguage("en").setRegion("NZ").build();



        //  passing a Locale to a LocalDateTime
        var dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        for (var locale : List.of(
                Locale.getDefault(), Locale.US, en, enAU, enCA, Locale.UK, enIN, enNZ
        )) {
            System.out.println(locale.getDisplayName() + "= " + LocalDateTime.now().format(dtf.withLocale(locale)));
        }
        System.out.println();



        DateTimeFormatter wdayMonth = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        LocalDate May5 = LocalDate.of(2020, 5, 5);

        for (var locale : List.of(Locale.CANADA, Locale.CANADA_FRENCH, Locale.FRANCE,
                Locale.GERMANY, Locale.PRC, Locale.JAPAN, Locale.ITALY )) {
                            //  .getDisplayName() displays the names in english;
            System.out.println(locale.getDisplayName() + " : " + 
                            //  .getDisplayName(Locale) displays the names in the local language;
                            locale.getDisplayName(locale) + 
                            May5.format(wdayMonth.withLocale(locale)));

            //  this should work, but it doesn't
            // System.out.printf(String.format(locale, "\t%1$tA, %1$tB %1$e, %1$tY %n", May5));



            //  NumberFormat allows you to print a number with a specific region format;
            //  NumberFormat is IMMUTABLE;
            NumberFormat decimalInfo = NumberFormat.getNumberInstance(locale);
            decimalInfo.setMaximumFractionDigits(6);
            System.out.println(decimalInfo.format(123456789.123456));



            //  Currency
            NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
            Currency localCurrency = Currency.getInstance(locale);
            System.out.println(currency.format(555.555) + " [" +
                    localCurrency.getCurrencyCode() + "] " +
                    //  local language
                    localCurrency.getDisplayName(locale) + "/" +
                    //  english language
                    localCurrency.getDisplayName()
            );
        }



        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the loan amount: ");
        //  BigDecimal(String) constructor can't have special format characters!
        // BigDecimal myLoan = new BigDecimal("1,000.50");                             //  runtime error!

        //  Scanner.nextBigDecimal() allows user to input a formated number;
        //  but keep in mind: only the local format is accepted!
        //  if you pass a format from a different locale, it will throw exception!
        scanner.useLocale(Locale.ITALY);
        BigDecimal myLoan = scanner.nextBigDecimal();
        NumberFormat decimalInfo = NumberFormat.getNumberInstance(Locale.ITALY);
        //  NumberFormat.format(arg) can be used to retrive a string with the local format:
        System.out.println("My Loan " + decimalInfo.format(myLoan));
        //  Input:  1,000.50            Output: InputMismatchException
        //  Input:  1.000,50            Output: My Loan 1.000,50

    }

}
