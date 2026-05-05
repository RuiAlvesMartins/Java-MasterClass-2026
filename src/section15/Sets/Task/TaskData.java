package section15.Sets.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TaskData {

    static Set<Task> getTasks(String employee) throws FileNotFoundException {

        employee = employee.substring(0, 1).toUpperCase() 
                    + employee.substring(1, employee.length()).toLowerCase();
        employee = employee.trim();
        boolean employeeFound = false;

        Set<Task> tasks = new HashSet<>();
        Scanner setsOperationsData = new Scanner(new File("SetsOperationsData.csv"));

        while (setsOperationsData.hasNextLine()) {

            String nextLine = setsOperationsData.nextLine();

            //  triggers employeeFound;
            if (nextLine.contains(employee)) {
                employeeFound = true;
                // System.out.println(nextLine + ": ");
            }

            //  breaks loop once all taks are iterated over; 
            if (nextLine.isBlank() && employeeFound) {
                break;
            }

            //  iterates over employee's tasks;
            if (employeeFound && nextLine.contains(",")) {
                String[] taskParts = nextLine.split(",");
                Task task = new Task(
                    employee.equals("All") ? "" : employee, 
                    taskParts[0].trim(),
                    taskParts[1].trim(), 
                    employee.equals("All") ? "" : taskParts.length >= 4 ? taskParts[3].trim() : "assigned",
                    taskParts.length >= 3 ? taskParts[2].trim() : "low"
                );
                // System.out.println(task);
                tasks.add(task);
            }

        }

        if (!employeeFound) {
            System.out.println(employee + " has not been found on the dataset!");
        }

        setsOperationsData.close();

        return tasks;

    }

    static Set<Task> getTasks() throws FileNotFoundException {
        
        return TaskData.getTasks("all");

    }

    static void printData(Set<Task> tasks) {

        System.out.println();

        //  this is one way to iterate through sets;
        //  alternatives are a forEach loop, or casting the Set into a List;
        Iterator<Task> taskIterator = tasks.iterator();

        //  prints header and first task on the set;
        if (taskIterator.hasNext()) {
            Task firstTask = taskIterator.next();
            String assignee = firstTask.getAssignee();
            String title = "%s Tasks: ".formatted(assignee.isBlank() ? "All" : assignee + "'s ");
            String header = "| %-16s | %-24s | %-12s | %-12s | %-8s |".formatted("Project", "Task", "Status", "Assigned to", "Priority");

            System.out.println(title);
            System.out.println("_".repeat(88));
            System.out.println(header);
            System.out.println("_".repeat(88));
            System.out.println(firstTask);
        }
        
        //  prints remaining tasks;
        while (taskIterator.hasNext()) {
            Task task = taskIterator.next();
            System.out.println(task);
        }
        System.out.println("_".repeat(88));

    }

    static void sortAndPrint(Collection<Task> collection, Comparator<Task> sorter) {
        String lineSeparator = "_".repeat(90);
        String header = "| %-16s | %-24s | %-12s | %-12s | %-8s |".formatted("Project", "Task", "Status", "Assigned to", "Priority");
        System.out.println();
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
        System.out.println(lineSeparator);
    }

}
