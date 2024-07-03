import java.util.*;

class Solution {
    public class Pair {
        String s;
        int i;

        Pair(String s, int i) {
            this.s = s;
            this.i = i;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            String currentWord = currentPair.s;
            
            if (currentWord.equals(endWord))
                return currentPair.i;
            
            for (int j = 0; j < currentWord.length(); j++) {
                char[] wordArray = currentWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (wordArray[j] == c)
                        continue;
                    wordArray[j] = c;
                    String newWord = new String(wordArray);
                    if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                        queue.offer(new Pair(newWord, currentPair.i + 1));
                        visited.add(newWord);
                    }
                }
            }
        }
        
        return 0; 
    }
}
