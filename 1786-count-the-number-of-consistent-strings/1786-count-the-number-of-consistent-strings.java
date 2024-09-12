class Solution {
  public int countConsistentStrings(String allowed, String[] words) {
    var map = new boolean[26];
    var res = words.length;

    for (var c : allowed.toCharArray())
      map[c - 'a'] = true;

    for (var word : words) {
      for (var c : word.toCharArray()) {
        if (!map[c - 'a']) {
          res--;
          break;
        }
      }
    }
    return res;
  }
}