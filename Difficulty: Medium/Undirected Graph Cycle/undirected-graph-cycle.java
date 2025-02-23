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

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Map<Integer,Boolean> mpp = new HashMap<>();
        for(int j = 0;j<V;j++){
            if(!mpp.getOrDefault(j,false)){
                Queue<Pair<Integer,Integer>> q = new LinkedList<>();
                q.offer(new Pair<>(j,-1));
                mpp.put(j,true);
                while(!q.isEmpty()){
                    Pair<Integer,Integer> curr = q.poll();
                    for(int i = 0;i<adj.get(curr.getKey()).size();i++){
                        int temp = adj.get(curr.getKey()).get(i);
                        if(!mpp.getOrDefault(temp,false)){
                            q.offer(new Pair<>(temp,curr.getKey()));
                            mpp.put(temp,true);
                        }
                        else if(temp != curr.getValue())return true;
                    }
                }
            }
        }
        
        return false;
    }
}