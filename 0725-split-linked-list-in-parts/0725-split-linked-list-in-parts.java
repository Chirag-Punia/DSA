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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode [] res = new ListNode[k];
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n += 1;
            curr = curr.next;
        }
        int size = n / k;
        int rem = n % k;
        curr = head;
        ListNode prev = head;
        for (int i = 0 ; i < k ; i++) {
            ListNode part = curr;
            int partSize = size;
            if (rem > 0) {
                rem -= 1;
                partSize += 1;
            }
            for (int j = 0 ; j < partSize ; j++) {
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) prev.next = null;
            res[i] = part;
        }
        return res;
    }
}