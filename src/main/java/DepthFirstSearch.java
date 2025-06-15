

/**
 *
 * @author Aditya Ranjan Sahoo
 */

class DepthFirstSearch {
    private final boolean[] visited;
    private final int[][] graph;
    private final int vertices;

    public DepthFirstSearch(int vertices, int[][] graph) {
        this.vertices = vertices;
        this.graph = graph;
        this.visited = new boolean[vertices];
    }

    public void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + "-->");

        for (int i = 0; i < vertices; i++) {
            if (graph[vertex][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(1, 4,1);
        g.addEdge(1, 5,1);
        g.addEdge(1, 2,1);
        g.addEdge(2, 6,1);
        g.addEdge(2, 3,1);
        g.addEdge(2, 7,1);

        System.out.println("Graph representation:");
        g.display();

        DepthFirstSearch dfs = new DepthFirstSearch(g.getVertices(), g.getGraph());
        System.out.println("Depth First Traversal starting from vertex 1:");
        dfs.DFS(1);
    }
}
