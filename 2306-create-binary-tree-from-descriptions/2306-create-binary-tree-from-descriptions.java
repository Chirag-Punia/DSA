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
    public TreeNode createBinaryTree(int[][] nodeDescriptions) {
         Map<Integer, Integer> nodeInDegreeMap = new HashMap<>();
         Map<Integer, TreeNode> valueToNodeMap = new HashMap<>();

         for (var description : nodeDescriptions) {
            int parentValue = description[0], childValue = description[1];
            boolean isLeftChild = (description[2] == 1);

            nodeInDegreeMap.putIfAbsent(parentValue, 0);
            nodeInDegreeMap.put(childValue, nodeInDegreeMap.getOrDefault(childValue, 0) - 1);

            valueToNodeMap.putIfAbsent(parentValue, new TreeNode(parentValue));
            valueToNodeMap.putIfAbsent(childValue, new TreeNode(childValue));

            if (isLeftChild) {
                valueToNodeMap.get(parentValue).left = valueToNodeMap.get(childValue);
            } else {
                valueToNodeMap.get(parentValue).right = valueToNodeMap.get(childValue);
            }
         }

         for (var entry : nodeInDegreeMap.entrySet()) {
             if (entry.getValue() == 0) return valueToNodeMap.get(entry.getKey());
         }

         return null;
    }
}
