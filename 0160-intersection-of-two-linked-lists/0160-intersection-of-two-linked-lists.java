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
    public static ListNode collision(ListNode a , ListNode b,int point){
        while(point > 0){
            b = b.next;
            point--;
        }
        while(a != null && b != null){
            if(a == b){
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while(a!=b){
            a = (a) == null?headB:a.next;
            b = (b) == null?headA:b.next;
        }
        return a;

        //OPTIMAL 1
        // ListNode a = headA;
        // ListNode b = headB;
        // int n1 = 0;
        // int n2 = 0;
        // while(a != null){
        //     n1++;
        //     a = a.next;
        // }
        // while(b != null){
        //     n2++;
        //     b = b.next;
        // }
        // a = headA;
        // b = headB;
        // if(n2 >= n1){
        //     return collision(a,b,n2-n1);
        // }
        // else{
        //     return collision(b,a,n1-n2);
        // }


        //BRUTE FORCE
        // HashMap<ListNode,Boolean> mpp = new HashMap<>();
        // ListNode a = headA;
        // ListNode b = headB;
        // while(a != null){
        //     mpp.put(a,true);
        //     a = a.next;
        // }
        // while(b != null){
        //     if(mpp.getOrDefault(b,false)) return b;
        //     b = b.next;
        // }
        // return null;
    }
}