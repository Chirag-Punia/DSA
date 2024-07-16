class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int ans = 0;
        
        // for (int i = 0; i < n; i++) {
        //     HashMap<Character, Integer> mpp = new HashMap<>();
        //     int maxFreq = 0;
            
        //     for (int j = i; j < n; j++) {
        //         char curr = s.charAt(j);
        //         mpp.put(curr, mpp.getOrDefault(curr, 0) + 1);
        //         maxFreq = Math.max(maxFreq, mpp.get(curr));
                
        //         int change = (j - i + 1) - maxFreq;
        //         if (change <= k) {
        //             ans = Math.max(ans, j - i + 1);
        //         } else {
        //             break;
        //         }
        //     }
        // }
        HashMap<Character, Integer> mpp = new HashMap<>();
        int left = 0;
        int maxFreq = 0; 
        for (int right = 0; right < n; right++) {
            char curr = s.charAt(right);
            mpp.put(curr, mpp.getOrDefault(curr, 0) + 1);
            maxFreq = Math.max(maxFreq, mpp.get(curr));


            int change = (right - left + 1) - maxFreq;


            if (change > k) {
                char leftChar = s.charAt(left);
                mpp.put(leftChar, mpp.get(leftChar) - 1);
                if (mpp.get(leftChar) == 0) {
                    mpp.remove(leftChar);
                }
                left++;
            }


            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}