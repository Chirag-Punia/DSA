class Solution {
    int count0(String s){
        int cnt = 0;
        for(char a : s.toCharArray()){
            if(a == '0')cnt++;
        }
        return cnt;
    }
    int count1(String s){
        int cnt = 0;
        for(char a : s.toCharArray()){
            if(a == '1')cnt++;
        }
        return cnt;
    }
    public int maxScore(String s) {
        int maxi = Integer.MIN_VALUE;
        int n = s.length();
        for(int i = 0;i<n;i++){
            String temp1 = s.substring(0,i+1);
            String temp2 = s.substring(i+1);
            if(!temp1.equals("") && !temp2.equals(""))
                maxi = Math.max(maxi,count0(temp1) + count1(temp2));
        }
        return maxi;
    }
}