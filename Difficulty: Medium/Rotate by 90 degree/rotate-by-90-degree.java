//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();

            GFG g = new GFG();
            g.rotate(arr);
            printMatrix(arr);

            System.out.println("~");
        }
    }

    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class GFG 
{
    static void rotate(int matrix[][]) 
    {
        reverseMatrix(matrix);
        transposeMatrix(matrix);
    }
        // Code Here
    public static void reverseMatrix(int [][]matrix)
      {
        int N = matrix.length;
        int start = 0;
        int end = N - 1;
        while(start<end)
        {
            int []temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }
      }
    public static void transposeMatrix(int [][]matrix) 
    {
          int N = matrix.length;
          for(int i=0; i<N-1; i++)
          {
           for(int j=i; j<N; j++) 
           {
                int temp  = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
         }  
    }
}