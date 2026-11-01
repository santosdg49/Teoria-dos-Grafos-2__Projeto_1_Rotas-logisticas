public class Caso_de_teste {
    public static void main() {
        Graph grafo = new Graph(4);
        grafo.addEdge(0, 1, 3); // A -> B
        grafo.addEdge(1, 2, 2); // B -> C
        grafo.addEdge(2, 0, -6);// C -> A
        grafo.addEdge(2, 3, 4); // C -> D

        String[] vertices = {"A", "B", "C", "D"};

        Bellman_Ford bellmanFord = new Bellman_Ford();
        Floyd_Warshall floyd_Warshall = new Floyd_Warshall();

        // Bellman Ford
        boolean cicloNegativoBellman = bellmanFord.bellman_ford(grafo, 0);

        // Floyd Warshall
        boolean cicloNegativoFloyd = floyd_Warshall.floyd_warshall(grafo);

        System.out.println("CASO DE TESTE - CICLO NEGATIVO");
        System.out.println("Ciclo negativo encontrado (Bellman Ford): " +  cicloNegativoBellman);
        System.out.println("Ciclo negativo encontrado (Floyd Warshall): " +  cicloNegativoFloyd);

    }
}
