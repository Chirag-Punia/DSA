class Node{
        boolean end;
        Node[] arr;
        Node(){
        this.end = false;
        this.arr = new Node[10];
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
                Node next = temp.arr[curr - '0'];
                if(next == null){
                    next = new Node();
                    temp.arr[curr - '0'] = next;

                }
                temp = next;

            }
            temp.end = true;
        }

        int search(String word){
            int n = word.length();
            Node temp = root;
            int cnt = 0;
            for(int i = 0;i<n;i++){
                char curr = word.charAt(i);
                Node next = temp.arr[curr - '0'];
                if(next == null)return cnt;;
                ++cnt;
                temp = next;
            }
            return cnt;
        }


    }
class Solution {
    
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie T = new Trie();
        int ans = 0;
        for(int a : arr2){
            T.insert(String.valueOf(a));
        }
        for(int a : arr1){
            String s = String.valueOf(a);
            ans = Math.max(ans,T.search(s));
            
        }
        return ans;
    }
}