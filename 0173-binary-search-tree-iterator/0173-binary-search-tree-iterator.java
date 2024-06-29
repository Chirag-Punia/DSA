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
    public List<TreeNode> arr;
    public TreeNode root;
    public int i;
    public BSTIterator(TreeNode root) {
        this.arr = new ArrayList<>();
        this.root = root;
        this.i = 0;
        i(this.root);
    }
    public void i(TreeNode r){
        if(r == null) return;
        i(r.left);
        arr.add(r);
        i(r.right);
    }
    
    public int next() {
        int data = 0;
        if(i < arr.size()){
            data = arr.get(i).val;
            i++;
        }
        return data;
    }
    
    public boolean hasNext() {
        if(i <= arr.size()-1) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */