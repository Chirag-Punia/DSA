//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
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
	public int[] shortestPath(int n,int m, int[][] e) {

		ans = new int[n];
        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.val));
        List<List<Pair>> edges = new ArrayList<>();
        for(int i=0;i<n;i++){
            edges.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            edges.get(e[i][0]).add(new Pair(e[i][1],e[i][2]));
        }
        for(int i=0;i<n;i++)ans[i]=Integer.MAX_VALUE;
        q.offer(new Pair(0,0));
        ans[0]=0;
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
