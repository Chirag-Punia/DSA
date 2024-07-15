class Solution {
    public int maxDepth(String str) {
        int cnt = 0;
        int ans = 0;
        for(int i = 0;i<str.length();i++){
            char curr = str.charAt(i);
            if(curr == '('){
                ++cnt;
                ans=Math.max(cnt,ans);
            }
            else if(curr == ')')--cnt;
        }
        return ans;
    }
}