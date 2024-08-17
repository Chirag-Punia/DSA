//https://www.interviewbit.com/problems/repeat-and-missing-number-array/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        long n = A.size();
        long sum = n * (n + 1) / 2;
        long squareSum = n * (n + 1) * (2 * n + 1) / 6;

        long Asum = 0;
        long AsquareSum = 0;

        for (int i = 0; i < A.size(); i++) {
            Asum += A.get(i);
            AsquareSum += (long) A.get(i) * A.get(i);
        }

        long diff = Asum - sum;  // A - B
        long sqDiff = AsquareSum - squareSum;  // A^2 - B^2

        long sumAB = sqDiff / diff;  // A + B

        long X = (diff + sumAB) / 2;
        long B = sumAB - X;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int) X);  
        ans.add((int) B);  

        return ans;
    }
}
