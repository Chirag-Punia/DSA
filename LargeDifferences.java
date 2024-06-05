import java.util.*;
import java.lang.*;
import java.io.*;
//https://www.codechef.com/START137D/problems/HIDIF
class Codechef
{

    public static int maxArr(ArrayList < Integer > A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > max) {
                max = A.get(i);
            }
        }
        return max;
    }
    public static int maxArrIndex(ArrayList < Integer > A) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > max) {
                max = A.get(i);
                index = i;
            }
        }
        return index;
    }
    public static int minArr(ArrayList < Integer > A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < min) {
                min = A.get(i);
            }
        }
        return min;
    }
    public static int minArrIndex(ArrayList < Integer > A) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < min) {
                min = A.get(i);
                index = i;
            }
        }
        return index;
    }
    public static int diff(ArrayList < Integer > A) {
        int temp = 0;
        for (int a = 0; a < A.size() - 1; a++) {
            temp = temp + Math.abs((A.get(a) - A.get(a + 1)));
        }
        return temp;
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        // your code goes here
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        int N, K;
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            K = sc.nextInt();
            ArrayList < Integer > A = new ArrayList < > ();
            for (int j = 0; j < N; j++) {
                int in = sc.nextInt();
                A.add(in);
            }
            int maxSum = diff(A);
            for (int a = 0; a < N; a++) {
                int x = A.get(a);
                A.set(a, 1);
                int diffSum = diff(A);
                if (diffSum > maxSum) {
                    maxSum = diffSum;
                }
                A.set(a, K);
                diffSum = diff(A);
                if (diffSum > maxSum) {
                    maxSum = diffSum;
                }
                A.set(a, x);
            }
            System.out.println(maxSum);

        }

    }
}
