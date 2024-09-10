/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode tmp(int[] preOrder,int[] inOrder,int preStart,int preEnd,int inStart,int inEnd,Map<Integer,Integer> mpp){
        if(preStart > preEnd || inStart > inEnd)return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        int val = mpp.get(preOrder[preStart]);
        int newInStart = val - inStart;
        root.left = tmp(preOrder,inOrder,preStart + 1,preStart + newInStart,inStart,val - 1,mpp);
        root.right = tmp(preOrder,inOrder,preStart + newInStart + 1,preEnd,val + 1,inEnd,mpp);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        return tmp(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1,mpp);
    }
}