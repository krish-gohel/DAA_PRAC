public class Pract11 {
    // Number of vertices in the graph
    static final int V = 4;

    // Function to implement Floyd-Warshall algorithm
    public static void floydWarshall(int graph[][]) {
        // Create a 2D array to store the shortest path distances
        int[][] dist = new int[V][V];

        // Initialize the distance array with the given graph
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Update the distance array using the Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the shortest path matrix
        printSolution(dist);
    }

    // Function to print the solution
    public static void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Initialize the graph as an adjacency matrix
        // Use Integer.MAX_VALUE to represent no direct path between vertices
        int[][] graph = {
            {0, 3, Integer.MAX_VALUE, 7},
            {8, 0, 2, Integer.MAX_VALUE},
            {5, Integer.MAX_VALUE, 0, 1},
            {2, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        floydWarshall(graph);
    }
}
