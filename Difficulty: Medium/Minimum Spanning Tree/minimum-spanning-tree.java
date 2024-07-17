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
    public static class Pair implements Comparable<Pair> {
        int weight;
        int node;
        int parent;
        
        Pair(int weight, int node, int parent) {
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }
        
        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V];
        int sum = 0;

      
        pq.offer(new Pair(0, 0, -1));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            

            if (visited[curr.node]) {
                continue;
            }

     
            visited[curr.node] = true;
            sum += curr.weight;

            for (int[] neighbor : adj.get(curr.node)) {
                int nextNode = neighbor[0];
                int edgeWeight = neighbor[1];

                
                if (!visited[nextNode]) {
                    pq.offer(new Pair(edgeWeight, nextNode, curr.node));
                }
            }
        }

        return sum;
        
    }
}