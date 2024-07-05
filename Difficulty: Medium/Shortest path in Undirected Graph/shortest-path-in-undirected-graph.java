//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public class Pair{
        int node;
        int val;
        Pair(int i,int j){
            this.node=i;
            this.val=j;
        }
    }
    public int[] ans;
    public Queue<Pair> q;
    public int[] shortestPath(int[][] e,int n,int m ,int src) {
        // Code here
        ans = new int[n];
        q = new LinkedList();
        List<List<Integer>> edges = new ArrayList<>();
        for(int i=0;i<n;i++){
            edges.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            edges.get(e[i][0]).add(e[i][1]);
            edges.get(e[i][1]).add(e[i][0]);
        }
        for(int i=0;i<n;i++)ans[i]=-1;
        q.offer(new Pair(src,0));
        while(!q.isEmpty()){
            Pair c = q.poll();
            if(ans[c.node] == -1){
                ans[c.node]=c.val;
                for(int j=0;j<edges.get(c.node).size();j++){
                    int curr = edges.get(c.node).get(j);
                    if(ans[curr] == -1)q.offer(new Pair(curr,c.val + 1));
                } 
            }
        }
        return ans;
    }
}