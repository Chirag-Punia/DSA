import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/
//https://www.naukri.com/code360/problems/ceil-from-bst_920464?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTabValue=PROBLEM
public class Solution {
    static int ans = Integer.MAX_VALUE;

    private static void tmp(TreeNode<Integer> root, int X) {
        if (root == null) return;

        if (root.data == X) {
            ans = root.data;
            return;
        }

        if (root.data < X) {
            tmp(root.right, X);
        } else {
            ans = Math.min(ans, root.data);
            tmp(root.left, X);
        }
    }
    public  static int findCeil(TreeNode<Integer> root, int X) {

        // Write your code here
        ans = Integer.MAX_VALUE;
        tmp(root, X);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
