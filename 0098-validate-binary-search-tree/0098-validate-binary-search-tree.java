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
    public static boolean ans;
    Solution(){
        this.ans = true;
    }
    public void v(TreeNode r,long i,long j){
        if(r == null) return;
        else if(i >= r.val ||  r.val >= j)ans =false;
        v(r.left,i,r.val);
        v(r.right,r.val,j);
    }
    public boolean isValidBST(TreeNode root) {
        ans = true;
        v(root,Long.MIN_VALUE,Long.MAX_VALUE);
        return ans;
    }
}