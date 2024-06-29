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
    List<Integer> arr;
    Solution(){
        this.arr = new ArrayList<>();
    }
    public void i(TreeNode r){
        if(r==null)return;
        i(r.left);
        arr.add(r.val);
        i(r.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        i(root);
        int i = 0;
        int j = arr.size()-1;
        while(i < j){
            int left = arr.get(i);
            int right = arr.get(j);
            if(left + right == k) return true;
            if(left + right > k) j--;
            else i++;
        }
        return false;
    }

}