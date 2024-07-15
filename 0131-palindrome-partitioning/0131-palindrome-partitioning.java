class Solution {
    List<List<String>> ans;
    List<String> arr;
    public boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public void tmp(String s,int i){
        if(i == s.length()){
            ans.add(new ArrayList<>(arr));
            return;
        }
        for(int j = i;j<s.length();j++){
            if(isPalindrome(s,i,j)){
                arr.add(s.substring(i,j+1));
                tmp(s,j+1);
                arr.remove(arr.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        arr = new ArrayList<>();
        tmp(s,0);
        return ans;
    }
}