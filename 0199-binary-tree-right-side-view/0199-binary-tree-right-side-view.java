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
    void temp(TreeNode root,int level,List<Integer> ans){
        if(root == null)return;
        if(level == ans.size())ans.add(root.val);
        temp(root.right,level+1,ans);
        temp(root.left,level+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        temp(root,0,ans);
        return ans;
    }
}