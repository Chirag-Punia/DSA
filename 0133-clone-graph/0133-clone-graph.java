class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> mpp = new HashMap<>();
        Map<Node, Boolean> vis = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        q.offer(node);
        vis.put(node, true);
        mpp.put(node, new Node(node.val));
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            for (Node tmp : curr.neighbors) {
                if (!vis.getOrDefault(tmp, false)) {
                    q.offer(tmp);
                    vis.put(tmp, true);
                    mpp.put(tmp, new Node(tmp.val));
                }
                mpp.get(curr).neighbors.add(mpp.get(tmp));
            }
        }
        
        return mpp.get(node);
    }
}
