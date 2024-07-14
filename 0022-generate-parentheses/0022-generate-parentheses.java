class Solution {
    public List<String> ans;
    public void tmp(int o,int c, int n,String s){
        if(o == n && c == n){ans.add(s);return;}
        if(o < n)tmp(o+1,c,n,s+'(');
        if(o>c)tmp(o,c+1,n,s+')');
    }
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        tmp(0,0,n,"");
        return ans;
    }
}
