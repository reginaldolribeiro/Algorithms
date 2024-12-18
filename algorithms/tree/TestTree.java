package algorithms.tree;

import java.util.List;

public class TestTree {
    public static void main(String[] args) {
        Node root = new Node("2");

        Node first = new Node("1");
        root.insert(root, first);

        root.insert(first, new Node("0"));

        Node fourth = new Node("4");
        root.insert(root, fourth);

        Node third = new Node("3");
        fourth.insert(fourth, third);

        Node fifth = new Node("5");
        fourth.insert(fourth, fifth);

//        System.out.println(root);

        System.out.println("\nTraversing tree...");
//        root.display(root);
        root.traverseTree(root);
//
//        List<String> arrayTree = root.toArrayGpt(root);
//        List<String> arrayTree = root.toArrayNoRecursive(root);
//        System.out.println("Array Tree " + arrayTree);
//
//        String last = arrayTree.get(arrayTree.size()-1);
//        System.out.println("Big element in arrayTree: " + last);

//        int nLargestElement = 1;
//        String largestElement = root.nLargestElement(root, nLargestElement);
//        System.out.println(nLargestElement + " largest element " + largestElement);

//        System.out.println("Size of the Tree: " + root.getSize(root));
//        System.out.println("Size of the Tree: " + root.getSize1(root));

    }
}
