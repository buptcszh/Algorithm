/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), ptr = head;
        
        boolean carry = false;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            
            int res = x + y;
            if (carry) res++;
            
            if (res > 9) {
                res -= 10;
                carry = true;
            } else {
                carry = false;
            }
            
            ListNode node = new ListNode(res);
            ptr.next = node;
            ptr = ptr.next;
            
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        
        if (carry) {
            ListNode node = new ListNode(1);
            ptr.next = node;
            ptr = ptr.next;            
        }
        
        return head.next;
    }
}