package exercises.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // Recursively inverts a binary tree (DFS approach)
    public TreeNode invert(TreeNode root){
        if(root == null)
            return null;

        // Recursively invert left and right subtrees
        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);

        // Swap left and right children
        root.left = right;
        root.right = left;

        return root;
    }

    // Wrapper function to invert the tree using a helper method
    public TreeNode invert1(TreeNode root){
        if(root == null)
            return null;
        return invertHelper(root);
    }
    // Recursive helper function to swap left and right children
    private TreeNode invertHelper(TreeNode root) {
        if(root == null)
            return root;

        // Swap left and right child nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert left and right subtrees
        if(root.left != null)
            invertHelper(root.left);
        if(root.right != null)
            invertHelper(root.right);

        return root;
    }

    // Iteratively inverts a binary tree using BFS (level-order traversal)
    public TreeNode invertBfs(TreeNode root){
        if(root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            // Swap left and right children
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Enqueue children for processing
            if(current.left != null) {
                queue.offer(current.left);
            }
            if(current.right != null) {
                queue.offer(current.right);
            }
        }
        return root;
    }

    // Prints the tree in level-order (BFS)
    public void print(TreeNode root){
        if(root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            // Enqueue left and right children for processing
            if(current.left != null)
                queue.offer(current.left);
            if(current.right != null)
                queue.offer(current.right);
        }
    }

}
