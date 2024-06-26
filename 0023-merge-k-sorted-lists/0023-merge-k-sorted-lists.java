/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static class Pair implements Comparable<Pair>{
        int i;
        ListNode node;
        Pair(int i,ListNode node){
            this.i = i;
            this.node = node;
        }
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.i, other.i);
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0 ){
            return null;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0; i<lists.length;i++){
            if(lists[i] != null){
                Pair temp = new Pair(lists[i].val,lists[i]);
                pq.offer(temp);
            }
            
        }
        ListNode temp = new ListNode(-1);
        ListNode ans = temp;
        while(!pq.isEmpty()){
            Pair x = pq.remove();

            ListNode dummy = new ListNode(x.i);
            temp.next = dummy;
            temp = temp.next;

            if(x.node.next != null){
                Pair xx = new Pair(x.node.next.val,x.node.next);
                pq.offer(xx);
            }
            
        }

        return ans.next;
        
    }
}