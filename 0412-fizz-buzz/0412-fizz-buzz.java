class Solution {
    public List<String> fizzBuzz(int n) {
        String a = "FizzBuzz";
        String b = "Fizz";
        String c = "Buzz";
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                ans.add(a);

            else if (i % 3 == 0)
                ans.add(b);

            else if (i % 5 == 0)
                ans.add(c);

            else
                ans.add(Integer.toString(i));
        }
        return ans;
    }
}