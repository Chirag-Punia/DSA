class Solution {

    private boolean ans;
    private HashMap<Integer, Boolean> visited;

    private void dfs(Map<Integer, ArrayList<Integer>> graph, int currentNode, int destination) {
        visited.put(currentNode, true);
        if (currentNode == destination) {
            ans = true;
            return;
        }
        for (int neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
            if (!visited.getOrDefault(neighbor, false)) {
                dfs(graph, neighbor, destination);
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int start, int destination) {
        ans = false;
        visited = new HashMap<>();
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        // Building the graph
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            graph.putIfAbsent(node1, new ArrayList<>());
            graph.putIfAbsent(node2, new ArrayList<>());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        // Perform DFS
        dfs(graph, start, destination);
        return ans;
    }
}