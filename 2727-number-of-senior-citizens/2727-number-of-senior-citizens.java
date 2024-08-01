class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        for(String s : details){
            int d1 = s.charAt(11) - '0';
            int d2 = s.charAt(12) - '0';
            int age = 10*d1 + d2;
            if(age > 60)cnt++;
        }
        return cnt;
    }
}