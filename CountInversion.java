import java.util.* ;
import java.io.*; 
public class Solution {
    //https://www.naukri.com/code360/problems/count-inversions_615?leftPanelTabValue=PROBLEM
    static int ans;
    static List<Long> arr1;
    public static void tmp(long[] nums , int i){
        if(arr1.size() == 2){
            if(arr1.get(1) - arr1.get(0) < 0)ans++;
            return;
        }
        if(i >= nums.length)return;
        arr1.add(nums[i]);
        tmp(nums,i+1);
        arr1.remove(arr1.size() - 1);
        tmp(nums,i+1);
    }
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        ans = 0;
        arr1 = new ArrayList<>();
        tmp(arr,0);
        return ans;
    }
}
