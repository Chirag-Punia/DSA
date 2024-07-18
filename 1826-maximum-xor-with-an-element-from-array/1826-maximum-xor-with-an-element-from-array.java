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
    public int[] maximizeXor(int[] nums, int[][] q) {
        Trie trie = new Trie();
        int[] results = new int[q.length];
        
    
        int[][] extendedQueries = new int[q.length][3];
        for (int i = 0; i < q.length; i++) {
            extendedQueries[i][0] = q[i][0]; 
            extendedQueries[i][1] = q[i][1];  
            extendedQueries[i][2] = i;  
        }
        

        Arrays.sort(nums);

        Arrays.sort(extendedQueries, (a, b) -> Integer.compare(a[1], b[1]));
        
        int index = 0;
        for (int[] query : extendedQueries) {
            int xi = query[0];
            int mi = query[1];
            int originalIndex = query[2];
            
           
            while (index < nums.length && nums[index] <= mi) {
                trie.insert(nums[index]);
                index++;
            }
            
            
            if (index == 0) {
                results[originalIndex] = -1; 
            } else {
                results[originalIndex] = trie.getMax(xi);
            }
        }
        
        return results; 

        //BRUTE FORCE
        // int[] arr = new int[q.length];
        // int k = 0;
        // for(int i = 0;i<q.length;i++){
        //     int ans = -1;
        //     for(int j = 0;j<n.length;j++){
        //         if(n[j] <= q[i][1] && (n[j]^q[i][0]) > ans){
        //             ans = n[j]^q[i][0];  
        //         }
        //         arr[k] = ans;
        //     }
        //     k++;
        // }
        // return arr;
    }
}