//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public static class Pair{
        int node;
        int val;
        Pair(int i,int j){
            this.node=i;
            this.val=j;
        }
    }
    public static int[] ans;
    static int[] dijkstra(int n, ArrayList<ArrayList<ArrayList<Integer>>> e, int S)
    {
        ans = new int[n];
        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.val));
        List<List<Pair>> edges = new ArrayList<>();
        for(int i=0;i<n;i++){
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (ArrayList<Integer> edge : e.get(i)) {
                edges.get(i).add(new Pair(edge.get(0), edge.get(1)));
            }
        }
        for(int i=0;i<n;i++)ans[i]=Integer.MAX_VALUE;
        q.offer(new Pair(S,0));
        ans[S]=0;
        while(!q.isEmpty()){
            Pair c = q.poll();
            if(c.val > ans[c.node] ) continue;
            for(Pair curr : edges.get(c.node)){
                    int newDist = c.val + curr.val;
                    if(newDist < ans[curr.node]){ans[curr.node]=newDist;q.offer(new Pair(curr.node,newDist));}
                } 
            }
            for (int i = 0; i < n; i++) {
                if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
                }
            }
        return ans;
       
    }
}

