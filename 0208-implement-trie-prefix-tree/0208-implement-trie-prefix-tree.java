class Node{
    Node[] children;
    boolean isEnd;
    Node(){
        this.children = new Node[26];
        this.isEnd = false;
    }
    boolean isEnd(){
        return isEnd;
    }
    Node get(char ch){
        return children[ch - 'a'];
    }
    void put(char ch, Node node){
        children[ch - 'a'] = node;
    }
    void setEnd(){
        isEnd = true;
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
        Node node = root;
        for(int i = 0;i<word.length();i++){
            if(!node.containsCh(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            if(!curr.containsCh(word.charAt(i)))return false;
            curr = curr.get(word.charAt(i));
        }
        if(curr.isEnd())return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0;i<prefix.length();i++){
            if(!curr.containsCh(prefix.charAt(i)))return false;
            curr = curr.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */