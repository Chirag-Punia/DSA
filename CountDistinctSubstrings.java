import java.util.*;
//https://www.naukri.com/code360/problems/count-distinct-substrings_985292?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTabValue=SUBMISSION
class Node{
    Node[] children;

    Node(){
        this.children = new Node[26];
     
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
class Trie {
    private Node root;
	public int cnt;
    public Trie() {
        root = new Node();
		cnt = 0;
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
            if(!curr.containsCh(c)){
				curr.put(c, new Node());
				cnt++;
			}  
            curr = curr.get(c);
        } 
    }    
}
public class Solution 
{

	public static int countDistinctSubstrings(String s) 
	{
		Trie T = new Trie();
		for(int i = 0;i<s.length();i++){
			T.insert(s.substring(i,s.length()));
		}
		return T.cnt+1;

		//BRUTE FORCE

		// Set<String> set = new HashSet<>();
		// int cnt = 0;
		// for(int i = 0;i<s.length();i++){
		// 	for(int j = i+1;j<=s.length();j++){
		// 		if(!set.contains(s.substring(i,j)))cnt++;
		// 		set.add(s.substring(i,j));
		// 	}
		// }
		// return cnt+1;
		
	}
}
