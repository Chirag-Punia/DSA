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
    public int helper(TreeNode root,boolean[] ans){
        if(root == null)return 0;
        int l = 0,r = 0;
        if(ans[0]){
        l = helper(root.left,ans);
        r = helper(root.right,ans);
        }
        if(Math.abs(l-r) > 1)ans[0] = false;
        return 1 + Math.max(l,r);

    }
    public boolean isBalanced(TreeNode root) {
        boolean[] ans = {true};
        helper(root,ans);
        return ans[0];

    }
}