package section11.Challenges.DataStructuresWithAbstractClasses;

public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return rightLink;
    }

    @Override
    ListItem setNext(ListItem rightLink) {
        this.rightLink = rightLink;
        return rightLink;
    }

    @Override
    ListItem previous() {
        return leftLink;
    }

    @Override
    ListItem setPrevious(ListItem leftLink) {
        this.leftLink = leftLink;
        return leftLink;
    }

    @Override
    int compareTo(ListItem listItem) {
        Comparable comparator = (Comparable)this.value;
        return comparator.compareTo(listItem.getValue());
    }

}
