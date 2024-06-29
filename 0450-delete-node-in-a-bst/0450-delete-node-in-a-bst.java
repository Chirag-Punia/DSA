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
    public static TreeNode d(TreeNode r,int k){
        if(r == null) return null;
        if(r.val > k) r.left = d(r.left,k);
        else if(r.val < k) r.right = d(r.right,k);
        else{
            //0 Child
            if(r.left == null && r.right == null)return null;
            //1 Child
            else if(r.right == null)return r.left;
            else if(r.left == null)return r.right;
            //2 Child
            else{
                int i = t(r.right);
                r.val = i;
                r.right = d(r.right,i);
            }
        }
        return r;
    }
    public static int t(TreeNode r){
        if(r.left == null){
            return r.val;
        }
        return t(r.left);
    }
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return null;
        
        return d(root,key);
    }
}