/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 遍历时直接改变方向
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /*
    // 前插法
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode start = pre.next;
        ListNode next = start.next;

        while (next != null) {
            start.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = start.next;
        }
        return dummy.next;
    }
    */
}
