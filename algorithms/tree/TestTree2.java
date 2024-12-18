package algorithms.tree;

public class TestTree2 {
    public static void main(String[] args) {
        var a = new Node("A");
        var b = new Node("B");
        var c = new Node("C");
        var d = new Node("D");
        var e = new Node("E");
        var f = new Node("F");
        var g = new Node("G");

        a.left = b;  // A->B
        a.right = c; // A->C
        b.left = d;  // B->D
        b.right = e; // B->E
        c.left = f;  // C->F
        c.right = g; // C->G
//        c.right = f; // C->F

//        a.displayPreOrder(a);
//        a.traverseTree(a);
//        a.postOrderTraverseTree(a);
        a.displayBFS(a);
    }
}
