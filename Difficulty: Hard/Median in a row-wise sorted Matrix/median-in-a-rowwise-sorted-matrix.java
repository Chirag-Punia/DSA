//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    int upperBound(int[] arr, int target, int left, int right, int ans) {
        if (left > right) return ans;
        int mid = (left + right) / 2;
        if (arr[mid] > target) {
            return upperBound(arr, target, left, mid - 1, mid);
        } else {
            return upperBound(arr, target, mid + 1, right, ans);
        }
    }

    int countSmallEqual(int[][] matrix, int R, int C, int target) {
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            cnt += upperBound(matrix[i], target, 0, C - 1, C); 
        }
        return cnt;
    }

    int tmp(int[][] matrix, int R, int C, int left, int right, int ans, int req) {
        if (left > right) return ans;
        int mid = (left + right) / 2;
        if (countSmallEqual(matrix, R, C, mid) <= req) {
            return tmp(matrix, R, C, mid + 1, right, mid, req); 
        } else {
            return tmp(matrix, R, C, left, mid - 1, ans, req);
        }
    }

    int median(int matrix[][], int R, int C) {
         int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) {
            low = Math.min(low, matrix[i][0]); 
            high = Math.max(high, matrix[i][C - 1]); 
        }

        int req = (R * C) / 2 + 1; 
        
        while (low < high) {
            int mid = (low + high) / 2;
            int count = countSmallEqual(matrix, R, C, mid);

            if (count < req) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

