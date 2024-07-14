//https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=perfect-sum-problem
class Solution{
    public static int s;
    public static int cnt;
    public void tmp(int[] arr,int sum, int i){
        if(i >= arr.length){
            if(sum == s) cnt++;
            return;
        }
        s += arr[i];
        tmp(arr,sum,i+1);
        s -= arr[i];
        tmp(arr,sum,i+1);
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    s=0;
	    cnt=0;
	    tmp(arr,sum,0);
	    return cnt;
	} 
}
