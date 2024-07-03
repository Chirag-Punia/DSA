class Solution {
    public int[] color;

    public class Pair {
        int node;
        int color;

        Pair(int i, int j) {
            this.node = i;
            this.color = j;
        }
    }

    public boolean dfs(int[][] graph, Pair p) {
        color[p.node] = p.color;
        for (int i = 0; i < graph[p.node].length; i++) {
            Pair tmp = new Pair(graph[p.node][i], 1 - p.color);
            if (color[graph[p.node][i]] == -1 && dfs(graph, tmp) == false)return false;
            else if (color[graph[p.node][i]] == p.color)return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        color = new int[graph.length];
        for (int i = 0; i < color.length; i++)color[i] = -1;
        for(int i = 0;i<graph.length;i++)if(color[i] == -1 && dfs(graph,new Pair(i,0)) == false)return false;
        return true;
    }
}