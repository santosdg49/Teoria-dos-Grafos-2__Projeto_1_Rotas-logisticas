import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bellman_Ford {
    private long[] dist;
    private int[] pred;

    public boolean bellman_ford(Graph g, int origem){
        List<Edge> edges =  g.getEdges();
        int n = g.Vertices();
        pred = new int[n];
        dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        Arrays.fill(pred,-1);
        dist[origem] = 0;

        for(int i = 1; i < n; i++){
            boolean mudou = false;
            for(Edge e: edges){
                if(dist[e.from] != Long.MAX_VALUE && dist[e.to] > dist[e.from] + e.weight){
                    dist[e.to] = dist[e.from] + e.weight;
                    pred[e.to] = e.from;
                    mudou = true;
                }
            }
            if(!mudou){break;}
        }
        for(Edge e: edges){
            if(dist[e.from] != Long.MAX_VALUE && dist[e.to] > dist[e.from] + e.weight){
                return true;
            }
        }
        return false;
    }

    public List<Integer> reconstruirCaminho(int origem, int destino){
        List<Integer> caminho = new ArrayList<>();
        if(origem == destino){
            caminho.add(origem);
            return caminho;
        }

        if(destino == -1){
            return caminho;
        }

        for(int atual = destino; atual != -1; atual = pred[atual]){
            caminho.add(0, atual);
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
