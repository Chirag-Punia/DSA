class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();

        int low=0, high=n-1;

        while(high>low){
            int mid = (low+high)/2;
            if(check(ch,mid)) low = mid+1;
            else high = mid;
        }

        return low-1;
    }

    public boolean check(char[] ch, int len){

        int[] oc = new int[26];
        int count = 1;
        char prev = '.';
        for(int i=0;i<ch.length;i++){
            if(ch[i]!=prev){
                prev = ch[i];
                count = 1;
            }
            else{
                count++;
            }
            
            if(count>=len && ++oc[ch[i]-'a']>2){
                return true;
            }
        }
        return false;
    }
}