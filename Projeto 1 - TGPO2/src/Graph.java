import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

class Graph {
    private final List<Edge> edges;
    private final List<List<Edge>> adj;
    private final long[][] cost;

    public Graph(int n) {
        this.edges = new ArrayList<>();
        this.adj = new ArrayList<>();
        this.cost = new long[n][n];
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Long.MAX_VALUE;
            }
        }
    }

    void addEdge(int from, int to, int weight) {
        edges.add(new Edge(from, to, weight));
        adj.get(from).add(new Edge(from, to, weight));
        cost[from][to] = weight;
    }

    List<Edge> getEdges() {
        return edges;
    }

    public List<List<Edge>> getAdj() {
        return adj;
    }

    public int Vertices() {
        return adj.size();
    }

    public long[][] getCost() {
        return cost;
    }
}