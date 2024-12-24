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
    void temp(TreeNode root,long mini,long maxi,boolean[] ans){
        if(ans[0]){
            if(root == null)return;
            if(root.val <= mini)ans[0]=false;
            if(root.val >= maxi)ans[0]=false;
            temp(root.left,(long)mini,(long)root.val,ans);
            temp(root.right,(long)root.val,(long)maxi,ans);
        }
    }
    public boolean isValidBST(TreeNode root) {
        boolean[] ans = {true};
        temp(root,Long.MIN_VALUE,Long.MAX_VALUE,ans);
        return ans[0];
    }
}