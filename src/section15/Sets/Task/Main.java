package section15.Sets.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {

        // System.out.println();
        // //  This reveals the working directory from where files should be;
        // System.out.println(new File(".").getAbsolutePath());
        // System.out.println();
        
        // Scanner setsOperationsData = new Scanner(new File("SetsOperationsData.csv"));
        // //  Test if file was scanned properly;
        // while (setsOperationsData.hasNextLine()) {
        //     System.out.println(setsOperationsData.nextLine());
        // }
        // setsOperationsData.close();

        // TaskData.getTasks("ann");
        TaskData.printData(TaskData.getTasks("carol"));
        TaskData.printData(TaskData.getTasks());

    }

}
