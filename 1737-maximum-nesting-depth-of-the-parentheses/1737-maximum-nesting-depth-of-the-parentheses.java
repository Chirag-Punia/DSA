class Solution {
    public int maxDepth(String str) {
        Stack<Character> s = new Stack<>();
        int cnt = 0;
        int ans = 0;
        for(int i = 0;i<str.length();i++){
            char curr = str.charAt(i);
            if(curr == '('){cnt++;s.push(curr);ans=Math.max(cnt,ans);}
            else if(curr == ')'){s.pop();cnt--;}
        }
        return ans;
    }
}