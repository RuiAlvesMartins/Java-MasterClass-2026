package section7.POJOs;

public class StudentPOJO {

    private String id;
    private String name;
    private String dateOfBirth;
    private String classList;

    public StudentPOJO(String id, String name, String dateOfBirth, String classList) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.classList = classList;
    }

    //  this is an ANNOTATION, a type of metadata;
    @Override
    public String toString() {
        return "StudentPOJO {id=" + 
                id + '\'' + ", name=" + 
                name + '\'' + ", dateOfBirth=" + 
                dateOfBirth + '\'' + ", classList=" + 
                classList + '\''
            + "}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getClassList() {
        return classList;
    }

    public void setClassList(String classList) {
        this.classList = classList;
    }
    
    

}
