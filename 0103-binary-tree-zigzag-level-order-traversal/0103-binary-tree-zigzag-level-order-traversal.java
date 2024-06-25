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
        int count = 0;
        boolean leftToRight = true;
        while(!q.isEmpty()){
            TreeNode c = q.remove();
            if(c == null){
                count++;
                if(count % 2 == 0){
                    Collections.reverse(temp);
                    ans.add(temp);
                }
                else ans.add(temp); 
                temp = new ArrayList<>();
                if(q.isEmpty()){
                    break;
                }
                q.offer(null);
            }
            else{
                temp.add(c.val);
                if(c.left != null) q.offer(c.left);
                if(c.right != null) q.offer(c.right);
            }
        }
        return ans;
    }
}