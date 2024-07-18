import java.util.* ;
//https://www.naukri.com/code360/problems/implement-trie_1387095?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTabValue=SUBMISSION
import java.io.*; 
class Node{
    Node[] children;
    int isEnd;
    int countPrefix;
    Node(){
        this.children = new Node[26];
        this.isEnd = 0;
        this.countPrefix = 0;
    }
    int isEnd(){
        return isEnd;
    }
    Node get(char ch){
        return children[ch - 'a'];
    }
    void put(char ch, Node node){
        children[ch - 'a'] = node;

    }
    boolean containsCh(char ch){
        return (children[ch - 'a'] != null);
    }
}

public class Trie {
    Node root;
    public Trie() {
        // Write your code here.
        root = new Node();
    }
    public void insert(String word) {
        // Write your code here.
        Node node = root;
        for(int i = 0;i<word.length();i++){
            if(!node.containsCh(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
            node.countPrefix++;
        }
        node.isEnd++;
    }
    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node curr = root;
        for(char c : word.toCharArray()){
            if(!curr.containsCh(c))return 0;
            curr = curr.get(c);
        }
        return curr.isEnd;

    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node curr = root;
        for(char c :word.toCharArray()){
            if(!curr.containsCh(c))return 0;
            curr = curr.get(c);
        }
        return curr.countPrefix;
    }

    public void erase(String word) {
        // Write your code here.
        Node curr = root;
        for(char c :word.toCharArray()){
            if(!curr.containsCh(c))return;
            curr = curr.get(c);
            curr.countPrefix--;
            curr.isEnd--;
        }
        
    }

}
