/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Boolean> mpp = new HashMap<>();
        ListNode a = headA;
        ListNode b = headB;
        while(a != null){
            mpp.put(a,true);
            a = a.next;
        }
        while(b != null){
            if(mpp.getOrDefault(b,false)) return b;
            b = b.next;
        }
        return null;


    }
}