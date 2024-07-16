class Solution {

    public int numberOfSubstrings(String s) {
        int right = 0,cnt = 0,n = s.length(),a = -1,b = -1,c = -1;
        
        while(right < n){
            if(s.charAt(right) == 'a')a = right;
            else if(s.charAt(right) == 'b')b= right;
            else c = right;
            if(a != -1 && b != -1 && c != -1){
                int min = Math.min(a, Math.min(b, c));
                cnt += min + 1;
            }
            right++;
        }
        return cnt;
    }
}