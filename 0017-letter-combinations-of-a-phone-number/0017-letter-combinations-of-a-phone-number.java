class Solution {
    public List<String> ans;
    public void temp(String digits,String tmp,int i,HashMap<String,String> mpp){
        if(i == digits.length()){
            ans.add(tmp);
            return;
        }
        for(int j = 0;j<mpp.get(Character.toString(digits.charAt(i))).length();j++){
            temp(digits,tmp+mpp.get(Character.toString(digits.charAt(i))).charAt(j),i+1,mpp);
        }
    }
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        HashMap<String,String> mpp = new HashMap<>();
        mpp.put("2","abc");
        mpp.put("3","def");
        mpp.put("4","ghi");
        mpp.put("5","jkl");
        mpp.put("6","mno");
        mpp.put("7","pqrs");
        mpp.put("8","tuv");
        mpp.put("9","wxyz");
        temp(digits,"",0,mpp);
        return ans;
    }
}