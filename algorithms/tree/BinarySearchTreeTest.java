package algorithms.tree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {

        // Binary Search Tree = A tree data structure, where each node is greater than it's a left child,
        //                      but less than it's right.
        //
        //                      benefit: easy to locate a node when they are in this order
        //
        //                      time complexity: best case O(log n)
        //                                       worst case O(n)
        //
        //                      space complexity: O(n)

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(new NodeBinary(5));
        tree.insert(new NodeBinary(1));
        tree.insert(new NodeBinary(9));
        tree.insert(new NodeBinary(2));
        tree.insert(new NodeBinary(7));
        tree.insert(new NodeBinary(3));
        tree.insert(new NodeBinary(6));
        tree.insert(new NodeBinary(4));
        tree.insert(new NodeBinary(8));

//        tree.remove(1);
        tree.display();
//        tree.displayReverse();

//        System.out.println(tree.search(4));

//        tree.remove(0);
    }
}
