package exercises.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A class demonstrating Breadth-First Search (BFS) traversal on a graph represented as an adjacency matrix.
 *
 * Example:
 * Adjacency Matrix:
 * [
 *   [0, 1, 0, 0, 0], // A -> B
 *   [0, 0, 1, 0, 1], // B -> C, B -> E
 *   [0, 0, 0, 1, 1], // C -> D, C -> E
 *   [0, 0, 0, 0, 0], // D (no edges)
 *   [1, 0, 1, 0, 0]  // E -> A, E -> C
 * ]
 * Nodes: ["A", "B", "C", "D", "E"]
 *
 * BFS Traversal starting from node A (index 0): A -> B -> C -> E -> D
 *
 * Big O Notation:
 * - Time Complexity: O(V^2), where V is the number of nodes (due to adjacency matrix traversal).
 * - Space Complexity: O(V), due to the queue and visited array.
 */
public class BfsTree {

    public static void main(String[] args) {
        // Example graph as an adjacency matrix
        int[][] matrix = {
                {0, 1, 0, 0, 0}, // A -> B
                {0, 0, 1, 0, 1}, // B -> C, B -> E
                {0, 0, 0, 1, 1}, // C -> D, C -> E
                {0, 0, 0, 0, 0}, // D (no edges)
                {1, 0, 1, 0, 0}  // E -> A, E -> C
        };

        String[] nodes = {"A", "B", "C", "D", "E"}; // Node labels

        // Perform BFS starting from node 0 (A)
        bfs(matrix, 0, nodes);
    }

    /**
     * Performs Breadth-First Search (BFS) on a graph represented as an adjacency matrix.
     *
     * Algorithm:
     * 1. Initialize a queue to process nodes in a breadth-first manner.
     * 2. Use a `visited` array to keep track of visited nodes and prevent reprocessing.
     * 3. Start from the source node:
     *    - Mark the source node as visited and enqueue it.
     * 4. While the queue is not empty:
     *    - Dequeue a node, print it, and explore its neighbors.
     *    - For each neighbor, if it's not visited and there's an edge, mark it as visited and enqueue it.
     * 5. Continue until all reachable nodes are visited.
     *
     * Big O Notation:
     * - Time Complexity: O(V^2) — Traverses all nodes and their neighbors in the adjacency matrix.
     * - Space Complexity: O(V) — The queue and visited array require space proportional to the number of nodes.
     *
     * @param matrix The adjacency matrix representing the graph.
     * @param source The starting node index for the BFS traversal.
     * @param nodes  The array of node labels for printing.
     */
    private static void bfs(int[][] matrix, int source, String[] nodes) {
        Queue<Integer> queue = new LinkedList<>(); // Queue to manage BFS traversal
        boolean[] visited = new boolean[matrix.length]; // Track visited nodes

        // Start BFS from the source node
        queue.offer(source);
        visited[source] = true;

        System.out.println("BFS Traversal:");

        while (!queue.isEmpty()) {
            int current = queue.poll(); // Dequeue the next node
            System.out.print(nodes[current] + " "); // Print the current node

            // Check all neighbors of the current node
            for (int i = 0; i < matrix[current].length; i++) {
                if (matrix[current][i] == 1 && !visited[i]) { // If there's an edge and the node isn't visited
                    queue.offer(i); // Enqueue the neighbor
                    visited[i] = true; // Mark it as visited
                }
            }
        }
    }

    /**
     * Traverses and prints the given matrix in row-column order.
     *
     * Big O Notation:
     * - Time Complexity: O(m × n), where "m" is the number of rows and "n" is the number of columns.
     * - Space Complexity: O(1), as no additional data structures are used.
     *
     * @param matrix The adjacency matrix to traverse.
     * @param source Ignored in this method but kept for compatibility.
     */
    private static void matrixTravesal(int[][] matrix, int source) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(" -> " + matrix[row][column]);
            }
            System.out.println();
        }
    }
}