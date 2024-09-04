class Solution {

    public boolean dfs(int node, int parent, List<List<Integer>> adj, Map<Integer, Boolean> mpp, boolean[] recStack) {
        mpp.put(node, true);
        recStack[node] = true;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int curr = adj.get(node).get(i);

            if (!mpp.getOrDefault(curr, false)) {
                if (dfs(curr, node, adj, mpp, recStack)) {
                    return true;
                }
            } else if (recStack[curr]) {
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }

    public boolean canFinish(int n, int[][] p) {
        List<List<Integer>> adj = new ArrayList<>();
        Map<Integer, Boolean> mpp = new HashMap<>();
        boolean[] recStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < p.length; i++) {
            adj.get(p[i][0]).add(p[i][1]);
        }

        for (int i = 0; i < n; i++) {
            if (!mpp.getOrDefault(i, false)) {
                if (dfs(i, -1, adj, mpp, recStack)) {
                    return false;
                }
            }
        }

        return true;
    }
}