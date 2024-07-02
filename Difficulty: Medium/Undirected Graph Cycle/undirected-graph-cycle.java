//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public static Map<Integer,Boolean> mpp;
    public static boolean ans;
    public static void dfs(ArrayList<ArrayList<Integer>> adj,int i,int p){
        if(mpp.getOrDefault(i,false)){
            ans = false;
            return;
        }
        mpp.put(i,true);
        if(ans){
        for(int j = 0;j<adj.get(i).size();j++){
            int curr =adj.get(i).get(j);
            if(curr != p ) {dfs(adj,curr,i);if (!ans) return;}
        }
        }
        
    }
    
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ans = true;
        mpp = new HashMap<>();
        for (int i = 0; i < V; i++) {
            if (!mpp.getOrDefault(i, false)) {
                dfs(adj, i, -1);
                if (!ans) return true;
            }
        }
        return !ans;
    }
}