

/**
 *
 * @author Aditya Ranjan Sahoo
 */
class Graph {
    int graph[][];
    int vertices;

    Graph(int vertices) {
        this.graph = new int[vertices][vertices];
        this.vertices = vertices;
    }

    void addEdge(int src, int dest,int weight) {
        add_forward_edge(src,dest,weight);
        add_back_edge(dest,src,weight);
    }

    void display() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 1)
                    System.out.println(i + "-->" + j);
            }
        }
    }

    int[][] getGraph() {
        return graph;
    }

    int getVertices() {
        return vertices;
    }

    private void add_forward_edge(int src, int dest,int weight) {
        graph[src][dest] = weight; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void add_back_edge(int dest, int src,int weight) {
        graph[dest][src] = weight; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}