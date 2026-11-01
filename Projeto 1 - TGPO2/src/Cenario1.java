import java.util.List;

public class Cenario1 {
    public static void main() {
        Graph grafo = new Graph(8);

        grafo.addEdge(0, 1, 4); // CD -> A
        grafo.addEdge(0, 2, 7); // CD -> B
        grafo.addEdge(1, 2, 2); // A -> B
        grafo.addEdge(1, 3, 5); // A -> C
        grafo.addEdge(2, 3, 1); // B -> C
        grafo.addEdge(2, 4, 6); // B -> D
        grafo.addEdge(3, 4, 2); // C -> D
        grafo.addEdge(3, 5, 7); // C -> E
        grafo.addEdge(4, 5, 3); // D -> E
        grafo.addEdge(4, 6, 5); // D -> F
        grafo.addEdge(5, 6, 2); // E -> F
        grafo.addEdge(5, 7, 6); // E -> Cliente
        grafo.addEdge(6, 7, 3); // F -> Cliente

        String[] Vertives = {"CD", "A", "B", "C", "D", "E", "F", "Cliente"};
        Dijkstra d = new Dijkstra();
        d.dijkstra(grafo, 0);

        // Menor custo de CD a Clinte com Dijkstra
        long[] dist = d.getDist();
        long menorCustoDijkstra = dist[7];

        // Caminho encontrado com Dijkstra
        List<Integer> caminhoDijkstra = d.reconstruirCaminho(0, 7);

        //Menor custo de CD a Cliente e caminho com Bellman Ford
        Bellman_Ford b =  new Bellman_Ford();
        b.bellman_ford(grafo,  0);
        List<Integer> caminhoBellman = b.reconstruirCaminho(0, 7);
        long[] distBellman = b.getDist();
        long menorCustoBellman = dist[7];

        // Custo de CD a Cliente com Floyd Warshall
        Floyd_Warshall f = new Floyd_Warshall();
        f.floyd_warshall(grafo);
        long[][] distFloyd = f.getDist();
        long menorCustoFloyd = distFloyd[0][7];


        System.out.println("CENARIO 1 - DIJKSTRA");
        System.out.println("Origem: " + Vertives[0]);
        System.out.println("Destino: " + Vertives[7]);
        System.out.println("Custo mínimo: " + menorCustoDijkstra);
        System.out.print("Caminho: ");
        for(int v: caminhoDijkstra){
            System.out.print(Vertives[v] + " ");
        }
        System.out.println();
        System.out.println("Custo mínimo (Bellman Ford): " + menorCustoBellman);
        System.out.println("Custo mínimo (Floyd Warshall): " + menorCustoFloyd);
        System.out.println("Matriz de custos:");
        for(int i = 0; i < distFloyd.length; i++){
            for(int j = 0; j < distFloyd[i].length; j++){
                if(distFloyd[i][j] != Long.MAX_VALUE) {
                    System.out.print(Vertives[i] + "->" + Vertives[j] + ":" + distFloyd[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}