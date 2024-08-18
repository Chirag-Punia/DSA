import java.util.ArrayList;
import java.util.List;

class Solution {
    StringBuilder sb = new StringBuilder();
    int cnt = 0;
    String ans = "";
    
    void tmp(int n, int k, List<Integer> numbers) {
        if (n == 0) {
            return;
        }

        int factorial = fact(n - 1);
        int index = (k - 1) / factorial;
        
        sb.append(numbers.get(index));
        numbers.remove(index);

        k -= index * factorial;

        tmp(n - 1, k, numbers);
    }
    
    int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public String getPermutation(int n, int k) {
        sb = new StringBuilder();
        ans = "";
        cnt = 0;
        
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        tmp(n, k, numbers);
        
        return sb.toString();
    }
}
