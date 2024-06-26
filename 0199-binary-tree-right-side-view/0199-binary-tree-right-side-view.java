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
    public static class nodeInfo{
        TreeNode node;
        int col;
        int row;
        nodeInfo(TreeNode node,int row,int col){
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }
    public static int maxi(List<nodeInfo> xx){
        int max = Integer.MIN_VALUE;
        nodeInfo temp = new nodeInfo(null,0,0);
        for(int i = 0;i<xx.size();i++){
            if(xx.get(i).col > max){
                max = xx.get(i).col;
                temp = xx.get(i);
            }
        }
        return temp.node.val;
    }
    public List<Integer> rightSideView(TreeNode root) {

        Queue<nodeInfo> q = new LinkedList<>();
        TreeMap<Integer,List<Integer>> mpp = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        q.offer(new nodeInfo(root,0,0));
        while(!q.isEmpty()){
            nodeInfo c = q.poll();
            mpp.computeIfAbsent(c.row,k -> new ArrayList<>()).add(c.node.val);
            if(c.node.left != null){
                q.offer(new nodeInfo(c.node.left,c.row + 1,c.col - 1));
            }
            if(c.node.right != null){
                q.offer(new nodeInfo(c.node.right,c.row + 1,c.col + 1));
            }
        }
        
        for(Map.Entry<Integer,List<Integer>> entry : mpp.entrySet()){
            List<Integer> x = entry.getValue();
            ans.add(x.get(x.size() - 1));
        }
        return ans;
    }
}