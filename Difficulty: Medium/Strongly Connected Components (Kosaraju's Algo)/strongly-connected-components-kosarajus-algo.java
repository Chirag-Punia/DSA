//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    Stack<Integer> s;

    void dfs1(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis) {
        vis[i] = true;
        for (int j = 0; j < adj.get(i).size(); j++) {
            int next = adj.get(i).get(j);
            if (!vis[next]) {
                dfs1(adj, next, vis);
            }
        }
        s.push(i);
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis) {
        vis[i] = true;
        for (int j = 0; j < adj.get(i).size(); j++) {
            int next = adj.get(i).get(j);
            if (!vis[next]) {
                dfs(adj, next, vis);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        s = new Stack<>();
        boolean[] vis = new boolean[V];
        
        for(int i = 0;i<V;i++){
            if(!vis[i])dfs1(adj,i,vis);
        }
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adjT.add(new ArrayList<>());
        }
        //reverseGRAPH
        for(int i = 0;i<V;i++){
            for(int j = 0;j<adj.get(i).size();j++){
                adjT.get(adj.get(i).get(j)).add(i);
            }
        }
        vis = new boolean[V];
        int cnt = 0;
        while(!s.isEmpty()){
            int c = s.pop();
            if(!vis[c]){
                dfs(adjT,c,vis);
                cnt++;
            }
        }
        return cnt;
    }
}
