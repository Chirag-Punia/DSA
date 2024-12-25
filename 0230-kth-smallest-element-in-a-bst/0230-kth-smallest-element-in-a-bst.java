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

    void temp(TreeNode root,int[] cnt,int k,int[] ans){
        if(ans[0] == 0){  
            if(root == null)return;
            temp(root.left,cnt,k,ans);
            cnt[0]++;
            if(cnt[0] == k)ans[0] = root.val;
            temp(root.right,cnt,k,ans);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] cnt = {0};
        int[] ans = {0};
        temp(root,cnt,k,ans);
        return ans[0];
    }
}