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
class Solution {
    private int ans;
    private int i;
    public Solution(){
        this.ans = -1;
        this.i = 0;
    }
    public void i(TreeNode r,int k){
        if(r == null){
            return;
        }
        i(r.left,k);
        i++;
        if(i == k) ans = r.val;
        i(r.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        ans = -1;
        i(root,k);
        return ans;
    }
}