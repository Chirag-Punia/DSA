//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            int[] ans = new Solve().findTwoElement(arr);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}

// } Driver Code Ends

// User function Template for Java
class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        int[] mpp = new int[arr.length + 1];
        int repeat = 0;
        int missing = 0;
        for(int a: arr){
            mpp[a] += 1;
        }
        for(int i = 1;i<=arr.length;i++){
            if(mpp[i] == 2)repeat = i;
            if(mpp[i] == 0)missing = i;
        }
        int[] ans = {repeat,missing};
        return ans;
        
    }
}
