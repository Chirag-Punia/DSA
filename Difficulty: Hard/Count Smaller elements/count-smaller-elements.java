//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public int binarySearch(List<Integer> v, int x) {
        int l = 0, h = v.size() - 1, mid;
        while (l <= h) {
            mid = (l + h) / 2;
            if (v.get(mid) == x) return mid;
            else if (v.get(mid) > x) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public int[] constructLowerArray(int[] arr) {
        List<Integer> v = new ArrayList<>();
        for (int num : arr) {
            v.add(num);
        }
        Collections.sort(v);

        int[] t = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max = binarySearch(v, arr[i]);
            while (max > 0 && v.get(max - 1).equals(v.get(max))) {
                max--;
            }
            t[i] = max;
            v.remove(max);
        }
        return t;
    }
}