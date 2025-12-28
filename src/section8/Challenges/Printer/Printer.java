package section8.Challenges.Printer;
public class Printer {

    private int tonerLevel; //  0 - 100%
    private int pagesPrinted;  // count of pages printed
    private boolean isDuplex;  //  true prints both sides, false prints one side

    public int addToner(int tonerAmount) {
        if (tonerAmount < 1) {return -1;}
        tonerLevel += tonerAmount;
        if (tonerLevel > 100) {
            tonerLevel = 100;
            System.out.println("Toner is full!");
        }
        return tonerLevel;
    }

    private int printToner(int tonerAmount) {
        if (tonerAmount < 1) {return -1;}
        if (tonerLevel < tonerAmount) {
            System.out.println("Not enough ink in toner!");
            return -1;
        }
        tonerLevel -= tonerAmount;
        return tonerLevel;
    }

    public int printPages(int pagesToPrint) {
        if (pagesToPrint < 1) {return -1;}
        
        int sheetsNeeded = 0;

        if (isDuplex) {
            System.out.println("Duplex printer");
            sheetsNeeded = pagesToPrint / 2 + pagesToPrint % 0;
        } else {
            sheetsNeeded = pagesToPrint;
        }

        this.pagesPrinted += pagesToPrint;

        System.out.println(String.format("Need %s sheets of paper", sheetsNeeded));
        System.out.println(String.format("Will spend %s%% of the toner", pagesToPrint));
        if (printToner(pagesToPrint) != -1) {
            System.out.println(String.format("Toner remaining = %s%%", tonerLevel));
        }
        
        return sheetsNeeded;
    }

    protected Printer(int tonerLevel, int pagesPrinted, boolean isDuplex) {
        this.tonerLevel = tonerLevel < 0 ? 0 : tonerLevel > 100 ? 100 : tonerLevel;
        this.pagesPrinted = pagesPrinted < 0 ? 0 : pagesPrinted;
        this.isDuplex = isDuplex;
    }

    public Printer(boolean isDuplex) {
        this(0, 0, isDuplex);
    }

    public Printer() {
        this(0, 0, false);
    }

    public int getTonerLevel() {
        System.out.println(String.format("Toner level = %s%%", tonerLevel));
        return tonerLevel;
    }

    public int getPagesPrinted() {
        System.out.println(String.format("Pages printed = %s%%", pagesPrinted));
        return pagesPrinted;
    }

    

}
