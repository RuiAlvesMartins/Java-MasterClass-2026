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
        NOT_ASSIGNED,
        ASSIGNED,
        IN_PROGRESS,
        COMPLETED,
        CANCELED
    }

    enum Priority {
        LOWEST,
        LOW,
        MEDIUM,
        HIGH,
        HIGHEST
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
            default -> Status.NOT_ASSIGNED;
        };
        this.priority = switch(priority.toUpperCase()) {
            case "LOWEST" -> Priority.LOWEST;
            case "MEDIUM" -> Priority.MEDIUM;
            case "HIGH" -> Priority.HIGH;
            case "HIGHEST" -> Priority.HIGHEST;
            default -> Priority.LOW;
        };
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
            default -> Status.NOT_ASSIGNED;
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
        return "| %-16s | %-24s | %-12s | %-8s |".formatted(project, description, status, priority);
    }

    @Override
    public int hashCode() {
        return 31 * (this.project.hashCode() + this.description.hashCode());
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
