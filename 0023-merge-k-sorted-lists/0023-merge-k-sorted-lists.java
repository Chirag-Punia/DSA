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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i<lists.length;i++){
            while(lists[i] != null){
                pq.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        ListNode temp = new ListNode(-1);
        ListNode ans = temp;
        while(!pq.isEmpty()){
            ListNode dummy = new ListNode(pq.remove());
            temp.next = dummy;
            temp = temp.next;
        }

        return ans.next;
        
    }
}