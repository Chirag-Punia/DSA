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
    public static TreeNode f=null,m=null,l=null,ele=new TreeNode(Integer.MIN_VALUE);
    public static void i(TreeNode r){
        if(r==null)return;
        i(r.left);
        if(m == null && r.val < ele.val) {m=ele;f=r;}
        if(m != null && r.val < ele.val) l=r;
        ele = r;
        i(r.right);
    }

    public static void recoverTree(TreeNode root) {  
        f=null;m=null;l=null;ele=new TreeNode(Integer.MIN_VALUE);
        i(root);
        if(l == null){
            int v = f.val;
            f.val = m.val;
            m.val = v;
            return;
        }   
        int x = l.val;
        l.val = m.val;
        m.val = x;
        return;
    }
}