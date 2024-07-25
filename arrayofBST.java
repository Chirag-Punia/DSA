

// User function Template for Java

class Solution {
    public Node solve(Node root,int low,int high,int [] nums){
        if(low>high){
            return null;
        }
        int mid=low+(high-low)/2;
        Node temp=new Node(nums[mid]);
        if(temp.data<root.data){
            root.left=temp;
        }
        else{
            root.right=temp;
        }
        solve(temp,low,mid-1,nums);
        solve(temp,mid+1,high,nums);
        return temp;
    }
    public Node sortedArrayToBST(int[] nums) {
        int n=nums.length;
        int i=0,j=n-1;
        int mid=i+(j-i)/2;
        Node root=new Node(nums[mid]);
        root.left=solve(root,0,mid-1,nums);
        root.right=solve(root,mid+1,j,nums);
        return root;
    }
}
