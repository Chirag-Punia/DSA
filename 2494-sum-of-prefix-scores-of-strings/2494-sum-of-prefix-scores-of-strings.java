class Node{
    Node[] children;
    int cnt;
    Node(){
        this.children = new Node[26];
        this.cnt = 0;
    }
}
class Trie{
    Node root;
    Trie(){
        this.root = new Node();
    }
    void insert(String word){
        int n = word.length();
        Node temp = root;
        for(int i = 0;i<n;i++){
            char curr = word.charAt(i);
            Node next = temp.children[curr - 'a'];
            if(next == null){
                next = new Node();
                temp.children[curr - 'a'] = next;
            }
            next.cnt += 1;
            temp = next;
        }
    }
    int sum(String word){
        int sum = 0;
        Node temp = root;
        for(int i = 0;i<word.length();i++){
            char curr = word.charAt(i);
            sum += temp.children[curr - 'a'].cnt;
            temp = temp.children[curr - 'a'];
        }
        return sum;
    }
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie T = new Trie();
        int[] ans = new int[words.length];
        for(String a : words){
            T.insert(a);
        }
        for(int i = 0;i<words.length;i++){
            ans[i] = T.sum(words[i]);
        }
        return ans;
    }
}