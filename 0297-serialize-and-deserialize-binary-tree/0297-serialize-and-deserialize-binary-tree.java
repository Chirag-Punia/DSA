/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder sb;
    Codec(){
        sb = new StringBuilder();
    }
    void inOrder(TreeNode root){
        if(root == null){
            sb.append("null,");
            return;
        }

        sb.append(root.val+",");
        inOrder(root.left);
        inOrder(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        inOrder(root);
        return sb.toString();
    }
    public TreeNode buildTree(String[] nodes, int[] index){

        if(index[0] >= nodes.length || nodes[index[0]].equals("null")){
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[index[0]]));
        index[0]++;
        node.left = buildTree(nodes,index);
        node.right = buildTree(nodes,index);
        return node;
        }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty())return null;
        String[] nodes = data.split(",");
        int[] index = {0};
        return buildTree(nodes, index);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));