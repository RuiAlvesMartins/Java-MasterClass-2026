package section11.Challenges.DataStructuresWithAbstractClasses;

public class MyLinkedList implements NodeList {

    private ListItem root;

    public MyLinkedList(ListItem root) {
        root.setPrevious(null);
        root.setNext(null);
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem listItem) {
        if (root == null) {
            this.root = listItem;
            return true;
        }
        listItem.setPrevious(null);
        listItem.setNext(null);
        ListItem currentItem = root;
        int comparissonOutcome;
        while (currentItem != null) {
            // System.out.println(currentItem.getValue());
            // System.out.println(listItem.getValue());
            comparissonOutcome = currentItem.compareTo(listItem);
            //  item already on the list
            if (comparissonOutcome == 0) {
                return false;
            }
            //  item gets added here
            if (comparissonOutcome > 0) {
                //  new item is the new root
                if (currentItem.previous() == null) {
                    currentItem.setPrevious(listItem);
                    listItem.setPrevious(null);
                    listItem.setNext(currentItem);
                    this.root = listItem;
                    return true;
                }
                //  new item sandwiched between two existing nodes
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(listItem);
                    currentItem.setPrevious(listItem);
                    listItem.setPrevious(currentItem.previous());
                    listItem.setNext(currentItem);
                    return true;
                }
            }
            //  new item gets added last
            if (currentItem.next() == null) {
                currentItem.setNext(listItem);
                listItem.setPrevious(currentItem);
                listItem.setNext(null);
                return true;
            }

            currentItem = currentItem.next();
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem listItem) {
        if (root == null) {
            //  list is empty
            return false;
        }
        ListItem currentItem = root;
        while (currentItem != null) {
            if (currentItem.compareTo(listItem) == 0) {
                //  found item in the list

                //  has left and right link
                if (currentItem.previous() != null && currentItem.next() != null) {
                    //  setting left link
                    currentItem.previous().setNext(currentItem.next());
                    //  setting right link
                    currentItem.next().setPrevious(currentItem.previous());
                    //  breaking links on deleted item
                    currentItem.setPrevious(null);
                    currentItem.setNext(null);

                    return true;
                }

                //  no left or right links (list has only one element)
                if (currentItem.previous() == null && currentItem.next() == null) {
                    this.root = null;

                    return true;
                }

                //  no left link
                if (currentItem.previous() == null) {
                    this.root = currentItem.next();
                    currentItem.next().setPrevious(null);
                    currentItem.setNext(null);
                    
                    return true;
                }

                //  no right link
                if (currentItem.next() == null) {
                    currentItem.previous().setNext(null);
                    currentItem.setPrevious(null);

                    return true;
                }

                
            }

            currentItem = currentItem.next();

        }
        //  item not found on the list;
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty ");
        }
        ListItem currentItem = root;
        while (currentItem != null) {
            System.out.println(currentItem.getValue());
            currentItem = currentItem.next();
        }
    }

    

}
