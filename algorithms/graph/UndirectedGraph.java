package algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraph {

    ArrayList<Node> nodes;
    int[][] matrix;

    UndirectedGraph(int size){
        this.nodes = new ArrayList<>();
        this.matrix = new int[size][size];
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void addEdge(int source, int destination){
        matrix[source][destination] = 1;
    }

    public boolean checkEdge(int source, int destination){
//        return matrix[source][destination] == 1;
        if(matrix[source][destination] == 1){
            return true;
        } else {
            return false;
        }
    }

    public void print(){

        System.out.print("  ");
        for(Node node : nodes){
            System.out.print(node.data + " ");
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).data + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Depth First Search = Pick a route, keep going.
    //                      If you reach a dead end, or an already visited node,
    //                      backtrack to a previous node with unvisited adjacent neighbors
    //
    public void depthFirstSearch(int source){
        boolean[] visited = new boolean[matrix.length];
        dfsHelper(source, visited);
    }

    private void dfsHelper(int source, boolean[] visited) {
        if(visited[source]){
            return;
        }else{
            visited[source] = true;
            System.out.println(nodes.get(source).data + " = visited");
        }
        for (int i = 0; i < matrix[source].length; i++) {
            if(matrix[source][i] == 1) { // tem node para navegar
                dfsHelper(i, visited);
            }
        }
        return;
    }

    // BFS (Breadth First Search) = Traverse a graph level by level
    //                              Utilizes a Queue
    //                              Better if destination is on average close to start
    //                              Siblings are visited before children
    //
    public void breadthFirstSearch(int source){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        queue.offer(source);
        visited[source] = true;

        while (queue.size() != 0){
            source = queue.poll();
            System.out.println(nodes.get(source).data + " = visited");

            for(int i = 0; i < matrix[source].length; i++){
                if(matrix[source][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

}
