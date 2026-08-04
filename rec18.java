import java.util.Arrays;

public class rec18 {
    boolean graphColoring(int v, int[][] edges, int m) {
     int color[] = new int[v];
     Arrays.fill(color, 0);
     return solve(0, color, m, v, edges);
        
    }

    private boolean solve(int node, int[] color, int m, int v, int[][] edges) {
        if (node == v) {
            return true;
        }
        for (int col = 1; col <= m; col++) {
            if (isSafe(node, color, col, edges)) {
                color[node] = col;
                if (solve(node + 1, color, m, v, edges)) {
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }
private boolean isSafe(int node, int[] color, int col, int[][] edges) {
    for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];

        if (u == node && color[v] == col) {
            return false;
        }

        if (v == node && color[u] == col) {
            return false;
        }
    }

    return true;
}

    public static void main(String[] args) {
        
    }
}
