//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution
{
    public static long binarySearch(long x,long ans,long left,long right){
        long mid = (right+left) / 2;
        long xx = ans;
        if(left <= right){
            if(mid*mid <= x){
                return binarySearch(x,mid,mid + 1,right);
            }
            else{
                return binarySearch(x,xx,left,mid-1);
            }
        }
        return xx;
    }
    
     long floorSqrt(long x)
	 {
		return binarySearch(x,1,1,x);
		
//      BRUTE FORCE
// 		long ans = 0;
// 		for(long i = 0;i<=x;i++){
// 		    long val = i * i;
// 		    if(val <= x){
// 		        ans = i;
// 		    }
// 		    else{
// 		        break;
// 		    }
// 		}
// 		return ans;
		
	 }
}
