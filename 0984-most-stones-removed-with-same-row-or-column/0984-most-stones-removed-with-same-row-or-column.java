class Solution {
    private void dfs(int node, List<List<Integer>> adj, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adj, visited);
            }
        }
    }
    
    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        int numComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, adj, visited);
                numComponents++;
            }
        }

        return n - numComponents;
    }
}