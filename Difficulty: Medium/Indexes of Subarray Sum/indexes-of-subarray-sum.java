//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String s[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for (int ii = 0; ii < res.size(); ii++) ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends




class Solution {
    // Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum=0;
        int index=0;
        for(int i=0;i<arr.length;i++) {
            sum+=arr[i];
            while(sum>s && i>index) {
                sum = sum-arr[index];
                index++;
            }
            if(sum==s) {
                arrayList.add(index+1);
                arrayList.add(i+1);
                return arrayList;
            }
        }
        arrayList.add(-1);
        return arrayList;
    }
}