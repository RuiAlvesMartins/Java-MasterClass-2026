package section11.Challenges.DataStructuresWithAbstractClasses;

public interface NodeList {

    abstract ListItem getRoot();                            //  returns root;
    abstract boolean addItem(ListItem listItem);            //  true if added; otherwise false; compareTo() check if alrady there;
    abstract boolean removeItem(ListItem listItem);         //  true if removed; otherwise false; compareTo() to find listItem;
    abstract void traverse(ListItem root);                  //  print each value in a separate line; if root null "The list is empty";

}
