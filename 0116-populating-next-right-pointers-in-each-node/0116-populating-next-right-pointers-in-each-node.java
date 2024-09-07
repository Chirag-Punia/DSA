/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)return root;
        List<Node> arr = new ArrayList<>();
        List<List<Node>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            arr = new ArrayList<>();
            for(int i = 0;i<size;i++){
                Node curr = q.poll();
                arr.add(curr);
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
            ans.add(arr);
        }
        for(List<Node> a : ans){
            for(int i = 0;i<a.size()-1;i++){
                a.get(i).next = a.get(i+1);
            }
            a.get(a.size() - 1).next = null;
        }
        return root;
    }
}