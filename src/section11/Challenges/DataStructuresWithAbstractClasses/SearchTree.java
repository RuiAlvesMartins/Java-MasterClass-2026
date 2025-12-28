package section11.Challenges.DataStructuresWithAbstractClasses;

public class SearchTree implements NodeList {

    //  What is a Binary Search Tree?
    //  https://youtu.be/mtvbVLK5xDQ?si=OigKyPOul_juGX7h
    //  https://www.youtube.com/watch?v=wcIRPqTR3Kc

    private ListItem root;

    public SearchTree(ListItem root) {
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
            comparissonOutcome = currentItem.compareTo(listItem);

            //  item already on the tree
            if (comparissonOutcome == 0) {
                return false;
            }
            //  insert left
            if (comparissonOutcome > 0 && currentItem.previous() == null) {
                currentItem.setPrevious(listItem);
                return true;
            }
            //  insert right
            if (comparissonOutcome < 0 && currentItem.next() == null) {
                currentItem.setNext(listItem);
                return true;
            }
            //  move left
            if (comparissonOutcome > 0) {
                currentItem = currentItem.previous();
                continue;
            }
            //  move right
            if (comparissonOutcome < 0) {
                currentItem = currentItem.next();
                continue;
            }
        }
        System.out.println("//  if code got here, something went wrong");
        return false;
    }

    @Override
    public boolean removeItem(ListItem listItem) {
        if (root == null) {
            //  list is empty
            return false;
        }
        ListItem parentItem = root;
        ListItem leftChildItem;
        ListItem rightChildItem;
        int comparissonOutcome;

        while (parentItem != null) {
            comparissonOutcome = parentItem.compareTo(listItem);
            leftChildItem = parentItem.previous();
            rightChildItem = parentItem.next();

            //  delete ROOT
            if (comparissonOutcome == 0) {
                //  we can't call performRemovel(parentItem, childItem) because root has no parent!
                //  that's why we make up a new root (everything is possible when you make stuff up)
                ListItem newRoot = new Node(Integer.MIN_VALUE);
                if (newRoot.compareTo(listItem) < 0) {
                    newRoot.setNext(listItem);
                }
                if (newRoot.compareTo(listItem) >= 0) {
                    newRoot.setValue(Integer.MIN_VALUE + 1);
                    newRoot.setPrevious(listItem);
                }
                performRemoval(newRoot, listItem);
                this.root = newRoot.previous() == null ? newRoot.next() : newRoot.previous();
                return true;
            }

            //  check or move LEFT
            if (comparissonOutcome > 0) {
                //  item not found, break while loop
                if (leftChildItem == null) {
                    break;
                }
                //  check left
                if (leftChildItem.compareTo(listItem) == 0) {
                    //  call to remove method
                    performRemoval(parentItem, leftChildItem);
                    return true;
                }
                //  if left link is not item nor null, continue search
                parentItem = leftChildItem;
                continue;
            }

            //  check or move RIGHT
            if (comparissonOutcome < 0) {
                //  item not found, break while loop
                if (rightChildItem == null) {
                    break;
                }
                //  check right
                if (rightChildItem.compareTo(listItem) == 0) {
                    //  call to remove method
                    performRemoval(parentItem, rightChildItem);
                    return true;
                }
                //  if right link is not item nor null, continue search
                parentItem = rightChildItem;
                continue;
            }

        }
        //  item not found
        return false;
    }

    //  RECURSION
    @Override
    public void traverse(ListItem currentItem) {
        if (currentItem == null) {
            //  This return only exits the current call of the function, NOT the earlier ones!
            return;
        }

        //  function  will be called recursivelly untill it has no more LEFT links;
        //  the return on the previous if statement will break current recursive cycle;
        traverse(currentItem.previous());

        System.out.println(currentItem.getValue());

        //  function  will be called recursivelly untill it has no more RIGHT links;
        //  the return on the previous if statement will break current recursive cycle;
        traverse(currentItem.next());
    }

    private void performRemoval(ListItem parentItem, ListItem childItem) {
        boolean isRightChild = false;
        if (parentItem.next() != null) {
            if (childItem.compareTo(parentItem.next()) == 0) {
                isRightChild = true;
            }
        }

        //  delete node with 0 children
        //  node is simply deleted
        if (childItem.previous() == null && childItem.next() == null) {
            if (isRightChild) {
                parentItem.setNext(null);
                return;
            }
            if (!isRightChild) {
                parentItem.setPrevious(null);
                return;
            }
        }

        //  delete node with 1 child
        //  node is replaced by it's only child
        if (childItem.previous() == null || childItem.next() == null) {
            //  works for both left and right grandChild
            ListItem onlyGrandChild = childItem.previous() == null ? childItem.next() : childItem.previous();
            if (isRightChild) {
                parentItem.setNext(onlyGrandChild);
                return;
            }
            if (!isRightChild) {
                parentItem.setPrevious(onlyGrandChild);
                return;
            }
        }

        //  delete node with 2 child
        //  move 1 step right
        ListItem rightGrandChild = childItem.next();
        //  then move left always till you hit a null
        ListItem leftChildren = rightGrandChild.previous();
        ListItem previousGrandChild = rightGrandChild;
        if (leftChildren == null) {
            if (isRightChild) {
                parentItem.setNext(rightGrandChild);
                rightGrandChild.setPrevious(childItem.previous());
                childItem.setPrevious(null);
                childItem.setNext(null);
                return;
            }
            if (!isRightChild) {
                parentItem.setPrevious(rightGrandChild);
                rightGrandChild.setPrevious(childItem.previous());
                childItem.setPrevious(null);
                childItem.setNext(null);
                return;
            }
        }
        //  rightGrandChild has left links
        //  loop untill the last one
        //  the last left link will replace childItem
        while (leftChildren != null) {
            if (leftChildren.previous() == null) {
                if (isRightChild) {
                    parentItem.setNext(leftChildren);
                    previousGrandChild.setPrevious(leftChildren.next());
                    leftChildren.setPrevious(childItem.previous());
                    leftChildren.setNext(childItem.next());
                    childItem.setPrevious(null);
                    childItem.setNext(null);
                    return;
                }
                if (!isRightChild) {
                    parentItem.setPrevious(leftChildren);
                    previousGrandChild.setPrevious(leftChildren.next());
                    leftChildren.setPrevious(childItem.previous());
                    leftChildren.setNext(childItem.next());
                    childItem.setPrevious(null);
                    childItem.setNext(null);
                    return;
                }
            }
            // System.out.println("previousGrandChild old: " + previousGrandChild.getValue());
            previousGrandChild = leftChildren;
            // System.out.println("previousGrandChild new: " + previousGrandChild.getValue());
            // System.out.println("leftChildren old: " + leftChildren.getValue());
            leftChildren = leftChildren.previous();
            // System.out.println("leftChildren new: " + leftChildren.getValue());
        }

    }

    // @Override
    // public void traverse(ListItem currentItem) {
    //     while (currentItem != null) {
    //         String previousValue = currentItem.previous() != null ? (String) currentItem.previous().getValue() : "null";
    //         String currentValue = (String) currentItem.getValue();
    //         String nextValue = currentItem.next() != null ? (String) currentItem.next().getValue() : "null";
    //         String string = String.format("%s -> %s -> %s", previousValue, currentValue, nextValue);
    //         System.out.println(string);

    //         traverse(currentItem.next());
    //     }
    // }
    
}
