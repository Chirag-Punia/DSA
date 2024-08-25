class Solution {
  //https://practice.geeksforgeeks.org/contest/gfg-weekly-169-rated-contest/problems
    public static long cntGood(String s) {
        long cnt = 0;
        long np = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            

            if (curr != '0') {
                np++;
            }
            
      
            if ((curr - '0') % 2 != 0) {
                cnt += np;
            }
        }
        
        return cnt;
    }
}
