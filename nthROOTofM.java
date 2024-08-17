//https://www.naukri.com/code360/problems/1062679?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTabValue=PROBLEM
public class Solution {
    public static long root(int num, int n) {
        long ans = 1;
        for (int j = 0; j < n; j++) {
            ans *= num;
            if (ans > Integer.MAX_VALUE) return Long.MAX_VALUE;
        }
        return ans;
    }
    public static int binarySearch(int n, int m, int left, int right) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;
        long ans = root(mid, n);

        if (ans == m) return mid;
        else if (ans < m) return binarySearch(n, m, mid + 1, right);
        else return binarySearch(n, m, left, mid - 1);
    }
    public static int NthRoot(int n, int m) {
        // Write your code here.
        
        return binarySearch(n, m, 0, m);
    }
}
