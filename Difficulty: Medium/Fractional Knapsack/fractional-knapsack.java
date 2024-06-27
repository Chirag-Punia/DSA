//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Item(Integer.parseInt(inputLine[k++]),
                                  Integer.parseInt(inputLine[k++]));
            }
            System.out.println(
                String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution {
     double fractionalKnapsack(int w, Item arr[], int n) {
        double dp[][] = new double[n][2];
        double ans = 0;
        
        for (int i = 0; i < n; i++) {
            dp[i][0] = i;
            dp[i][1] = (double) arr[i].value / arr[i].weight;
        }
        Arrays.sort(dp, new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return Double.compare(b[1], a[1]);
            }
        });
        for (int i = 0; i < n; i++) {
            int idx = (int) dp[i][0];
            if (arr[idx].weight <= w) {
                ans += (double) arr[idx].value;
                w -= arr[idx].weight;
            } else {
                ans += dp[i][1] * (double) w;
                break;
            }
        }
        
        return ans;
    }
}