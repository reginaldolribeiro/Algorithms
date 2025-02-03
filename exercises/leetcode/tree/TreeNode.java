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

    public TreeNode invert(TreeNode root){
        if(root == null)
            return null;

        TreeNode left = invert(root.left);
        TreeNode right = invert1(root.right);

        root.left = right;
        root.right = left;

        return root;
    }


    public TreeNode invert1(TreeNode root){
        if(root == null)
            return null;
        return invertHelper(root);
    }
    private TreeNode invertHelper(TreeNode root) {
        if(root == null)
            return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null)
            invertHelper(root.left);
        if(root.right != null)
            invertHelper(root.right);

        return root;
    }

    public TreeNode invertBfs(TreeNode root){
        if(root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if(current.left != null) {
                queue.offer(current.left);
            }
            if(current.right != null) {
                queue.offer(current.right);
            }
        }
        return root;
    }


//    public TreeNode invertBfs1(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//
//        // Cria a raiz para a nova árvore
//        TreeNode newRoot = new TreeNode(root.val);
//
//        // Fila para percorrer a árvore original
//        Queue<TreeNode> originalQueue = new LinkedList<>();
//        // Fila para percorrer a árvore invertida que está sendo construída
//        Queue<TreeNode> newQueue = new LinkedList<>();
//
//        originalQueue.offer(root);
//        newQueue.offer(newRoot);
//
//        while (!originalQueue.isEmpty()) {
//            TreeNode current = originalQueue.poll();
//            TreeNode newCurrent = newQueue.poll();
//
//            // Se existir filho esquerdo na original,
//            // ele se tornará o filho direito na nova.
//            if (current.left != null) {
//                newCurrent.right = new TreeNode(current.left.val);
//                originalQueue.offer(current.left);
//                newQueue.offer(newCurrent.right);
//            }
//
//            // Se existir filho direito na original,
//            // ele se tornará o filho esquerdo na nova.
//            if (current.right != null) {
//                newCurrent.left = new TreeNode(current.right.val);
//                originalQueue.offer(current.right);
//                newQueue.offer(newCurrent.left);
//            }
//        }
//
//        return newRoot;
//    }

    public void print(TreeNode root){
        if(root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if(current.left != null)
                queue.offer(current.left);
            if(current.right != null)
                queue.offer(current.right);
        }
    }

}
