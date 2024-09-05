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
    //Function to find number of strongly connected components in the graph.
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,Stack<Integer> s,Map<Integer,Boolean> mpp){
        mpp.put(node,true);
        for(int i : adj.get(node)){
            if(!mpp.getOrDefault(i,false)){
                dfs(i,adj,s,mpp);
            }
        }
        s.push(node);
    }
    public void dfs1(int node,ArrayList<ArrayList<Integer>> adj,Map<Integer,Boolean> mpp){
        mpp.put(node,true);
        for(int i : adj.get(node)){
            if(!mpp.getOrDefault(i,false)){
                dfs1(i,adj,mpp);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Map<Integer,Boolean> mpp = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        int cnt  = 0;
        for(int i=0;i<V;i++){
            if(!mpp.getOrDefault(i,false))
                dfs(i,adj,s,mpp);
        }
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int i = 0;i<V;i++){
            transpose.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                transpose.get(it).add(i);
            }
        }
        mpp = new HashMap<>();
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!mpp.getOrDefault(curr,false)){
                dfs1(curr,transpose,mpp);
                cnt++;
            }
        }
        return cnt;
    }
}
