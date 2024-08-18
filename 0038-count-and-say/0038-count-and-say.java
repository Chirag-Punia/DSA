class Solution {
    String tmp(int n){
        if(n==1)
            return "1";
        String say = tmp(n-1);
        StringBuilder res = new StringBuilder("");
        for(int i =0;i<say.length();i++){
            char ch = say.charAt(i);
            int cnt = 1;
            while(i < say.length()-1 && say.charAt(i) == say.charAt(i+1)){
                i++;
                cnt++;
            }
            res.append(cnt + "" + Character.toString(ch));
        }
        return res.toString();
    }
    public String countAndSay(int n) {
        return tmp(n);
    }
}