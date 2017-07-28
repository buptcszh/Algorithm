/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head, fast = head;
        // fast走两步，slow走一步，最后slow即指向中间
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 偶数时slow指向右边的节点
        if (fast != null) slow = slow.next;

        slow = reverse(slow);  // 反转slow开始的子链表
        fast = head;

        while (slow != null) {

            if (fast.val != slow.val) return false;

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reverse(ListNode root) {

        ListNode pre = null, node = root, next = null;
        while (node != null) {

            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        return pre;
    }
}
