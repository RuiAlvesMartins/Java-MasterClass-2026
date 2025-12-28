package section8.Challenges.Printer;

public class Main {

    public static void main(String[] args) {
        
        Printer printer = new Printer();

        printer.printPages(1);

        printer.addToner(-1);
        printer.getTonerLevel();
        printer.addToner(200);
        printer.getTonerLevel();

        printer.printPages(50);
        printer.printPages(51);

        Printer duplexPrinter = new Printer(true);
        duplexPrinter.addToner(100);
        duplexPrinter.printPages(50);

    }

}
