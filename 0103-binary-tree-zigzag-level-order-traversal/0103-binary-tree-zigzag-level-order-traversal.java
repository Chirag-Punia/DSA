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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return ans;
        }
        q.add(root);
        q.add(null);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            TreeNode c = q.poll();
            if(c == null){
                ans.add(temp); 
                temp = new ArrayList<>();
                if(q.isEmpty()){
                    break;
                }
                q.offer(null);
                leftToRight = !leftToRight;
            }
            else{
                if(leftToRight) temp.add(c.val);
                else temp.add(0,c.val);
                if(c.left != null) q.offer(c.left);
                if(c.right != null) q.offer(c.right);
            }
            
        }
        return ans;
    }
}