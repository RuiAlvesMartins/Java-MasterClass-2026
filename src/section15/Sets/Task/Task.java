package section15.Sets.Task;

public class Task implements Comparable<Task>{

/** 
 *  each of these attributes should be editable!!!!!
 *  assignee
 *  project name
 *  description
 *  status
 *  priority
 * 
 *  task uniquely identified by project and description;
 *  implements comparable so that tasks are sorted by project and description
 * 
*/

    enum Status {
        COMPLETED,
        CANCELED,
        IN_PROGRESS,
        ASSIGNED,
        IN_QUEUE
    }

    enum Priority {
        HIGHEST,
        HIGH,
        MEDIUM,
        LOW,
        LOWEST
    }

    private String assignee;
    private String project;
    private String description;
    private Status status;
    private Priority priority;

    public Task(String assignee, String project, String description, String status, String priority) {
        this.assignee = assignee;
        this.project = project;
        this.description = description;
        this.status = switch(status.toUpperCase()) {
            case "ASSIGNED" -> Status.ASSIGNED;
            case "IN PROGRESS" -> Status.IN_PROGRESS;
            case "COMPLETED" -> Status.COMPLETED;
            case "CANCELED" -> Status.CANCELED;
            default -> Status.IN_QUEUE;
        };
        this.priority = switch(priority.toUpperCase()) {
            case "LOWEST" -> Priority.LOWEST;
            case "MEDIUM" -> Priority.MEDIUM;
            case "HIGH" -> Priority.HIGH;
            case "HIGHEST" -> Priority.HIGHEST;
            default -> Priority.LOW;
        };
    }

    public Task(String assignee, String project, String description, String priority) {
        this(assignee, project, description, 
            assignee == null ? "in queue" : "assigned",
            priority
        );
    }

    public Task(String project, String description, String priority) {
        this(null, project, description, priority);
    }

    public String getAssignee() {
        return assignee;
    }

    void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getProject() {
        return project;
    }

    void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    void setStatus(String status) {
        this.status = switch(status.toUpperCase()) {
            case "ASSIGNED" -> Status.ASSIGNED;
            case "IN PROGRESS" -> Status.IN_PROGRESS;
            case "COMPLETED" -> Status.COMPLETED;
            case "CANCELED" -> Status.CANCELED;
            default -> Status.IN_QUEUE;
        };
    }

    public Priority getPriority() {
        return priority;
    }

    void setPriority(String priority) {
        this.priority = switch(priority.toUpperCase()) {
            case "LOWEST" -> Priority.LOWEST;
            case "MEDIUM" -> Priority.MEDIUM;
            case "HIGH" -> Priority.HIGH;
            case "HIGHEST" -> Priority.HIGHEST;
            default -> Priority.LOW;
        };
    }



    @Override
    public String toString() {
        return "| %-16s | %-24s | %-12s | %-12s | %-8s |".formatted(project, description, status, assignee, priority);
    }

    @Override
    public int hashCode() {
        int result = this.getProject().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        //  Since obj has been confirmed to be of type Task and not be null;
        //  it can safely be cast to Task;
        Task that = (Task) obj;

        return this.project.equals(that.project) && 
                this.description.equals(that.description);
    }

    @Override
    public int compareTo(Task o) {

        int projectComparisson = this.project.compareTo(o.project);

        if (projectComparisson != 0) {
            return projectComparisson;
        }

        return this.description.compareTo(o.description);
    }




}
