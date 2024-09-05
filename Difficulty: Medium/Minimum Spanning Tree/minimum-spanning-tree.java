//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Pair implements Comparable<Pair>{
        int node;
        int parent;
        int w;
        Pair(int parent,int node,int w){
            this.parent = parent;
            this.node = node;
            this.w = w;
        }
        @Override
        public int compareTo(Pair o){
            return this.w - o.w;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] vis = new int[V];
        Arrays.fill(vis,-1);
        pq.offer(new Pair(-1,0,0));
        int sum = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(vis[curr.node] == 1)continue;
            vis[curr.node] = 1;
            sum += curr.w;
            for(int i = 0;i<adj.get(curr.node).size();i++){
                int[] tmp = adj.get(curr.node).get(i);
                if(vis[tmp[0]] == -1)
                    pq.offer(new Pair(curr.node,tmp[0],tmp[1]));
            }
        }
        return sum;
        
    }
}