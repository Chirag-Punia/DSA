//https://www.interviewbit.com/problems/nearest-smaller-element/

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();
        if(n == 1){
            ans.add(-1);
            return ans;
        }
        Stack<Integer> s = new Stack();
        for(int i = 0;i<n;i++){
            int c = A.get(i);
            while(!s.isEmpty() && s.peek() >= c){
                s.pop();
            }
            if(s.isEmpty()){
                ans.add(-1);
            }
            else{
                ans.add(s.peek());
            }
            s.push(c);
        }
        return ans;
    }
}
