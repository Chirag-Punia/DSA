import java.util.*;
import java.lang.*;
import java.io.*;
//https://www.codechef.com/START137D/problems/CMIX
class Codechef
{
    public static void main(String[] args) throws java.lang.Exception
    {
        // your code goes here
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        int N;
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            ArrayList < Integer > A = new ArrayList < > ();
            ArrayList < Integer > V = new ArrayList < > ();
            int x, y;
            for (int j = 0; j < N; j++) {
                x = sc.nextInt();
                y = sc.nextInt();
                A.add(x);
                V.add(y);
            }
            int ans = 0;
            for (int k = 0; k < N; k++) {
                for (int a = k + 1; a < N; a++) {
                    int combinedStrength = A.get(k) * V.get(a) + V.get(k) * A.get(a);
                    if (combinedStrength > ans) {
                        ans = combinedStrength;
                    }
                }
            }
            System.out.println(ans);

        }
        sc.close();

    }

}
