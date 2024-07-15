class Solution {
    public List<String> ans;
    public String mpp[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void temp(List<Integer> digits,String tmp,int i){
        if(i == digits.size()){
            ans.add(tmp);
            return;
        }
        for(int j = 0;j<mpp[digits.get(i)].length();j++){
            temp(digits,tmp+mpp[digits.get(i)].charAt(j),i+1);
        }
    }
    public static List<Integer> convertStringToDigits(String str) {
        List<Integer> digits = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            digits.add(Character.getNumericValue(ch));
        }
        return digits;
    }
    public List<String> letterCombinations(String d) {
        ans = new ArrayList<>();
        if (d == null || d.length() == 0) {
            return ans;
        }
        List<Integer> digits = convertStringToDigits(d);
        HashMap<String,String> mpp2 = new HashMap<>();
        mpp2.put("2","abc");
        mpp2.put("2","abc");
        mpp2.put("2","abc");
        mpp2.put("2","abc");
        temp(digits,"",0);
        return ans;
    }
}