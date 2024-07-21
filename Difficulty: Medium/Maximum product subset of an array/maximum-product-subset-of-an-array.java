//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends



class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // code here
        long ans=1;
        int maxNeg=-10;
        for(int i:arr){
            if(i!=0){
                ans=(ans*i)%1000000007;
            }
            if(i<0 && maxNeg<i)maxNeg=i;
        }
        if(ans<0)return ans/maxNeg;
        return ans;
    }
}