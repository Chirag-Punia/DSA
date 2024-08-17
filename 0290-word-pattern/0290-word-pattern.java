import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        String[] words = s.split(" ");
        
        if (pattern.length() != words.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char currChar = pattern.charAt(i);
            String currWord = words[i];

            if (charToWord.containsKey(currChar)) {
                if (!charToWord.get(currChar).equals(currWord)) return false;
            } else {
                charToWord.put(currChar, currWord);
            }

            if (wordToChar.containsKey(currWord)) {
                if (!wordToChar.get(currWord).equals(currChar)) return false;
            } else {
                wordToChar.put(currWord, currChar);
            }
        }

        return true;
    }
}
