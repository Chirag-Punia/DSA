class Solution {

    public static boolean ans;
    public static HashMap<Integer,Boolean> visited;

    public static void dfs(Map<Integer,ArrayList<Integer>> mpp,int s,int d){
        visited.put(s,true);
        if(s == d) {ans = true; return;}
        for(int j = 0;j<mpp.get(s).size();j++){
            int c = mpp.get(s).get(j);
            if(!visited.getOrDefault(c,false)) dfs(mpp,c,d);
        }
    }
    public boolean validPath(int n, int[][] edg, int s, int d) {
        ans = false;
        visited = new HashMap<>();
        Map<Integer,ArrayList<Integer>> mpp = new HashMap<>();
        for(int[] e : edg){
            int n1 = e[0];
            int n2 = e[1];

            mpp.putIfAbsent(n1,new ArrayList<>());
            mpp.putIfAbsent(n2,new ArrayList<>());

            mpp.get(n1).add(n2);
            mpp.get(n2).add(n1);
        }
        dfs(mpp,s,d);
        return ans;
    }
}