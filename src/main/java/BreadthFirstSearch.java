/*
 * Data Structures and Algorithms--Graphs

/**
 *
 * @author Aditya Ranjan Sahoo <adityaen.official101@gmail.com>
 */
import java.util.*;
public class BreadthFirstSearch {
    int graph[][];
    int vertices;
    BreadthFirstSearch(int vertices, int[][] graph){
        this.vertices=vertices;
        this.graph=graph;
    }
    void BFS(int s){
         boolean visited[] = new boolean[vertices];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Visit all adjacent vertices of the dequeued vertex s
            for (int i = 0; i < vertices; i++) {
                if (graph[s][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
    public static void main(String[] args){
        Graph g = new Graph(8);
        g.addEdge(1, 4, 1);
        g.addEdge(1, 5, 1);
        g.addEdge(1, 2 ,1);
        g.addEdge(2, 6, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(2, 7, 1);

        System.out.println("Graph representation:");
        g.display();
        BreadthFirstSearch bfs=new BreadthFirstSearch(g.getVertices(),g.graph);
        System.out.println("Req pathway is: ");
        bfs.BFS(1);
    }
}
        


