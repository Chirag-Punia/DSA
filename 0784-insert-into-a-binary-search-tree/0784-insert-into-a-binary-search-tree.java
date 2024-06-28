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
    public void s(TreeNode r,int k){
        if(r.left != null && r.val > k) s(r.left,k);
        else if(r.right != null && r.val<k) s(r.right,k);
        else{
            TreeNode newNode = new TreeNode(k);
            if(r.val > k) r.left = newNode;
            else r.right = newNode;
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }
        s(root,val);
        return root;
    }
}