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
    int ans;
    int sum(TreeNode root){
        if(root == null)return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        left = left<0?0:left;
        right = right<0?0:right;
        ans = Math.max(ans,root.val+left+right);
        return root.val + Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        sum(root);
        return ans;
    }
}