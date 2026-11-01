import java.util.ArrayList;
import java.util.List;

public class Floyd_Warshall {
    private long[][] dist;
    private int[][] next;

    public boolean floyd_warshall(Graph g){
        int n = g.Vertices();
        long[][] cost = g.getCost();
        dist = new long[n][n];
        next = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = cost[i][j];

                if(i == j){
                    next[i][j] = i;
                }
                else if(cost[i][j] != Long.MAX_VALUE){
                    next[i][j] = j;
                }
                else{
                    next[i][j] = -1;
                }
            }
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][k] == Long.MAX_VALUE || dist[k][j] == Long.MAX_VALUE){
                        continue;
                    }

                    long candidato = dist[i][k] + dist[k][j];
                    if(candidato < dist[i][j]){
                        dist[i][j] = candidato;
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(dist[i][i] < 0){
                return true;
            }
        }

        return false;
    }

    public List<Integer> reconstruirCaminho(int origem, int destino){
        List<Integer> caminho = new ArrayList<>();

        if(dist[origem][destino] == Long.MAX_VALUE){
            return caminho;
        }
        caminho.add(origem);

        while(origem != destino){
            origem = next[origem][destino];
            caminho.add(origem);
        }
        return caminho;
    }

    public long[][] getDist() {
        return dist;
    }

    public int[][] getNext() {
        return next;
    }
}
