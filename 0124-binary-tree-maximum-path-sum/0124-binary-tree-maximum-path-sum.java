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
    public static int ans;
    Solution(){
        this.ans = Integer.MIN_VALUE;
    }
    public static int sum(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = sum(root.left);
        int r = sum(root.right);
        if(l<0){
            l = 0;
        }
        if(r < 0){
            r = 0;
        }
        ans = Math.max(ans,l+r+root.val);
        return (root.val + Math.max(l,r));
    }
    public int maxPathSum(TreeNode root) {
        sum(root);
        return ans;
    }  
}