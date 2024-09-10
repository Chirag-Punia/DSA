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
    public TreeNode tmp(int[] inorder,int[] postorder,int instart,int inend,int poststart,int postend,Map<Integer,Integer> mpp){
        if(poststart > postend || instart > inend){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postend]);
        int val = mpp.get(root.val);
        int x = val - instart;
        root.left = tmp(inorder,postorder,instart,instart+val,poststart,poststart+x-1,mpp);
        root.right = tmp(inorder,postorder,instart+x+1,inend,poststart+x,postend-1,mpp);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        return tmp(inorder,postorder,0,inorder.length-1,0,postorder.length - 1,mpp);
    }
}