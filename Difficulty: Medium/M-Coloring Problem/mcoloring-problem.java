//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());      // Number of vertices
            String[] arrInput = br.readLine().trim().split(" "); // Input for edges

            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < arrInput.length; i += 2) {
                int u = Integer.parseInt(arrInput[i]);
                int v = Integer.parseInt(arrInput[i + 1]);
                edges.add(new int[] {u, v});
            }

            int m = Integer.parseInt(br.readLine().trim()); // Number of colors

            Solution sol = new Solution();
            System.out.println(sol.graphColoring(n, edges, m) ? "true" : "false");
        }
    }
}

// } Driver Code Ends


class Solution {
    boolean isSafe(List<List<Integer>> adj, int[] colors, int curr, int color) {
        List<Integer> neighbors = adj.get(curr);
        for (int neighbor : neighbors) {
            if (colors[neighbor] == color) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(List<List<Integer>> adj, int node, int[] colors, int m) {
        if (node == adj.size()) {
            return true;
        }

        for (int color = 1; color <= m; color++) {
            if (isSafe(adj, colors, node, color)) {
                colors[node] = color;
                if (dfs(adj, node + 1, colors, m)) {
                    return true;
                }
                colors[node] = 0;
            }
        }
        return false;
    }

    boolean graphColoring(int v, List<int[]> edges, int m) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] colors = new int[v];
        return dfs(adj, 0, colors, m);
    }
}
