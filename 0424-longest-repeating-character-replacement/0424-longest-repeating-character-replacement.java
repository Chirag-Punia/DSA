class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> mpp = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = Integer.MIN_VALUE,maxf = Integer.MIN_VALUE;
        int n = s.length();
        while(right < n){
            char curr = s.charAt(right);
            mpp.put(curr,mpp.getOrDefault(curr,0) + 1);
            maxf = Math.max(maxf,mpp.get(curr));
            int changes = (right - left + 1) - maxf;
            if(changes > k){
                char c = s.charAt(left++);
                mpp.put(c,mpp.get(c) - 1);
                if(mpp.get(c) == 0)mpp.remove(c);
            }
            ans = Math.max(right - left + 1,ans);
            right++;     
        }
        return ans;
    }
}