//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static HashMap<Integer,Boolean> mpp = new HashMap<>();
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int i){
        mpp.put(i,true);
        for(int j = 0;j<adj.get(i).size();j++){
            int c = adj.get(i).get(j);
            if(!mpp.getOrDefault(c,false)) dfs(adj,c);
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> a, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        mpp = new HashMap<>();
        for(int i=0;i<a.size();i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int j=0;j<a.get(i).size();j++){
                if(a.get(i).get(j) == 1)tmp.add(j);
            }
            adj.add(tmp);
        }
        int cnt = 0;
        for(int i = 0;i<adj.size();i++){
            if(!mpp.getOrDefault(i,false)){cnt++;dfs(adj,i);}
        }
        return cnt;
    }
};