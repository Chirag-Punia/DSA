class Solution {
    public class Pair {
        String s;
        int i;

        Pair(String s, int i) {
            this.i = i;
            this.s = s;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!q.isEmpty()) {
            Pair item = q.poll();
            if (item.s.toString().equals(endWord))
                return item.i;
            for (int j = 0; j < item.s.length(); j++) {
                char originalChar = item.s.charAt(j);
                for (char i = 'a'; i <= 'z'; i++) {
                        if (i == originalChar)
                            continue;
                    StringBuilder temp = new StringBuilder(item.s);
                    temp.setCharAt(j, i);
                    String ss = temp.toString();
                    if (set.contains(ss) && !visited.contains(ss)) {
                        Pair newPair = new Pair(ss, item.i + 1);
                        q.offer(newPair);
                        visited.add(ss);
                    }

                }
            }
        }
        return 0;
    }

}