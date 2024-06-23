class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int[] ans = new int[nums.length];
        int n = nums.length;
        Stack<Integer> s = new Stack();

        for(int i = 2*n - 1;i>=0;i--){
            int c = nums[i % n];
            while(!s.isEmpty() && s.peek() <= c){
                s.pop();
            }
            if(i < n){
                if(s.isEmpty()){
                ans[i % n] = -1;
            }
            else{
                ans[i % n] = s.peek();
            }
            }
            
            s.push(c);
        }
        return ans;
        
    }
}