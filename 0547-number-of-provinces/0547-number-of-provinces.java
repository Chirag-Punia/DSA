class Solution {
    public static HashMap<Integer,Boolean> mpp = new HashMap<>();
    public static void dfs(List<List<Integer>> adj, int i){
        mpp.put(i,true);
        for(int j = 0;j<adj.get(i).size();j++){
            int c = adj.get(i).get(j);
            if(!mpp.getOrDefault(c,false)) dfs(adj,c);
        }
    }
    public int findCircleNum(int[][] is) {
        List<List<Integer>> adj = new ArrayList<>();
        mpp = new HashMap<>();
        for(int i=0;i<is.length;i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j=0;j<is[i].length;j++){
                if(is[i][j] == 1)tmp.add(j);
            }
            adj.add(tmp);
        }
        int cnt = 0;
        for(int i = 0;i<adj.size();i++){
            if(!mpp.getOrDefault(i,false)){cnt++;dfs(adj,i);}
        }
        return cnt;
    }
}