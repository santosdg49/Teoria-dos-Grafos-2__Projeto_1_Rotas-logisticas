import java.util.List;

public class Cenario2 {
    public static void main(){
        Graph grafo = new Graph(8);
        grafo.addEdge(0, 1, 2); // CD -> A
        grafo.addEdge(0, 2, 5); // CD -> B
        grafo.addEdge(1, 3, 2); // A -> C
        grafo.addEdge(2, 1, -4);// B -> A
        grafo.addEdge(2, 4, 3); // B -> D
        grafo.addEdge(3, 4, 2); // C -> D
        grafo.addEdge(3, 5, 5); // C -> E
        grafo.addEdge(4, 5, 2); // D -> E
        grafo.addEdge(4, 7, 6); // D -> CLIENTE
        grafo.addEdge(5, 6, 2); // E -> F
        grafo.addEdge(6, 7, 1); // F -> CLIENTE

        Bellman_Ford bellmanFord = new Bellman_Ford();
        Dijkstra dijkstra = new Dijkstra();
        Floyd_Warshall floyd_Warshall = new Floyd_Warshall();

        String[] vertices = {"CD", "A", "B", "C", "D", "E", "F", "CLIENTE"};

        // Custo e caminho mínimo Bellman Ford
        bellmanFord.bellman_ford(grafo, 0);
        List<Integer> caminhoBellman = bellmanFord.reconstruirCaminho(0, 7);
        long custoMinimoBellman = bellmanFord.getDist()[7];

        // Custo e caminho mínimo Floyd Warshall
        floyd_Warshall.floyd_warshall(grafo);
        List<Integer> caminhoFloyd = floyd_Warshall.reconstruirCaminho(0, 7);
        long custoMinimoFloyd = floyd_Warshall.getDist()[0][7];

        System.out.println("CENARIO 2 - BELLMAN FORD");
        System.out.println("Origem: " + vertices[0]);
        System.out.println("Destino: " + vertices[7]);
        System.out.println("Custo mínimo: " + custoMinimoBellman);
        System.out.print("Caminho: ");
        for(int v : caminhoBellman){
            System.out.print(vertices[v] + " ");
        }
        System.out.println();
        System.out.println("Custo mínimo (Floyd Warshall): " + custoMinimoFloyd);
        System.out.print("Caminho (Floyd Warshall): ");
        for(int v: caminhoFloyd){
            System.out.print(vertices[v] + " ");
        }
        System.out.println();
        System.out.println("Dijkstra aplicável: " + !NegativeEdge(grafo));
        System.out.println();

    }

    public static boolean NegativeEdge(Graph grafo){
        List<List<Edge>> adj = grafo.getAdj();
        for(int i = 0; i < adj.size(); i++){
            for(Edge e : adj.get(i)){
                if(e.weight < 0){
                    return true;
                }
            }
        }
        return false;
    }
}
