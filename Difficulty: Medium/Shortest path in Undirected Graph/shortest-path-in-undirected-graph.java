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
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        List<Integer>[] graph=new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<Integer>();
        }
        
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(src);
        dist[src]=0;
        
        Set<Integer> visited=new HashSet<Integer>();
        visited.add(src);
        while(!queue.isEmpty()){
            int curr=queue.poll();
           
            
            for(int adj:graph[curr]){
                if(!visited.contains(adj)){
                    queue.add(adj);
                    dist[adj]=dist[curr]+1;
                     visited.add(adj);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE)
            dist[i]=-1;
        }
        
        return dist;
        
    }
}