class Solution {
    public String reverseWords(String s) {
        
        String[] words = s.trim().split("\\s+");//split the words separated by 1 space 

        StringBuilder ans = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--){
            ans.append(words[i]);
            if(i != 0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}