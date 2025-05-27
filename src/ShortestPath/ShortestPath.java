/*
 * Copyright 2024 Aditya Ranjan Sahoo <adityaen.official101@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 * @author Aditya Ranjan Sahoo <adityaen.official101@gmail.com>
 */
import java.util.*;

public class ShortestPath {

    public ShortestPath(Graph gph, int source) {
        int curr;
        int count = gph.vertices;
        int[][] graph = gph.getGraph();
        int[] distance = new int[count];
        int[] path = new int[count];

        for (int i = 0; i < count; i++) {
            distance[i] = -1; // Initialize distances to -1 (unvisited)
            path[i] = -1; // Initialize path to -1 (no previous vertex)
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        distance[source] = 0;

        while (!que.isEmpty()) {
            curr = que.remove();
            for (int i = 0; i < count; i++) {
                if (graph[curr][i] != 0 && distance[i] == -1) { // Check for an edge and if the vertex is unvisited
                    distance[i] = distance[curr] + 1;
                    path[i] = curr;
                    que.add(i);
                }
            }
        }

        printPaths(source, distance, path);
    }

    private void printPaths(int source, int[] distance, int[] path) {
        for (int i = 0; i < distance.length; i++) {
            if (i != source) {
                System.out.print("Path from " + source + " to " + i + " is: ");
                printPath(i, path);
                System.out.println(" with distance " + distance[i]);
            }
        }
    }

    private void printPath(int vertex, int[] path) {
        if (path[vertex] == -1) {
            System.out.print(vertex);
            return;
        }
        printPath(path[vertex], path);
        System.out.print(" -> " + vertex);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6); // Adjusting the number of vertices to 6 for indexing
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(4, 5, 1);

        ShortestPath sp = new ShortestPath(graph, 1); // Find shortest path from vertex 1
    }
}

