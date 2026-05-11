package section15.Sets.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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

        Comparator<Task> sortPriority = Comparator.comparing(Task::getPriority);
        Comparator<Task> sortProjectThenTask = Comparator.comparing(Task::getProject).thenComparing(Task::getDescription);
        TaskData.sortAndPrint(TaskData.getTasks(), null);
        TaskData.sortAndPrint(TaskData.getTasks(), sortProjectThenTask);
        TaskData.sortAndPrint(TaskData.getTasks(), sortPriority);
        TaskData.sortAndPrint(TaskData.getTasks("ann"), null);
        TaskData.sortAndPrint(TaskData.getTasks("bob"), null);
        TaskData.sortAndPrint(TaskData.getTasks("carol"), null);



        System.out.printf("%n".repeat(3));
        System.out.println("_".repeat(30));

        Set<Task> annsTasks = TaskData.getTasks("ann");
        Set<Task> bobsTasks = TaskData.getTasks("bob");
        Set<Task> carolsTasks = TaskData.getTasks("carol");
        Set<Task> bossGivenTasks = TaskData.getTasks();

        System.out.println("What is the full task list?");
        Set<Task> allTasks = TaskData.getUnion(bossGivenTasks, annsTasks, bobsTasks, carolsTasks);
        TaskData.printData(allTasks);

        System.out.println("Which tasks are assigned to at least one of the 3 team members?");
        Set<Task> assignedTasks = TaskData.getUnion(annsTasks, bobsTasks, carolsTasks);
        TaskData.printData(assignedTasks);

        System.out.println("Which tasks still need to be assigned?");
        Set<Task> unassignedTasks = TaskData.getDifference(allTasks, assignedTasks);
        TaskData.printData(unassignedTasks);

        System.out.println("Which tasks are assigned to multiple employees?");
        Set<Task> groupTasks = TaskData.getUnion(
            TaskData.getIntersect(annsTasks, bobsTasks),
            TaskData.getIntersect(annsTasks, carolsTasks),
            TaskData.getIntersect(bobsTasks, carolsTasks)
        );
        TaskData.printData(groupTasks);

        System.out.println("Which tasks are overlapping?");
        List<Task> overlap = new ArrayList<>();
        overlap.addAll(TaskData.getIntersect(annsTasks, groupTasks));
        overlap.addAll(TaskData.getIntersect(bobsTasks, groupTasks));
        overlap.addAll(TaskData.getIntersect(carolsTasks, groupTasks));
        Comparator<Task> priorityNatural = sortPriority.thenComparing(Comparator.naturalOrder());
        TaskData.sortAndPrint(overlap, priorityNatural);

    }

}
