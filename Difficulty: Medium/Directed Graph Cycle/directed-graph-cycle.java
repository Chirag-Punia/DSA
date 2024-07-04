//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    public Queue<Integer> q;
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {


        //Khans Algo
        q = new LinkedList<>();
        int k = 0;
        List<Integer> ans = new ArrayList<>();
        int[] inOrder = new int[V];
        for(int i = 0;i<V;i++){
            for(int j = 0;j<adj.get(i).size();j++)inOrder[adj.get(i).get(j)]++;
        }
        for(int i = 0;i<V;i++)if(inOrder[i] == 0)q.offer(i);
        while(!q.isEmpty()){
            int c = q.poll();
            ans.add(c);
            for(int it : adj.get(c)){
                inOrder[it]--;
                if( inOrder[it] == 0) q.offer(it);
            }
        }
        return ans.size() < V;
    }
}