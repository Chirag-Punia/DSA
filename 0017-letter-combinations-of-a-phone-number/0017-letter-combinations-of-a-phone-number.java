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
    public void temp(String digits,StringBuilder tmp,int i){
        if(i == digits.length()){
            ans.add(tmp.toString());
            return;
        }
        String letters = mpp.get(digits.charAt(i));
        for(int j = 0;j<letters.length();j++){
            tmp.append(letters.charAt(j));
            temp(digits,tmp,i+1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        temp(digits,new StringBuilder(""),0);
        return ans;
    }
}