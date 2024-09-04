class Solution {
    class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        for(int start = 0;start < n;start++){
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(start,0));
            int[] color = new int[n];
            Arrays.fill(color,-1);
            while(!q.isEmpty()){
                Pair curr = q.poll();
                if(color[curr.node] == -1){
                    if(color[curr.parent] == 0)
                        color[curr.node] = 1;
                    else
                        color[curr.node] = 0;
                    for(int i = 0;i<graph[curr.node].length;i++)
                        q.offer(new Pair(graph[curr.node][i],curr.node));
                }
                else if(color[curr.node] == color[curr.parent])return false;
                    
            }
        }
        return true;
    }
}