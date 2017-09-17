/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count < k) {
            cur = cur.next;
            count++;
        }
        
        if (count == k) {
            cur = reverseKGroup(cur, k);

            // cur表示已反转部分的头结点
            // head表示待反转部分的头结点
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        
        return head;
    }
}