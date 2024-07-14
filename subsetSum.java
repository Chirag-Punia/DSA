//https://www.naukri.com/code360/problems/subset-sum_630213?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
public class Solution {
    public static int s;
    public static boolean tmp(int k,int[] a,int i){
        if(i >= a.length){
            if(s == k) return true;
            return false;
        }
        s += a[i];
        if(s<=k && tmp(k,a,i+1))return true;
        s -= a[i];
        if(s<=k && tmp(k,a,i+1))return true;
        return false;

    }
    public static boolean isSubsetPresent(int n, int k,int []a) {
        // Write your code here
        s = 0;
        return tmp(k,a,0);
    }
}
