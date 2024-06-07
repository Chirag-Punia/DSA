import java.util.* ;
import java.io.*; 


//https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401?leftPanelTabValue=SOLUTION
public class Solution {
    public static int cielFinder(int[] arr, int n, int target){
        int left = 0;
        int right = arr.length - 1;
        //Here LEFT point to smallest number greater than TARGET
        int ans = -1;
        while(left <= right){
            int mid = (left+right)/2;
    
            if(arr[mid] >= target){
                ans = arr[mid];
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
            
        }
        return ans;
    }
    public static int floorFinder(int[] arr, int n, int target){
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        
        while(left <= right){
            int mid = (left+right)/2;
    
            if(arr[mid] <= target){
                ans = arr[mid];
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }
    public static int[] getFloorAndCeil(int[] arr, int n, int target) {
        // Write your code here.
        int[] ans = {floorFinder(arr, n, target),cielFinder(arr, n, target)};
        return ans;

    }
    
}
