class Solution {
    public List<String> ans;
    private static final HashMap<Character, String> mpp = new HashMap<>();
    static {
        mpp.put('2', "abc");
        mpp.put('3', "def");
        mpp.put('4', "ghi");
        mpp.put('5', "jkl");
        mpp.put('6', "mno");
        mpp.put('7', "pqrs");
        mpp.put('8', "tuv");
        mpp.put('9', "wxyz");
    }
    public void temp(String digits,String tmp,int i){
        if(i == digits.length()){
            ans.add(tmp);
            return;
        }
        String letters = mpp.get(digits.charAt(i));
        for(int j = 0;j<letters.length();j++){
            String newStr = tmp+letters.charAt(j);
            temp(digits,newStr,i+1);
        }
    }
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        temp(digits,"",0);
        return ans;
    }
}