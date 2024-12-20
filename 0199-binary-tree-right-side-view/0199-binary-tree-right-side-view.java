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
        int row;
        nodeInfo(TreeNode node,int row){
            this.node = node;
            this.row = row;
        }
    }
    public static void right(TreeNode root,int level,List<Integer> arr){
        if(root == null) return;
        if(level == arr.size()) arr.add(root.val);
        right(root.right,level + 1,arr);
        right(root.left,level + 1,arr);
    }
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> arr = new ArrayList<>();
        right(root,0,arr);
        return arr;

        //BRUTE FORCE
        // Queue<nodeInfo> q = new LinkedList<>();
        // TreeMap<Integer,List<Integer>> mpp = new TreeMap<>();
        // List<Integer> ans = new ArrayList<>();
        // if(root == null){
        //     return ans;
        // }
        // q.offer(new nodeInfo(root,0));
        // while(!q.isEmpty()){
        //     nodeInfo c = q.poll();
        //     mpp.computeIfAbsent(c.row,k -> new ArrayList<>()).add(c.node.val);
        //     if(c.node.left != null){
        //         q.offer(new nodeInfo(c.node.left,c.row + 1));
        //     }
        //     if(c.node.right != null){
        //         q.offer(new nodeInfo(c.node.right,c.row + 1));
        //     }
        // }
        
        // for(Map.Entry<Integer,List<Integer>> entry : mpp.entrySet()){
        //     List<Integer> x = entry.getValue();
        //     ans.add(x.get(x.size() - 1));
        // }
        // return ans;
    }
}