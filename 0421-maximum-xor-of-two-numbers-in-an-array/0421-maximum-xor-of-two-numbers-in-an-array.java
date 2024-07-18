class Node{
    Node[] children;
    Node(){
        this.children = new Node[2];
    }
    Node get(int bit){
        return children[bit];
    }
    void put(int bit, Node node){
        children[bit] = node;
    }
    boolean containsBit(int bit){
        return (children[bit] != null);
    }
}
class Trie{
    Node root;
    Trie(){
        this.root = new Node();
    }
    void insert(int num){
        Node curr = root;
        for(int i = 31;i>=0;i--){
            int bit = (num >> i) & 1;
            if(!curr.containsBit(bit))curr.put(bit,new Node());
            curr = curr.get(bit);
        }
    }
    int getMax(int num){
        Node curr = root;
        int maxNum = 0;
        for(int i = 31;i>=0;i--){
            int bit = ((num >> i) & 1);
            if(curr.containsBit(1 - bit)){
                maxNum = maxNum | (1<<i);
                curr = curr.get(1-bit);
            }
            else{
                curr = curr.get(bit);
            }
        }
        return maxNum;
    }
}
class Solution {

    
    public int findMaximumXOR(int[] nums) {
        Trie T = new Trie();
        int ans = 0;
        for(int n : nums){
            T.insert(n);
        }
        for(int n : nums){
            ans = Math.max(ans,T.getMax(n));
        }
        return ans;
        
    }
}