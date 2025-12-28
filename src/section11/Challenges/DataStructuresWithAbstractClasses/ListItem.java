package section11.Challenges.DataStructuresWithAbstractClasses;

public abstract class ListItem {

    protected ListItem rightLink;
    protected ListItem leftLink;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    //  package-private means protected? NO!
    //  https://idratherbewriting.com/java-access-modifiers/
    abstract ListItem next();                                   //  returns ListItem to the right;
    abstract ListItem setNext(ListItem rightLink);              //  sets rightLink; returns rightLink;
    abstract ListItem previous();                               //  returns ListItem to the left;
    abstract ListItem setPrevious(ListItem leftLink);           //  sets leftLink; returns leftLink;
    abstract int compareTo(ListItem listItem);                  //  0 if equal; positive if this>argument; negative if this<argument;
    
    Object getValue() {
        return value;
    } 

    void setValue(Object value) {
        this.value = value;
    }                       

}
