//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean isSafe(List<List<Integer>> adj,int i,int[] color,int val){
        for(int neig : adj.get(i)){
                if(val == color[neig])
                    return false;
        }
        return true;
    }
    public boolean tmp(List<List<Integer>> adj,int i,int[] color,int m){
        if(i == adj.size())return true;
        for(int col = 1 ; col <= m; col++){
            if(isSafe(adj,i,color,col)){
                color[i] = col;
                if(tmp(adj,i+1,color,m)) return true;
                color[i] = 0;
            }
        }
        return false;
        
    }
    public boolean graphColoring(boolean graph[][], int colors, int V) {
        // Your code here
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        int m = graph[0].length;
        for(int i = 0;i<V;i++)adj.add(new ArrayList<>());
        for(int i = 0;i<n;i++)
            for(int j = 0;j<m;j++)
                if(i != j && graph[i][j] == true)
                    adj.get(i).add(j);
                
        int[] color = new int[V];
        return tmp(adj,0,color,colors);
        
    }
}