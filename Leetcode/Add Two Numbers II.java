/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node1 = reverse(l1);
        ListNode node2 = reverse(l2);

        int carry = 0;
        ListNode last = null;

        while (node1 != null && node2 != null) {

            ListNode temp = new ListNode((node1.val + node2.val + carry) % 10);
            carry = (node1.val + node2.val + carry) / 10;

            temp.next = last;
            last = temp;

            node1 = node1.next;
            node2 = node2.next;
        }

        while (node1 != null) {

            ListNode temp = new ListNode((node1.val + carry) % 10);
            carry = (node1.val + carry) / 10;

            temp.next = last;
            last = temp;

            node1 = node1.next;
        }

        while (node2 != null) {

            ListNode temp = new ListNode((node2.val + carry) % 10);
            carry = (node2.val + carry) / 10;

            temp.next = last;
            last = temp;

            node2 = node2.next;
        }

        if (carry != 0) {

            ListNode temp = new ListNode(carry);
            temp.next = last;
            last = temp;
        }

        return last;
    }

    private ListNode reverse(ListNode node) {

        ListNode pre = null, cur = node, next = null;

        while (cur != null) {

            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
