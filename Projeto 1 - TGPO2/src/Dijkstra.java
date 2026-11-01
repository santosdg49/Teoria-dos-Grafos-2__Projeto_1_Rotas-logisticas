import java.util.*;

public class Dijkstra {
    private long[] dist;
    private int[] pred;

    static class EstadoFila{
        final int vertice;
        final long distania;

        EstadoFila(int vertice, long distania) {
            this.vertice = vertice;
            this.distania = distania;
        }
    }

    public void dijkstra(Graph g, int origem) {
        List<List<Edge>> adj = g.getAdj();
        int n = adj.size();
        boolean[] visitedo = new boolean[n];
        dist = new long[n];
        pred = new int[n];

        Arrays.fill(pred, -1);
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[origem] = 0;

        Comparator<EstadoFila> comparator = Comparator.comparingLong(e -> e.distania);
        PriorityQueue<EstadoFila> fila = new PriorityQueue<>(comparator);
        fila.add(new EstadoFila(origem, 0));

        while(!fila.isEmpty()){
            EstadoFila f = fila.poll();
            int u = f.vertice;

            if(visitedo[u]){
                continue;
            }

            visitedo[u] = true;

            for(Edge e:  adj.get(u)){
                int v =  e.to;
                long novaDistancia = dist[u] + e.weight;
                if(!visitedo[v]){
                    if(dist[v] > novaDistancia){
                        dist[v] = novaDistancia;
                        pred[v] = u;
                        fila.offer(new EstadoFila(v, novaDistancia));
                    }
                }
            }
        }
    }

    public List<Integer> reconstruirCaminho(int origem, int destino) {
        List<Integer> caminho = new ArrayList<>();
        if(origem == destino){
            caminho.add(origem);
            return caminho;
        }

        if(dist[destino] == Long.MAX_VALUE){
            return caminho;
        }

        for(int atual = destino; atual != -1; atual = pred[atual]){
            caminho.addFirst(atual);
        }

        return caminho;
    }

    public long[] getDist() {
        return dist;
    }

    public int[] getPred() {
        return pred;
    }
}
