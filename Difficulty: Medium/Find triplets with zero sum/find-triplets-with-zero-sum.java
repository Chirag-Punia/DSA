//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends




/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
		Arrays.sort(arr);
		for(int i=0;i<n-1;i++)
		{
			if(duplet(arr,0-arr[i],i+1)+arr[i]==0)
				return true;		
		}
		
		return false;
        //add code here.
    }
    public  int duplet(int arr[],int n,int i)
	{
		int s=0;
		int e=arr.length-1;
		while(s<e)
		{
			if (s==i-1)
			{
				s++;	
			}
			else if(e==i-1)
			{
				e--;
			}
			else if(arr[s]+arr[e]==n)
			{
			//	System.out.println(arr[s]+arr[e] + " " +s+ " "+e);
				return n;
			}
			else if(arr[s]+arr[e]>n)
			{
				e--;
			}
			else {
				s++;
			}
		}
		
		return Integer.MAX_VALUE;
		
	}
}