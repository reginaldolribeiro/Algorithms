package exercises.leetcode.tree;

public class InvertBinaryTree {
    public static void main(String[] args) {
        // Test case 1
        System.out.println("\nTest Case 1 ...");
        TreeNode root = createTestCase1();
        System.out.println("Original Tree ...");
        root.print(root);

        var result = root.invert(root);
//        var result = root.invert1(root);
//        var result = root.invertBfs1(root);
        System.out.println("\nInverted Tree ...");
        if(result != null) {
            result.print(result);
        }
        System.out.println();

        // Test case 2 ...
        System.out.println("\nTest Case 2 ...");
        TreeNode root2 = createTestCase2();
        System.out.println("Original Tree ...");
        root2.print(root2);

        var result2 = root.invert(root2);
        System.out.println("\nInverted Tree ...");
        if(result2 != null) {
            result.print(result2);
        }
        System.out.println();

        // Test case 3 ...
        System.out.println("\nTest Case 3 ...");
        TreeNode root3 = new TreeNode();
        System.out.println("Original Tree ...");
        root3.print(root3);

        var result3 = root.invert(root3);
        System.out.println("\nInverted Tree ...");
        if(result3 != null) {
            result.print(result3);
        }
        System.out.println();
    }

    private static TreeNode createTestCase2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        return root;
    }

    private static TreeNode createTestCase1() {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;

        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(3);
        left.left = left2;
        left.right = right2;

        TreeNode left3 = new TreeNode(6);
        TreeNode right3 = new TreeNode(9);
        right.left = left3;
        right.right = right3;
        return root;
    }

}
