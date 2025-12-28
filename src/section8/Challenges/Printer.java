package section8.Challenges;

// public class Printer {

//     private int tonerLevel;
//     private int pagesPrinted;
//     private boolean duplex;

//     public Printer(int tonerLevel, boolean duplex) {
//         this.tonerLevel = (tonerLevel < 0 || tonerLevel > 100) ? -1 : tonerLevel;
//         this.pagesPrinted = 0;
//         this.duplex = duplex;
//     }

//     public int addToner(int tonerAmount) {
//         if (tonerAmount <= 0 || tonerAmount > 100) {return -1;}
//         if (tonerLevel + tonerAmount > 100) {return -1;}
//         tonerLevel += tonerAmount;
//         return tonerLevel;
//     }

//     public int printPages(int pages) {
//         int pagesToPrint = pages;
//         if (duplex) {
//             System.out.println("Duplex mode");
//             pagesToPrint = pages / 2 + pages % 2;
//         }
//         pagesPrinted += pagesToPrint;
//         return pagesToPrint;
//     }

//     public int getPagesPrinted() {
//         return pagesPrinted;
//     }

// }
