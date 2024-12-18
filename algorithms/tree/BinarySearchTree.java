package algorithms.tree;

public class BinarySearchTree {
    private NodeBinary root;

    public void insert(NodeBinary node){
        root = insertHelper(root, node);
    }
    private NodeBinary insertHelper(NodeBinary root, NodeBinary node){
        if(root == null) {
            root = node;
            return root;
        } else if(node.data < root.data){
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }

        return root;
    }

    public void display(){
        displayHelper(root);
    }
    private void displayHelper(NodeBinary root) {
        if(root != null){
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }

    public void displayReverse(){
        displayReverseHelper(root);
    }
    private void displayReverseHelper(NodeBinary root) {
        if(root != null){
            displayHelper(root.right);
            System.out.println(root.data);
            displayHelper(root.left);
        }
    }

    public boolean search(int data){
        return searchHelper(root, data);
    }
    public boolean searchHelper(NodeBinary root, int data){
        if(root == null){
            return false;
        } else if(root.data == data){
            return true;
        } else if(data < root.data){
            return searchHelper(root.left, data);
        } else {
            return searchHelper(root.right, data);
        }
    }

    public void remove(int data){
        if(search(data)){
            removeHelper(root, data);
        } else {
            System.out.println(data + " could not be found");
        }
    }
    public NodeBinary removeHelper(NodeBinary root, int data){
        if(root == null) {
            return root;
        } else if(data < root.data){
            root.left = removeHelper(root.left, data);
        } else if(data > root.data){
            root.right = removeHelper(root.right, data);
        } else { // node found
            if(root.left == null && root.right == null){
                root = null;
            } else if(root.right != null) { // find a sucessor to replace this node
                root.data = sucessor(root);
                root.right = removeHelper(root.right, root.data);
            } else { // find a predecessor to replace this node
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    private int sucessor(NodeBinary root){ // find the least value below the right child of this node
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    };
    private int predecessor(NodeBinary root){ // find the greatest value below the left child of this node
        root = root.left;
        while (root.right != null){
            root = root.right;
        }
        return root.data;
    };

}
