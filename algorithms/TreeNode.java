package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    private String name;
    private List<TreeNode> children;

    public TreeNode(String name){
        this.name = name;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addChild(TreeNode child){
        this.children.add(child);
    }

    public void printTree(TreeNode node){
        System.out.println(node.name);
        for(TreeNode child : node.children){
            printTree(child);
        }
    }

    // DFS Pre-order traversal: Print current node, then its children
    public void preOrder(TreeNode node) {
        if(node == null)
            return;

        // Visit current node
        System.out.println(node.name);

        // Recursively visit children
        for(TreeNode c : node.children){
            preOrder(c);
        }
    }

    // BFS traversal: Use a queue to visit nodes level by level
    public static void bfs(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println(current.name);  // Visit current node

            // Add all children to the queue
            for (TreeNode child : current.children) {
                queue.offer(child);
            }
        }
    }
}
