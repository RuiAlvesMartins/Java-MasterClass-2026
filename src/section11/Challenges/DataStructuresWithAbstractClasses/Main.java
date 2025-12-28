package section11.Challenges.DataStructuresWithAbstractClasses;

public class Main {
    


    public static void main(String[] args) {
        
        Node node1 = new Node(0);
        Node node2 = new Node(1);

        int comparationResult = node1.compareTo(node2);
        System.out.println(comparationResult);
        System.out.println();

        node1.setValue(1);
        node2.setValue(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(1);
        Node node0 = new Node(0);

        MyLinkedList linkedList = new MyLinkedList(node1);

        // linkedList.addItem(node1);
        linkedList.addItem(node2);
        linkedList.addItem(node9);
        linkedList.addItem(node8);
        linkedList.addItem(node0);
        linkedList.addItem(node10);

        linkedList.removeItem(node1);
        linkedList.removeItem(node0);
        linkedList.removeItem(node9);
        linkedList.removeItem(node2);
        linkedList.removeItem(node8);

        linkedList.addItem(node9);
        linkedList.addItem(node8);
        linkedList.addItem(node7);
        linkedList.addItem(node6);
        linkedList.addItem(node5);
        linkedList.addItem(node4);
        linkedList.addItem(node3);
        linkedList.addItem(node2);
        linkedList.addItem(node1);
        linkedList.addItem(node0);
        linkedList.addItem(node10);

        System.out.println("Linked List:");
        linkedList.traverse(linkedList.getRoot());
        System.out.println();



        SearchTree tree = new SearchTree(node4);

        //  testing addItem()
        tree.addItem(node1);
        tree.addItem(node3);
        tree.addItem(node7);
        tree.addItem(node9);
        tree.addItem(node10);

        //  testing traverse()
        System.out.println();
        tree.traverse(node4);
        
        //  testing removeItem()
        tree.removeItem(node1);
        tree.removeItem(node3);
        tree.removeItem(node7);
        tree.removeItem(node9);

        System.out.println();
        tree.traverse(node4);

        //  testing removeItem() on items with 0 children
        System.out.println();
        SearchTree tree1 = new SearchTree(node4);
        tree1.addItem(node1);
        tree1.addItem(node2);
        tree1.addItem(node3);
        tree1.traverse(node4);

        System.out.println();
        tree1.removeItem(node3); 
        tree1.traverse(node4);
        // System.out.println("Node 2 right link: " + node2.next().getValue());         //  NullPointerException as expected

        //  testing removeItem() in items with 1 child
        System.out.println();
        tree1.addItem(node3);
        tree1.addItem(node9);
        tree1.addItem(node8);
        tree1.addItem(node7);
        tree1.traverse(node4);

        //  single child left
        System.out.println();
        System.out.println("Node 4 left link: " + node4.previous().getValue());         //  1 as expected
        tree1.removeItem(node1);
        tree1.traverse(node4);
        System.out.println("Node 4 left link: " + node4.previous().getValue());         //  2 as expected
        System.out.println("Node 2 right link: " + node2.next().getValue());            //  3 as expected

        //  single child right
        System.out.println();
        System.out.println("Node 4 right link: " + node4.next().getValue());            //  9 as expected
        tree1.removeItem(node9);
        tree1.traverse(node4);
        System.out.println("Node 4 right link: " + node4.next().getValue());            //  8 as expected
        System.out.println("Node 8 left link: " + node8.previous().getValue());         //  7 as expected

        //  testing removeItem() with 2 children
        System.out.println();
        SearchTree tree2 = new SearchTree(node0);
        tree2.addItem(node2);
        tree2.addItem(node1);
        tree2.addItem(node8);
        tree2.addItem(node9);
        tree2.addItem(node6);
        tree2.addItem(node7);
        tree2.addItem(node4);
        tree2.addItem(node5);
        tree2.traverse(node0);

        System.out.println();
        tree2.removeItem(node2);
        tree2.traverse(node0);
        System.out.println("Node 0 right link: " + node0.next().getValue());            //  4 as expected
        System.out.println("Node 4 left link: " + node4.previous().getValue());         //  1 as expected
        System.out.println("Node 4 right link: " + node4.next().getValue());            //  8 as expected
        System.out.println("Node 6 left link: " + node6.previous().getValue());         //  5 as expected

        System.out.println();
        SearchTree tree3 = new SearchTree(node9);
        tree3.addItem(node1);
        tree3.addItem(node0);
        tree3.addItem(node7);
        tree3.addItem(node8);
        tree3.addItem(node5);
        tree3.addItem(node3);
        tree3.addItem(node6);
        tree3.addItem(node4);
        tree3.traverse(node9);

        System.out.println();
        tree3.removeItem(node1);
        tree3.traverse(node9);
        System.out.println("Node 9 left link: " + node9.previous().getValue());         //  3 as expected
        System.out.println("Node 3 left link: " + node3.previous().getValue());         //  0 as expected
        System.out.println("Node 3 right link: " + node3.next().getValue());            //  7 as expected
        System.out.println("Node 5 left link: " + node5.previous().getValue());         //  4 as expected

        //  testing removeItem() on ROOT
        System.out.println();
        SearchTree tree4 = new SearchTree(node4);
        tree4.addItem(node1);
        tree4.addItem(node3);
        tree4.addItem(node7);
        tree4.addItem(node9);
        tree4.traverse(node4);

        System.out.println();
        tree4.removeItem(node4);
        tree4.traverse(node7);
        System.out.println("Node 7 left link: " + node7.previous().getValue());         //  1 as expected
        System.out.println("Node 7 right link: " + node7.next().getValue());            //  9 as expected

        //  item not found works
        System.out.println();
        System.out.println(tree4.removeItem(node2));

    }

}
