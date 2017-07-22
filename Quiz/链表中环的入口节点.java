/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        ListNode slow = pHead, fast = pHead;
        do {

            if (slow == null || fast.next == null) return null;

            slow = slow.next;
            fast = fast.next.next;

        } while (slow != fast);

        fast = pHead;
        while (slow != fast) {

            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
