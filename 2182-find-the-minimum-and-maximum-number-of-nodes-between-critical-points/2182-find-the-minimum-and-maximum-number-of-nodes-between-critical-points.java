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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        ListNode prev = head;
        ListNode curr = head;
        ListNode nxt = head.next;
        List<Integer> arr = new ArrayList<>();
        int k = 1;
        while(nxt != null){
            if(curr.val > nxt.val && curr.val > prev.val)arr.add(k);
            else if(curr.val < nxt.val && curr.val < prev.val)arr.add(k);
            prev = curr;
            curr = nxt;
            nxt = nxt.next;
            k++;
        }
        if (arr.size() < 2) {
            return new int[]{-1, -1};
        }
        int minDist = Integer.MAX_VALUE;
        int maxDist = arr.get(arr.size() - 1) - arr.get(0);
        
        for (int i = 1; i < arr.size(); i++) {
            int dist = arr.get(i) - arr.get(i - 1);
            if (dist < minDist) {
                minDist = dist;
            }
        }
        return new int[]{minDist, maxDist};
    }
}