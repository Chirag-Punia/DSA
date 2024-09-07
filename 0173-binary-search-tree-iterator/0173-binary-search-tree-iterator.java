/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        this.s = new Stack<>();
        pushAll(root);
    }
    void pushAll(TreeNode root){
        if(root == null)return;
        s.push(root);
        pushAll(root.left);
    }

    public int next() {
        TreeNode node = s.pop();
        pushAll(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */