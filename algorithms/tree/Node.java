package algorithms.tree;

import java.util.*;

public class Node {
    String data;
    Node left;
    Node right;

    public Node(String data){
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public void insert(Node root, Node node) {
        if(node != null){
            if(node.data.compareTo(root.data) < 0){
                root.left = node;
            } else {
                root.right = node;
            }
        }
    }

    public void display(Node root) {
        displayHelper(root);
    }

    private static void displayHelper(Node root) {
        if(root.left == null && root.right == null){
            System.out.println(root.data);
        }
        if(root.left != null){
            displayHelper(root.left);
        }
        if(root.right != null){
            displayHelper(root.right);
        }
    }

    /**
     * DFS: Pre-Order Traversal
     * root -> left -> right
     *
     * @param root
     */
    public void displayPreOrder(Node root) {
        preOrderHelper(root);
    }

    private static void preOrderHelper(Node root) {
        if (root == null) return;
        // Visit (print) current node
        System.out.println(root.data);
        // Traverse left subtree
        preOrderHelper(root.left);
        // Traverse right subtree
        preOrderHelper(root.right);
    }

    /**
     * DFS: In-Order Traversal
     * left -> root -> right
     *
     * @param root
     */
    public void traverseTree(Node root){
        if(root.left != null)
            traverseTree(root.left);

        System.out.println(root.data);

        if(root.right != null)
            traverseTree(root.right);
    }

    /**
     * DFS: Post-Order Traversal
     * left -> right -> root
     *
     * @param root
     * @return
     */
    public void postOrderTraverseTree(Node root){
        if(root.left != null)
            postOrderTraverseTree(root.left);
        if(root.right != null)
            postOrderTraverseTree(root.right);
        System.out.println(root.data);
    }

    public List<String> toArray(Node root){
        List<String> arr = new ArrayList<>();
        toArrayHelper(root, arr);
        return arr;
    }

    private void toArrayHelper(Node root, List<String> arr){
        if(root.left != null)
            toArrayHelper(root.left, arr);

        arr.add(root.data);

        if(root.right != null)
            toArrayHelper(root.right, arr);
    }

    /**
     * BFS
     *  Visits nodes level-by-level starting from the root
     *
     */
    public void displayBFS(Node root){
        if(root == null) return;

        Queue<Node> queue = new LinkedList<>();
//        queue.offer(root);
        queue.add(root);

        while(!queue.isEmpty()){
            Node current = queue.poll();
            System.out.println(current.data);

            if(current.left != null)
                queue.add(current.left);
//                queue.offer(current.left);
            if(current.right != null)
                queue.add(current.right);
//                queue.offer(current.right);
        }
    }

    /**
     * Stack is LIFO (Last In First Out)
     *
     * You must iterate this tree and add each node value into an array, considering the ascending order, which means
     * the smallest comes first.
     * In the end you will have an ordered (sorted) array.
     *
     * @param root
     * @return
     */
    public List<String> toArrayNoRecursive(Node root){
        List<String> arr = new ArrayList<>();
//        Stack<Node> stack = new Stack<>();
        LinkedList<Node> stack = new LinkedList<>();
        Node currentNode = root;

        // Loop until there are no nodes left to process
        while(currentNode != null || !stack.isEmpty()){

            // Iterate to the leftmost node
            while(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            // Process the node
            currentNode = stack.pop();
            arr.add(currentNode.data);

            // Iterate to the right subtree
            currentNode = currentNode.right;
        }

        return arr;
    }


    /**
     * O(n^2) because of Stack.contains()
     *
     * @param root
     * @return
     */
    public List<String> toArrayNoRecursive2(Node root){
        List<String> arr = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;

        while(currentNode != null || !stack.isEmpty()){
            if(!stack.contains(currentNode))
                stack.push(currentNode);

            System.out.println("*** Current node " + currentNode);
//            System.out.println("    Current left " + currentNode.left);

            while(currentNode.left != null && !arr.contains(currentNode.left.data)){
                currentNode = currentNode.left;
                System.out.println("    -> Next left " + currentNode);
                stack.push(currentNode);
            }
            System.out.println("*** Last node data: " + currentNode);

            arr.add(currentNode.data);
            stack.pop();
            if(stack.isEmpty()){
                currentNode = currentNode.right;
                if(currentNode != null)
                    stack.push(currentNode);
            } else {
                currentNode = stack.peek();
            }
        }

        return arr;
    }

    public List<String> toArrayGpt(Node root) {
        List<String> arr = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Current must be null at this point
            current = stack.pop();
            arr.add(current.data); // Add the node's data

            // Visit the right subtree
            current = current.right;
        }

        return arr;
    }

    // 1,2,3,4,5

    /**
     * Get the N largest element in a tree.
     * We should iterate (traverse) a tree including each element into an array keeping and order.
     * Then get the largest element according to the input parameter N.
     *
     * Example:
     *  N = 1, means the first larger element in a tree
     *  Considering this array [1,2,3,4,5] it will be the number 5
     *
     *  N = 3, means the third larger element in a tree
     *  Considering this array [1,2,3,4,5] it will be the number 3
     *
     * @param root
     * @param nLargestNumber
     * @return
     */
    public String nLargestElement(Node root, int nLargestNumber){
        if(nLargestNumber < 0)
            throw new IllegalArgumentException("nLargestNumber needs to be greater than zero");

//        List<String> array = toArray(root);
        List<String> array = toArrayNoRecursive(root);

        if(nLargestNumber > array.size())
            throw new IllegalArgumentException("nLargestNumber needs to be smaller or equal than the size of tree");

        return array.get(array.size() - nLargestNumber);
    }



    public int getSize(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }

    public int getSize1(Node root) {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int size = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            size++;

            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }

        return size;
    }
}
