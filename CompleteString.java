//https://www.naukri.com/code360/problems/complete-string_2687860?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTabValue=PROBLEM
import java.util.* ;
import java.io.*; 

class Node{
    Node[] children;
    boolean flag;
    Node(){
        this.children = new Node[26];
        this.flag = false;
    }
    Node get(char ch){
        return children[ch - 'a'];
    }
    void put(char ch, Node node){
        children[ch - 'a'] = node;
    }
    void setFlag(){
        flag = true;
    }
    boolean containsCh(char ch){
        return (children[ch - 'a'] != null);
    }
}
class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
            if(!curr.containsCh(c))
            curr.put(c, new Node());
            curr = curr.get(c);
        }
        curr.flag = true; 
    }
    public boolean isComp(String word){
      Node curr = root;
      for(char ch : word.toCharArray()){
        curr = curr.get(ch);
        if(!curr.flag)return false;
  
      }
      return true;
    }
    public String ans(String[] a){
      Node curr = root;
      String ans = "";
      for(String s : a){
        if(isComp(s)){
          if(s.length() > ans.length()  || (s.length() == ans.length() && s.compareTo(ans) < 0))ans = s;
        }
      }
      return ans.isEmpty() ? "None" : ans;
    }
    
    
}
class Solution {


  public static String completeString(int n, String[] a) {
    // Write your code here.
    Trie T = new Trie();
    for(String s : a){
      T.insert(s);
    }
    return T.ans(a);
  }
}
