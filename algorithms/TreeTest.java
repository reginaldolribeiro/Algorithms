package algorithms;

public class TreeTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode("Documents");
        TreeNode work = new TreeNode("Work");
        TreeNode school = new TreeNode("School");
        TreeNode photos = new TreeNode("Photos");

        root.addChild(work);
        root.addChild(school);
        root.addChild(photos);

        TreeNode reports = new TreeNode("Reports");
        TreeNode invoices = new TreeNode("Invoices");
        work.addChild(reports);
        work.addChild(invoices);

        root.printTree(root);

//        System.out.println("Pre-order Traversal:");
//        root.preOrder(root);

//        System.out.println("\nBFS Traversal:");
//        root.bfs(root);
//        var root = new TreeNode("Folder");
//        var documents = new TreeNode("Documents");
//        var pictures = new TreeNode("Pictures");
//
//        root.add(documents);
//        root.add(pictures);
//
//        var picturesFromX = new TreeNode("Pictures From X");
//        pictures.add(picturesFromX);
//
//        System.out.println("Pre-order traversal");
//        root.preOrder(root);
//
//        System.out.println("\nBFS Traversal:");
//        root.bfs(root);
    }
}
