//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    public Map<Integer,Boolean> mpp;
    public Stack<Integer> s;
    public Queue<Integer> q;
    public void dfs(ArrayList<ArrayList<Integer>> adj,int i){
        mpp.put(i,true);
        
        for(int j=0;j<adj.get(i).size();j++){
            int c = adj.get(i).get(j);
            if(!mpp.getOrDefault(c,false)) dfs(adj,c);
        }
        s.push(i);
    }
    
    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        mpp = new HashMap<>();
        s = new Stack<>();
        q = new LinkedList<>();
        //BFS
        int k = 0;
        int[] ans = new int[V];
        int[] inOrder = new int[V];
        for(int i = 0;i<V;i++){
            for(int j = 0;j<adj.get(i).size();j++)inOrder[adj.get(i).get(j)]++;
        }
        for(int i = 0;i<V;i++)if(inOrder[i] == 0)q.offer(i);
        while(!q.isEmpty()){
            int c = q.poll();
            ans[k++] = c;
            for(int it : adj.get(c)){
                inOrder[it]--;
                if( inOrder[it] == 0) q.offer(it);
            }
        }
        return ans;
        
        
        
        //DFS
        // for(int i=0;i<V;i++){
        //     if(!mpp.getOrDefault(i,false)) dfs(adj,i);
        // }

        // while(!s.isEmpty()){
        //     ans[i] = s.pop();
        //     i++;
        // }
        // return ans;
        
        
        
    }
}
